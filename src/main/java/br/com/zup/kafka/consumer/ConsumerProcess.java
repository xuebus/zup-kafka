package br.com.zup.kafka.consumer;

import java.util.List;

import br.com.zup.kafka.KafkaMessage;
import br.com.zup.kafka.config.props.ConsumerProperties;
import br.com.zup.kafka.consumer.config.KMessageConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;

public class ConsumerProcess<K, V> implements Runnable {

    private final int id;
    private final List<String> topics;
    private final KMessageConsumer<K, V> messageConsumer;
    private final KafkaConsumer<K, KafkaMessage<V>> consumer;

    public ConsumerProcess(Integer id, ConsumerProperties<K, V> consumerProps) {
        this.id = id;
        this.topics = consumerProps.topics();
        this.messageConsumer = consumerProps.messageConsumer();
        this.consumer = new KafkaConsumer<>(consumerProps.properties());
    }

    @Override
    public void run() {
        try {
            consumer.subscribe(topics);

            while (true) {
                ConsumerRecords<K, KafkaMessage<V>> records = consumer.poll(Long.MAX_VALUE);
                for (ConsumerRecord<K, KafkaMessage<V>> record : records) {
                    messageConsumer.consume(id, record);
                }
            }
        } catch (WakeupException e) {
            // ignore for shutdown
        } finally {
            consumer.close();
        }
    }

    public void shutdown() {
        consumer.wakeup();
    }

}

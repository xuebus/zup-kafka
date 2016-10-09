package br.com.zup.kafka.consumer.consumer;

import br.com.zup.kafka.consumer.KafkaMessage;
import br.com.zup.kafka.consumer.config.props.ConsumerProperties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;

public class ConsumerProcess<K, V> implements Runnable {

    private final int id;
    private final ConsumerProperties<K, V> consumerProps;
    private final KafkaConsumer<K, KafkaMessage<V>> consumer;

    public ConsumerProcess(Integer id, ConsumerProperties<K, V> consumerProps) {
        consumerProps.validate();
        this.id = id;
        this.consumerProps = consumerProps;
        this.consumer = new KafkaConsumer<>(consumerProps.properties());
    }

    @Override
    public void run() {
        try {
            subscribe();

            while (true) {
                ConsumerRecords<K, KafkaMessage<V>> records = consumer.poll(Long.MAX_VALUE);
                for (ConsumerRecord<K, KafkaMessage<V>> record : records) {
                    consumerProps.getMessageConsumer().consume(id, record);
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

    private void subscribe() {

        if(consumerProps.isTopicByPattern()) {
            consumer.subscribe(consumerProps.getTopicPattern(), consumerProps.getConsumerRebalanceListener());
        } else {
            consumer.subscribe(consumerProps.getTopics());
        }

    }

}

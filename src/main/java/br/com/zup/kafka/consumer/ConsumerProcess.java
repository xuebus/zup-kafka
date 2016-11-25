package br.com.zup.kafka.consumer;

import br.com.zup.kafka.KafkaMessage;
import br.com.zup.kafka.config.props.ConsumerProperties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerProcess<K, V> implements Runnable {

    private final static Logger LOG = LoggerFactory.getLogger(ConsumerProcess.class.getName());

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
                checkIfCommitIsNecessary();
                records.forEach(this::invokeConsumerHandler);
            }
        } catch (WakeupException e) {
            // ignore for shutdown
        } finally {
            consumer.close();
        }
    }

    private void invokeConsumerHandler(ConsumerRecord<K, KafkaMessage<V>> record) {
        try {
            consumerProps.getMessageConsumer().consume(id, record);
        } catch (Throwable e) {
            LOG.error("Fail to consume message: '{}'", record == null ? "record is null" : record.toString(), e);
        }
    }

    private void checkIfCommitIsNecessary() {
        if (!consumerProps.isEnableAutoCommit()) {
            if (consumerProps.isCommitAsync()) {
                consumer.commitAsync();
            } else {
                consumer.commitSync();
            }
        }
    }

    public void shutdown() {
        consumer.wakeup();
    }

    private void subscribe() {

        if (consumerProps.isTopicByPattern()) {
            consumer.subscribe(consumerProps.getTopicPattern(), consumerProps.getConsumerRebalanceListener());
        } else {
            consumer.subscribe(consumerProps.getTopics());
        }

    }

}

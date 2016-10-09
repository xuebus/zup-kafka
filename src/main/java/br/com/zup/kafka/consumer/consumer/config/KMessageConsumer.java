package br.com.zup.kafka.consumer.consumer.config;

import br.com.zup.kafka.consumer.KafkaMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KMessageConsumer<K, V> {

    void consume(Integer threadId, ConsumerRecord<K, KafkaMessage<V>> consumerRecord);
}
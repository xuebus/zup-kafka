package br.com.zup.spring.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KMessageConsumer<K, V> {

    void consume(ConsumerRecord<K, V> consumerRecord);
}
package br.com.zup.spring.kafka.producer;

import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.zup.spring.kafka.config.props.ProducerProperties;

public class KafkaProducer<K, V> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private Producer<K, V> producer;

    public KafkaProducer(ProducerProperties props) {
        this.producer = new org.apache.kafka.clients.producer.KafkaProducer<>(props.properties());
    }
    
    public Future<RecordMetadata> send(String topic, V message) {
        return producer.send(new ProducerRecord<K, V>(topic, message));
    }
    
    public void close() {
        LOGGER.info("Destroying Kafka producer");
        if(producer != null) {
            producer.close();
        }
    }
}
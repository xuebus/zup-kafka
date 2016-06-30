package br.com.zup.spring.kafka.producer;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.zup.spring.kafka.util.PropertiesUtils;

public class KafkaProducer<K, V> {
    
    private static final Logger LOGGE = LoggerFactory.getLogger(KafkaProducer.class);

    @Qualifier("producerConfig")
    @Autowired
    private Properties configs;
    
    private Map<String, Object> customConfig;
    
    private Producer<K, V> producer;

    public KafkaProducer() {

    }

    public KafkaProducer(Map<String, Object> customConfig) {
        this.customConfig = customConfig;
    }
    
    @PostConstruct
    public void init() {
        if(customConfig != null) {
            PropertiesUtils.copyAllValids(customConfig, configs);
        }
        this.producer = new org.apache.kafka.clients.producer.KafkaProducer<>(configs);
    }
    
    
    public Future<RecordMetadata> send(String topic, V message) {
        return producer.send(new ProducerRecord<K, V>(topic, message));
    }
    
    
    @PreDestroy
    public void destroy() {
        LOGGE.info("Destroying Kafka producer");
        if(producer != null) {
            producer.close();
        }
    }
}
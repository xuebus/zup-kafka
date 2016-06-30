package br.com.zup.spring.kafka.consumer;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.zup.spring.kafka.util.PropertiesUtils;

public class KafkaConsumer<K, V> {
    
    private static final Logger LOGGE = LoggerFactory.getLogger(KafkaConsumer.class);

    @Qualifier("consumerConfig")
    @Autowired
    private Properties configs;
    
    private Map<String, Object> customConfig;
    
    private Consumer<K, V> consumer;

    public KafkaConsumer() {

    }

    public KafkaConsumer(Map<String, Object> customConfig) {
        this.customConfig = customConfig;
    }
    
    @PostConstruct
    public void init() {
        if(customConfig != null) {
            PropertiesUtils.copyAllValids(customConfig, configs);
        }
        this.consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<>(configs);
    }
    
    public void onMessage(List<String> topics, KMessageConsumer<K, V> messageConsumer) {
        
        consumer.subscribe(topics);
        
        while (true) {
             ConsumerRecords<K, V> records = consumer.poll(100);
             for (ConsumerRecord<K, V> record : records)
                 messageConsumer.consume(record);
         }
    }
    
    @PreDestroy
    public void destroy() {
        LOGGE.info("Destroying Kafka consumer");
        if(consumer != null) {
            consumer.close();
        }
    }
}
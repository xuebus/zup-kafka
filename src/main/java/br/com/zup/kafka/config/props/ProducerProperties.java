package br.com.zup.kafka.config.props;

import br.com.zup.kafka.config.props.core.GenericBuilder;
import org.apache.kafka.common.serialization.StringSerializer;

import br.com.zup.kafka.producer.serializer.JsonSerializer;

public class ProducerProperties extends GenericBuilder {

    ProducerProperties() {
        
    }
    
    public ProducerProperties withServers(String... servers) {
        props.put("bootstrap.servers", toCommaSeparated(servers));
        return this;
    }
    
    public ProducerProperties withKeySerializer(Class<?> clazz) {
        props.put("key.serializer", clazz.getName());
        return this;
    }
    
    public ProducerProperties withValueSerializer(Class<?> clazz) {
        props.put("value.serializer", clazz.getName());
        return this;
    }
    
    public ProducerProperties withAcks(String acks) {
        props.put("acks", acks);
        return this;
    }

    @Override
    public void addDefaults() {
        addIfNull("key.serializer", StringSerializer.class.getName());
        addIfNull("value.serializer", JsonSerializer.class.getName());
    }
}
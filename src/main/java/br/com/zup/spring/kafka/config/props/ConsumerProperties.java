package br.com.zup.spring.kafka.config.props;

import java.util.List;

import org.apache.kafka.common.serialization.StringDeserializer;

import br.com.zup.spring.kafka.config.props.core.GenericBuilder;
import br.com.zup.spring.kafka.consumer.config.KMessageConsumer;
import br.com.zup.spring.kafka.consumer.deserializer.JsonDeserializer;

public class ConsumerProperties<K, V> extends GenericBuilder {

    private List<String> topics;
    private KMessageConsumer<K, V> messageConsumer;

    ConsumerProperties(List<String> topics, KMessageConsumer<K, V> messageConsumer) {
        this.topics = topics;
        this.messageConsumer = messageConsumer;
    }

    public ConsumerProperties<K, V> withServers(String... servers) {
        props.put("bootstrap.servers", toCommaSeparated(servers));
        return this;
    }

    public ConsumerProperties<K, V> withKeyDeserializer(Class<?> clazz) {
        props.put("key.deserializer", clazz.getName());
        return this;
    }

    public ConsumerProperties<K, V> withValueDeserializer(Class<?> clazz) {
        props.put("value.deserializer", clazz.getName());
        return this;
    }

    public ConsumerProperties<K, V> withGroupId(String groupId) {
        props.put("group.id", groupId);
        return this;
    }

    public ConsumerProperties<K, V> withDeserializerClass(Class<?> clazz) {
        props.put("deserializer.class", clazz.getName());
        if (clazz != String.class && !isPropertyPresent("value.deserializer")) {
            withValueDeserializer(JsonDeserializer.class);
        }
        return this;
    }

    public ConsumerProperties<K, V> withTopics(List<String> topics) {
        this.topics = topics;
        return this;
    }

    public List<String> topics() {
        return topics;
    }

    public KMessageConsumer<K, V> messageConsumer() {
        return messageConsumer;
    }

    @Override
    public void addDefaults() {
        addIfNull("key.deserializer", StringDeserializer.class.getName());
        addIfNull("value.deserializer", StringDeserializer.class.getName());
    }
}

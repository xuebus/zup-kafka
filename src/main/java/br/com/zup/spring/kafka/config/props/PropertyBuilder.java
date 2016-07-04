package br.com.zup.spring.kafka.config.props;

import java.util.List;

import br.com.zup.spring.kafka.consumer.config.KMessageConsumer;

public class PropertyBuilder {
    
    public static <K, V> ConsumerProperties<K, V> consumer(List<String> topics, KMessageConsumer<K, V> messageConsumer) {
        return new ConsumerProperties<K, V>(topics, messageConsumer);
    }
    
    public static ProducerProperties producer() {
        return new ProducerProperties();
    }
    
    public static ProducerProperties producer(String... servers) {
        return new ProducerProperties().withServers(servers);
    }
    
}

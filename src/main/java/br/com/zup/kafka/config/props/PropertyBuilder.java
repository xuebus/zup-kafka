package br.com.zup.kafka.consumer.config.props;

import br.com.zup.kafka.consumer.consumer.config.KMessageConsumer;

public class PropertyBuilder {
    
    public static <K, V> ConsumerProperties<K, V> consumer(KMessageConsumer<K, V> messageConsumer) {
        return new ConsumerProperties<K, V>(messageConsumer);
    }

    public static ProducerProperties producer() {
        return new ProducerProperties();
    }
    
    public static ProducerProperties producer(String... servers) {
        return new ProducerProperties().withServers(servers);
    }
    
}
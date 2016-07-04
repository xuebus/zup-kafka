package br.com.zup.spring.kafka.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import br.com.zup.spring.kafka.config.props.ConsumerProperties;

public class ConsumerRunner {
    
    public static <K, V> ExecutorService execute(Integer numThreads, ConsumerProperties<K, V> props) {
        
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        
        final List<ConsumerProcess<K, V>> processes = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            ConsumerProcess<K, V> consumer = new ConsumerProcess<>(i, props);
            processes.add(consumer);
            executor.submit(consumer);
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                for (ConsumerProcess<K, V> process : processes) {
                    process.shutdown();
                }
                executor.shutdown();
                try {
                    executor.awaitTermination(5000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        return executor;
        
    }
    
    public static <K, V> ExecutorService execute(ConsumerProperties<K, V> props) {
        Integer cores = Runtime.getRuntime().availableProcessors();
        return execute(cores, props);
    }
    
    
}
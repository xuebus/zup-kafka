package br.com.zup.kafka.consumer;

import br.com.zup.kafka.consumer.consumer.config.KMessageConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GenericConsumerHandler<T> implements KMessageConsumer<String, T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericConsumerHandler.class);

    CountDownLatch latch;

    public void setCountDown(int n) {
        this.latch = new CountDownLatch(n);
    }

    public boolean await() {
        try {
            return this.latch.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void consume(Integer threadId, ConsumerRecord<String, KafkaMessage<T>> consumerRecord) {
        LOGGER.info(consumerRecord.value().getPayload().toString());
        latch.countDown();
    }
}

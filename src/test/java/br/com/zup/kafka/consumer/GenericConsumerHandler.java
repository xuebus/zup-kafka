package br.com.zup.kafka.consumer;

import br.com.zup.kafka.KafkaMessage;
import br.com.zup.kafka.consumer.config.KMessageConsumer;
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
        final T payload = consumerRecord.value().getPayload();
        LOGGER.info(payload != null ? payload.toString() : "ConsumerHandler ignore invalid message");
        latch.countDown();
    }
}

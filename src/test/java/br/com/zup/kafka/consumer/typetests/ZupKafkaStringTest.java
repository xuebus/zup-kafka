package br.com.zup.kafka.consumer.typetests;

import br.com.zup.kafka.consumer.config.props.ConsumerProperties;
import br.com.zup.kafka.consumer.config.props.OffsetReset;
import br.com.zup.kafka.consumer.config.props.ProducerProperties;
import br.com.zup.kafka.consumer.config.props.PropertyBuilder;
import br.com.zup.kafka.consumer.consumer.ConsumerRunner;
import br.com.zup.kafka.consumer.TestConfigs;
import br.com.zup.kafka.consumer.GenericConsumerHandler;
import br.com.zup.kafka.consumer.producer.KafkaProducer;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ZupKafkaStringTest {

    private static final String TOPIC = "zup_kafka_string_topic";

    private static final Logger LOGGER = LoggerFactory.getLogger(ZupKafkaStringTest.class);

    private static KafkaProducer<String, String> producer;

    private static ExecutorService consumerExecutorService;

    private static GenericConsumerHandler<String> stringConsumerHandler = new GenericConsumerHandler<>();

    @BeforeClass
    public static void beforeClass() {
        ProducerProperties props = PropertyBuilder.producer(TestConfigs.KAFKA_BOOTSTRAP_SERVERS);
        producer = new KafkaProducer<>(props);

        ConsumerProperties<String, String> consumerProperties = PropertyBuilder
                .consumer(stringConsumerHandler)
                .withTopics(Collections.singletonList(TOPIC))
                .withServers(TestConfigs.KAFKA_BOOTSTRAP_SERVERS)
                .withGroupId(TestConfigs.KAFKA_DEFAULT_GROUP_ID)
                .withDeserializerClass(String.class)
                .withAutoOffsetReset(OffsetReset.EARLIEST);

        consumerExecutorService = ConsumerRunner.execute(TestConfigs.KAFKA_DEFAULT_CONSUMER_POOL_SIZE, consumerProperties);
    }

    @AfterClass
    public static void afterClass() throws InterruptedException {
        producer.close();
        consumerExecutorService.shutdown();
        consumerExecutorService.awaitTermination(10, TimeUnit.SECONDS);

    }

    @Test
    public void stringTest() throws ExecutionException, InterruptedException {
        stringConsumerHandler.setCountDown(1);
        producer.send(TOPIC, "stringTestMsg").get();
        Assert.assertEquals(stringConsumerHandler.await(), true);
    }



}


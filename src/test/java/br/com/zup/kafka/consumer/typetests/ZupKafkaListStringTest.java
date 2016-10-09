package br.com.zup.kafka.consumer.typetests;

import br.com.zup.kafka.consumer.TestConfigs;
import br.com.zup.kafka.consumer.config.props.ConsumerProperties;
import br.com.zup.kafka.consumer.config.props.OffsetReset;
import br.com.zup.kafka.consumer.config.props.ProducerProperties;
import br.com.zup.kafka.consumer.config.props.PropertyBuilder;
import br.com.zup.kafka.consumer.consumer.ConsumerRunner;
import br.com.zup.kafka.consumer.GenericConsumerHandler;
import br.com.zup.kafka.consumer.producer.KafkaProducer;
import br.com.zup.kafka.consumer.util.JavaTypeBuilder;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ZupKafkaListStringTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZupKafkaListStringTest.class);

    private static final String TOPIC = "zup_kafka_list_string_topic";

    private static KafkaProducer<String, List<String>> producer;

    private static ExecutorService consumerExecutorService;

    private static GenericConsumerHandler<List<String>> listStringConsumerHandler = new GenericConsumerHandler<>();

    @BeforeClass
    public static void beforeClass() {
        ProducerProperties props = PropertyBuilder.producer(TestConfigs.KAFKA_BOOTSTRAP_SERVERS);
        producer = new KafkaProducer<>(props);

        ConsumerProperties<String, List<String>> consumerProperties = PropertyBuilder
                .consumer(listStringConsumerHandler)
                .withTopics(Collections.singletonList(TOPIC))
                .withServers(TestConfigs.KAFKA_BOOTSTRAP_SERVERS)
                .withGroupId(TestConfigs.KAFKA_DEFAULT_GROUP_ID)
                .withDeserializerType(JavaTypeBuilder.build(List.class, String.class))
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
    public void listStringTest() throws ExecutionException, InterruptedException {
        listStringConsumerHandler.setCountDown(1);
        producer.send(TOPIC, Collections.singletonList("listStringTestMsg")).get();
        Assert.assertEquals(listStringConsumerHandler.await(), true);
    }



}


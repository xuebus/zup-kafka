package br.com.zup.kafka.consumer.typetests;

import br.com.zup.kafka.consumer.GenericConsumerHandler;
import br.com.zup.kafka.consumer.TestConfigs;
import br.com.zup.kafka.consumer.config.props.ConsumerProperties;
import br.com.zup.kafka.consumer.config.props.OffsetReset;
import br.com.zup.kafka.consumer.config.props.ProducerProperties;
import br.com.zup.kafka.consumer.config.props.PropertyBuilder;
import br.com.zup.kafka.consumer.consumer.ConsumerRunner;
import br.com.zup.kafka.consumer.producer.KafkaProducer;
import br.com.zup.kafka.consumer.util.JavaTypeBuilder;
import br.com.zup.kafka.consumer.utils.SampleTO;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ZupKafkaListObjectTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZupKafkaListObjectTest.class);

    private static final String TOPIC = "zup_kafka_list_object_topic";

    private static KafkaProducer<String, List<SampleTO>> producer;

    private static ExecutorService consumerExecutorService;

    private static GenericConsumerHandler<List<SampleTO>> listObjectConsumerHandler = new GenericConsumerHandler<>();

    @BeforeClass
    public static void beforeClass() {
        ProducerProperties props = PropertyBuilder.producer(TestConfigs.KAFKA_BOOTSTRAP_SERVERS);
        producer = new KafkaProducer<>(props);

        ConsumerProperties<String, List<SampleTO>> consumerProperties = PropertyBuilder
                .consumer(listObjectConsumerHandler)
                .withTopics(Collections.singletonList(TOPIC))
                .withServers(TestConfigs.KAFKA_BOOTSTRAP_SERVERS)
                .withGroupId(TestConfigs.KAFKA_DEFAULT_GROUP_ID)
                .withDeserializerType(JavaTypeBuilder.build(List.class, SampleTO.class))
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
    public void listObjectTest() throws ExecutionException, InterruptedException {
        listObjectConsumerHandler.setCountDown(1);
        producer.send(TOPIC, Collections.singletonList(new SampleTO("listObjectTestMsg"))).get();
        Assert.assertEquals(listObjectConsumerHandler.await(), true);
    }



}


package br.com.zup.kafka.consumer;

import java.util.regex.Pattern;

public class TestConfigs {

    public static final String KAFKA_BOOTSTRAP_SERVERS = "localhost:9092";

    public static final String KAFKA_DEFAULT_GROUP_ID = "zup_kafka_group_1";

    public static final Pattern KAFKA_DEFAULT_TOPIC_PATTERN = Pattern.compile("zup_kafka(.)*");

    public static final int KAFKA_DEFAULT_CONSUMER_POOL_SIZE = 1;

}


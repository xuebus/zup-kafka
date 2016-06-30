# Producer

Below are some detailed steps required to set up a Kafka consumer.

#### kafka-producer.properties
-----
This file should contain the configuration required to start a Kafka producer. The settings in this file are global, but they can be replaced for a custom configuration.

To find out what settings are available, please access the link:[http://kafka.apache.org/documentation.html#producerconfigs](http://kafka.apache.org/documentation.html#producerconfigs)

> All confiurações this file must have the prefix **producer**
> Example: **producer.**bootstrap.servers

```property
producer.bootstrap.servers=broker_host
producer.value.serializer=br.com.zup.spring.kafka.producer.serializer.JsonSerializer
```

#### Spring Context
-----

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context" xmlns:util="http://www.springframework.org/schema/util"
	xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/util
        http://www.springframework.org/schema/util/spring-util-3.0.xsd">

    <!-- Optional, used for customize producer configs -->
    <util:map id="kafkaProducerConfig">
        <entry key="config.key" value="xxx"/>
        <entry key="consumer.value.deserializer" value="br.com.zup.spring.kafka.consumer.deserializer.JsonDeserializer"/>
    </util:map>
    
    <!-- Default Kafka producer. Use only kafka-producer.properties configurations -->
    <bean id="kafkaProducer" class="br.com.zup.spring.kafka.producer.KafkaProducer" />
    
    <!-- Custom Kafka producer. Use kafka-producer.properties and custom configurations -->
	<bean id="kafkaProducerCustom" class="br.com.zup.spring.kafka.producer.KafkaProducer">
	   <constructor-arg ref="kafkaProducerConfig" />
	</bean> 

</beans>
```

#### Example (Spring)
-----

```java

import br.com.zup.spring.kafka.producer.KafkaProducer;
...others imports...

public class Example {

    //Default producer
    @Qualifier("kafkaProducer")
    @Autowired
    private KafkaProducer<String, String> producer;
    
    //Custom producer
    @Qualifier("kafkaProducerCustom")
    @Autowired
    private KafkaProducer<String, Object> kafkaProducerCustom;

    public void send() throws Exception {
        
        Future<RecordMetadata> futureRecord = producer.send("topic-name", "string message");
        RecordMetadata record = futureRecord.get();
        System.out.println("Timestamp: " + record.timestamp());
        
        Future<RecordMetadata> customFutureRecord = kafkaProducerCustom.send("topic-name", new Customer(1, "Rodrigo"));
        RecordMetadata customRecord = customFutureRecord.get();
        System.out.println("Timestamp: " + customRecord.timestamp());
    }

}

```

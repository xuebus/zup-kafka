package br.com.zup.kafka.consumer.deserializer;

import br.com.zup.kafka.KafkaMessage;
import br.com.zup.kafka.util.JavaTypeBuilder;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class JsonDeserializer implements Deserializer<Object> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonDeserializer.class);

    private static final ObjectMapper MAPPER = new ObjectMapper().registerModule(new JavaTimeModule());

    private JavaType type;

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Object deserializerType = configs.get("deserializer.type");
        if (deserializerType == null) {
            throw new SerializationException("Property [deserializer.type] must be informed");
        }
        if (deserializerType instanceof Class) {
            type = JavaTypeBuilder.build(KafkaMessage.class, (Class) deserializerType);
        } else if (deserializerType instanceof JavaType) {
            type = JavaTypeBuilder.build(KafkaMessage.class, (JavaType) deserializerType);
        } else {
            throw new SerializationException("Invalid type of [deserializer.type]. Class or JavaType required. Found: " + deserializerType);
        }
    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        try {
            return MAPPER.readValue(data, type);
        } catch (IOException e) {
            LOGGER.error("Error when deserializing byte[] to object", e);
            throw new SerializationException("Error when deserializing byte[] to object", e);
        }
    }

    @Override
    public void close() {
    }

}

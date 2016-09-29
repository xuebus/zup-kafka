package br.com.zup.kafka.consumer.deserializer;

import br.com.zup.kafka.KafkaMessage;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class JsonDeserializer implements Deserializer<Object> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonDeserializer.class);

    private static final ObjectMapper MAPPER = new ObjectMapper().registerModule(new JavaTimeModule());

    private Class<?> clazz;

    private JavaType type;

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

        try {
            String deserializerClazz = (String) configs.get("deserializer.class");
            if (StringUtils.isEmpty(deserializerClazz)) {
                throw new SerializationException("Property [deserializer.class] must be informed");
            }
            clazz = Class.forName(deserializerClazz);
            type = MAPPER.getTypeFactory().constructParametrizedType(KafkaMessage.class, KafkaMessage.class, clazz);
        } catch (ClassNotFoundException e) {
            throw new SerializationException("Error when configure deserializeble class. Class: " + clazz + " not found in context", e);
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

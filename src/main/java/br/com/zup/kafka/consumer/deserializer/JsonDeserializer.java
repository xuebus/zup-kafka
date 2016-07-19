package br.com.zup.kafka.consumer.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

public class JsonDeserializer implements Deserializer<Object> {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private Class<?> clazz;

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

        try {
            String deserializerClazz = (String) configs.get("deserializer.class");
            if (StringUtils.isEmpty(deserializerClazz)) {
                throw new SerializationException("Property [deserializer.class] must be informed");
            }
            clazz = Class.forName(deserializerClazz);
        } catch (ClassNotFoundException e) {
            throw new SerializationException("Error when configure deserializeble class. Class: " + clazz + " not found in context", e);
        }
    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        try {
            return MAPPER.readValue(data, clazz);
        } catch (IOException e) {
            throw new SerializationException("Error when deserializing byte[] to object", e);
        }
    }

    @Override
    public void close() {

    }

}

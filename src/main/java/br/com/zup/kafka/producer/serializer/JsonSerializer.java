package br.com.zup.kafka.producer.serializer;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerializer implements Serializer<Object> {
    
    private static final ObjectMapper MAPPER = new ObjectMapper().registerModule(new JavaTimeModule());
    
    private String encoding = "UTF8";
    
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        
    }

    @Override
    public byte[] serialize(String topic, Object data) {
        
        try {
            if (data == null) {
                return null;
            }
            return MAPPER.writeValueAsString(data).getBytes(encoding);
        } catch (UnsupportedEncodingException | JsonProcessingException e) {
            throw new SerializationException("Error when serializing object to byte[]", e);
        }
    }

    @Override
    public void close() {
        
    }

}

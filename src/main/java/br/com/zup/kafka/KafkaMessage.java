package br.com.zup.kafka;

import java.util.HashMap;
import java.util.Map;

public class KafkaMessage<V> {

    private Map<String, Object> headers;
    private V value;

    public KafkaMessage(Map<String, Object> headers, V value) {
        this.headers = headers;
        this.value = value;
    }

    public static <V> KafkaMessage<V> of(V value) {
        return new KafkaMessage<>(null, value);
    }

    public static <V> KafkaMessage<V> of(V value, Map<String, Object> headers) {
        return new KafkaMessage<>(headers, value);
    }

    public Map<String, Object> getHeaders() {
        return headers;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setHeaders(Map<String, Object> headers) {
        this.headers = headers;
    }

    public void addHeader(String key, Object value) {
        if (this.headers == null) {
            this.headers = new HashMap<>();
        }
        this.headers.put(key, value);
    }

}
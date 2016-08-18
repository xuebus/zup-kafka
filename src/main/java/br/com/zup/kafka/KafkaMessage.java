package br.com.zup.kafka;

import java.util.HashMap;
import java.util.Map;

public class KafkaMessage<V> {

    private Map<String, String> headers;
    private V payload;

    private KafkaMessage() {}

    private KafkaMessage(V payload, Map<String, String> headers) {
        this.payload = payload;
        this.headers = headers;
    }

    public static <V> KafkaMessage<V> of(V value) {
        return new KafkaMessage<>(value, null);
    }

    public static <V> KafkaMessage<V> of(V value, Map<String, String> headers) {
        return new KafkaMessage<>(value, headers);
    }

    public V getPayload() {
        return payload;
    }

    public void setPayload(V payload) {
        this.payload = payload;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setHeader(String key, String value) {
        if (this.headers == null) {
            this.headers = new HashMap<>();
        }
        this.headers.put(key, value);
    }

    public String getHeader(String key) {
        if (this.headers != null) {
            this.headers.get(key);
        }
        return null;
    }

    public String removeHeader(String key) {
        if (this.headers != null) {
            return this.headers.remove(key);
        }
        return null;
    }

}
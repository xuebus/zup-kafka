package br.com.zup.spring.kafka.util;

import java.util.Map;
import java.util.Properties;

public final class PropertiesUtils {

    public static void putIfValid(Properties props, String key, Object value) {
        if(value != null) {
            props.put(key, value);
        }
    }
    
    public static void copyAllValids(Properties source, Properties destination) {
        source.forEach((k,v) -> {
            if(v != null) {
                destination.put(k, v);
            }
        });
    }
    
    public static void copyAllValids(Map<String, Object> source, Properties destination) {
        source.forEach((k,v) -> {
            if(v != null) {
                destination.put(k, v);
            }
        });
    }
}
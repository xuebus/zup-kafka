package br.com.zup.kafka.consumer.config.props.core;

import java.util.Properties;

public abstract class GenericBuilder {

    protected Properties props = new Properties();

    public String toCommaSeparated(String... list) {
        StringBuilder result = new StringBuilder();
        for (String value : list) {
            result.append(value).append(",");
        }
        result.setLength(result.length() - 1);
        return result.toString();
    }

    public abstract void addDefaults();

    public GenericBuilder property(String key, Object value) {
        props.put(key, value);
        return this;
    }

    public Properties properties() {
        addDefaults();
        return props;
    }

    public void addIfNull(String key, Object value) {
        if (!isPropertyPresent(key)) {
            props.put(key, value);
        }
    }

    public boolean isPropertyPresent(String key) {
        return props.get(key) != null;
    }
}

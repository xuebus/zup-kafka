package br.com.zup.kafka.consumer.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Collection;

public class JavaTypeBuilder {

    private static final ObjectMapper MAPPER = new ObjectMapper().registerModule(new JavaTimeModule());


    /**
     * Example: KafkaMessage&lt;List&lt;String&gt;&gt;
     * <pre>
     * <code>JavaType listOfStringType = JavaTypeBuilder.build(List.class, String.class);
     * JavaType messageOfListOfStringType = JavaTypeBuilder.build(KafkaMessage.class, listOfStringType);
     * </code>
     * </pre>
     * @param parametrized .
     * @param parameters .
     * @return .
     */
    public static JavaType build(Class<?> parametrized, Class... parameters) {
        Assert.notNull(parametrized);
        Assert.notNull((Object)parameters);
        if (Collection.class.isAssignableFrom(parametrized)) {
            Assert.assertTrue(parameters.length == 1, "wrong number os parameters");
            Class<? extends Collection> c = (Class<? extends Collection>)parametrized;
            return MAPPER.getTypeFactory().constructCollectionType(c, parameters[0]);
        } else {
            return MAPPER.getTypeFactory().constructParametrizedType(parametrized, parametrized, parameters);
        }
    }


    /**
     * Example: KafkaMessage&lt;List&lt;String&gt;&gt;
     * <pre>
     * <code>JavaType listOfStringType = JavaTypeBuilder.build(List.class, String.class);
     * JavaType messageOfListOfStringType = JavaTypeBuilder.build(KafkaMessage.class, listOfStringType);
     * </code>
     * </pre>
     * @param parametrized .
     * @param parameters .
     * @return .
     */
    public static JavaType build(Class<?> parametrized, JavaType... parameters) {
        Assert.notNull(parametrized);
        Assert.notNull((Object)parameters);
        if (Collection.class.isAssignableFrom(parametrized)) {
            Assert.assertTrue(parameters.length == 1, "wrong number os parameters");
            Class<? extends Collection> c = (Class<? extends Collection>)parametrized;
            return MAPPER.getTypeFactory().constructCollectionType(c, parameters[0]);
        } else {
            return MAPPER.getTypeFactory().constructParametrizedType(parametrized, parametrized, parameters);
        }
    }

}


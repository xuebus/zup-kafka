package br.com.zup.kafka.consumer.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

public final class Assert {

    private Assert() {}

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notNull(Object object) {
        notNull(object, "[Assertion failed] - this argument is required; it must not be null");
    }

    public static void notNull(Object... objects) {
        for (Object o : objects) {
            notNull(o);
        }
    }

    public static void notEmpty(String string, String message) {
        if (StringUtils.isBlank(string)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(String string) {
        notEmpty(string,
                "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank");
    }

    public static void notEmpty(Collection<?> collection, String message) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(Collection<?> collection) {
        notEmpty(collection, "[Assertion failed] - this Collection argument must not be empty");
    }

    public static void greaterThan(Number number, Number minValue, String message) {
        if (number.longValue() <= minValue.longValue()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void greaterThan(Number number, Number minValue) {
        greaterThan(number, minValue, "[Assertion failed] - this number argument must greater than a min value");
    }

    public static void greaterThanZero(Number... numbers) {
        for (Number n : numbers) {
            greaterThan(n, 0, "[Assertion failed] - this number argument must greater than zero");
        }
    }

    public static void assertFalse(boolean assertion, String message) {
        if (assertion) {
            throw new IllegalArgumentException("[Assertion failed] - " + message);
        }
    }

    public static void assertTrue(boolean assertion, String message) {
        if (!assertion) {
            throw new IllegalArgumentException("[Assertion failed] - " + message);
        }
    }
}

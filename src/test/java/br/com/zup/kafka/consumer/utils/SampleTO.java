package br.com.zup.kafka.consumer.utils;

import java.time.LocalDate;

public class SampleTO {

    private String testField;
    private LocalDate date;

    public SampleTO() {
    }

    public SampleTO(String testField, LocalDate date) {
        this.testField = testField;
        this.date = date;
    }

    public String getTestField() {
        return testField;
    }

    public void setTestField(String testField) {
        this.testField = testField;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SampleTO{");
        sb.append("testField='").append(testField).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

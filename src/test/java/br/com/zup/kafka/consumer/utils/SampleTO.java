package br.com.zup.kafka.consumer.utils;

public class SampleTO {

    private String testField;

    public SampleTO() {
    }

    public SampleTO(String testField) {
        this.testField = testField;
    }

    public String getTestField() {
        return testField;
    }

    public void setTestField(String testField) {
        this.testField = testField;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SampleTO{");
        sb.append("testField='").append(testField).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

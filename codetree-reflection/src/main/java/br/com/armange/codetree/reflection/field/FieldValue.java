package br.com.armange.codetree.reflection.field;

public class FieldValue {
    private final Object value;
    private final Exception exception;
    
    public FieldValue(final Object value, final Exception exception) {
        this.value = value;
        this.exception = exception;
    }

    public Object getValue() {
        return value;
    }

    public Exception getException() {
        return exception;
    }
}

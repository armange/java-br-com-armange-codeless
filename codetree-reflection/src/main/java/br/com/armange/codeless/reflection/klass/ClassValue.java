package br.com.armange.codeless.reflection.klass;

public class ClassValue {
    private final Class<?> value;
    private final Exception exception;
    
    public ClassValue(final Class<?> value, final Exception exception) {
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

package br.com.armange.codeless.reflection.field;

public class FieldReflection {
    
    private FieldReflection() {}
    
    public static FieldFilter ofField(final String fieldName) {
        return new FieldFilter(fieldName);
    }
}

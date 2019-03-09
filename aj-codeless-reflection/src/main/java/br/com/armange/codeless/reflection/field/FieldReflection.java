package br.com.armange.codeless.reflection.field;

public class FieldReflection {
    
    private final FieldFilter fieldFilter;
    
    private FieldReflection(final Class<?> sourceClass) {
        fieldFilter = new FieldFilter(sourceClass);
    }
    
    public FieldReflection fromClass(final Class<?> sourceClass) {
        return new FieldReflection(sourceClass);
    }
    
    
}

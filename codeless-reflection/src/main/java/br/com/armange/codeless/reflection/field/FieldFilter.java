package br.com.armange.codeless.reflection.field;

import br.com.armange.codeless.reflection.exception.ReflectionException;

public class FieldFilter {

    private String fieldName;
    private boolean useGetterIfExists;
    private boolean useSetterIfExists;

    FieldFilter(final String fieldName) {
        this.fieldName = fieldName;
    }
    
    public FieldOperations ofInstance(final Object instance) {
        try {
            return new FieldOperations(
                    instance.getClass().getDeclaredField(fieldName), 
                    instance,
                    useGetterIfExists,
                    useSetterIfExists);
        } catch (final NoSuchFieldException | SecurityException e) {
            throw new ReflectionException(e);
        }
    }
    
    private void usingGetterIfExists() {
        this.useGetterIfExists = true;
    }
    
    private void usingSetterIfExists() {
        this.useSetterIfExists = true;
    }
}

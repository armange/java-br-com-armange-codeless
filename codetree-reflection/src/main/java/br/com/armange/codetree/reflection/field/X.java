package br.com.armange.codetree.reflection.field;

import br.com.armange.codetree.reflection.exception.ReflectionException;

public class X {

    private String fieldName;
    private boolean useGetterIfExists;
    private boolean useSetterIfExists;

    X(final String fieldName) {
        this.fieldName = fieldName;
    }
    
    public SingleFieldOperations ofInstance(final Object instance) {
        try {
            return new SingleFieldOperations(
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

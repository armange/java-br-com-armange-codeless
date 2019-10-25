package br.com.armange.codeless.reflection.field;

import java.lang.reflect.Field;
import java.util.function.BiFunction;

import br.com.armange.codeless.reflection.exception.ReflectionException;

public class SingleFieldOperations {

    private Field field;
    private Object instance;
    private boolean useGetterIfExists;
    private boolean useSetterIfExists;
    
    SingleFieldOperations(final Field field, 
            final Object instance, 
            final boolean useGetterIfExists, 
            final boolean useSetterIfExists) {
        this.field = field;
        this.instance = instance;
        this.useGetterIfExists = useGetterIfExists;
        this.useSetterIfExists = useSetterIfExists;
    }

    public Field getField() {
        return field;
    }
    
    public void setValue(final BiFunction<Field, Object, Object> handler, final Object value) {
        setValue(handler.apply(field, value));
    }
    
    public void setValue(final Object value) {
        if (useSetterIfExists) {
            //Not implemented.
        } else {
            setValueDirectlyInTheField(value);
        }
    }

    private void setValueDirectlyInTheField(final Object value) {
        try {
            field.setAccessible(true);
            field.set(instance, value);
        } catch (final IllegalArgumentException | IllegalAccessException e) {
            throw new ReflectionException(e);
        }
    }
}

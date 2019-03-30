package br.com.armange.codeless.reflection.field;

import java.lang.reflect.Field;
import java.util.function.Function;

public class FieldReflectionClosures {

    public static Function<? super Field, ? extends FieldValue> mapToFieldValue(final Object enclosingInstance) {
        return f -> {
            FieldValue fieldValue = null;
            
            try {
                f.setAccessible(true);
                
                fieldValue = new FieldValue(f.get(enclosingInstance), null);
            } catch (final IllegalArgumentException | IllegalAccessException e) {
                fieldValue = new FieldValue(null, e);
            }
            
            return fieldValue;
        };
    }
    
    public static Function<? super Field, ? extends Object> mapToValue(final Object enclosingInstance) {
        return f -> {
            try {
                f.setAccessible(true);
                
                return f.get(enclosingInstance);
            } catch (final IllegalArgumentException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        };
    }
}

package br.com.armange.codeless.reflection.field;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Stream;

class FieldFilter {
    private final Class<?> sourceClass;
    
    FieldFilter(final Class<?> sourceClass) {
        Objects.requireNonNull(sourceClass);
        
        ResourceBundle bundle = ResourceBundle.getBundle("");
        this.sourceClass = sourceClass;
    }
    
    public Stream<Field> stream(){
        return null;
    }

    public Class<?> getSourceClass() {
        return sourceClass;
    }
}

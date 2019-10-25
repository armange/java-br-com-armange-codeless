package br.com.armange.codeless.reflection.field;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AnnotatedFieldFilter {

    private Map<String, Object> attributeValues;
    private Annotation annotation;
    
    AnnotatedFieldFilter(final Annotation annotation) {
        this.annotation = annotation;
    }
    
    public AnnotatedFieldFilter havingAttribute(final String attributeName, final Object attributeValue) {
        getAttributeValues().put(attributeName, attributeValue);
        
        return this;
    }
    
    public SingleFieldOperations ofInstance(final Object instance) {
        Stream
            .of(instance.getClass().getDeclaredFields())
            .filter(applyFilters());
//        try {
//            
//        } catch (final NoSuchFieldException | SecurityException e) {
//            throw new ReflectionException(e);
//        }
        
        return null;
    }

    private Predicate<? super Field> applyFilters() {
        return f -> {
            final Annotation annotation = f.getAnnotation(this.annotation.annotationType());
            
            return annotation != null;
                
        };
    }
    
    private Map<String, Object> getAttributeValues() {
        if (attributeValues == null) {
            attributeValues = new HashMap<>();
        }
        
        return attributeValues;
    }
}

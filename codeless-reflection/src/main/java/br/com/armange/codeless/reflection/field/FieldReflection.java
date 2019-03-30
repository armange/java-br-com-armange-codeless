package br.com.armange.codeless.reflection.field;

import java.lang.annotation.Annotation;

import javax.inject.Inject;

public class FieldReflection {
    
    private FieldReflection() {}
    
    public static FieldFilter ofField(final String fieldName) {
        return new FieldFilter(fieldName);
    }
    
    public static <T extends Annotation> FieldFilter ofAnnotation(final Class<T> annotationClass) {
        
        Annotation x;
        
        return null;//new FieldFilter(fieldName);
        
        
        
        //FieldReflection.ofAnnot(X).orField(Y)
    }
}

package br.com.armange.codeless.reflection.clazz;

import java.util.function.Function;

import br.com.armange.codeless.reflection.exception.ReflectionException;

public class ClassReflectionClosures {

    private ClassReflectionClosures() {}
    
    public static Function<? super String, ? extends ClassValue> mapToClassValue() {
        return s -> {
            ClassValue classValue = null;
            
            try {
                classValue = new ClassValue(Class.forName(s), null);
            } catch (final ClassNotFoundException e) {
                classValue = new ClassValue(null, e);
            }
            
            return classValue;
        };
    }
    
    public static Function<? super String, ? extends Class<?>> mapToClass() {
        return s -> {
            try {
                return Class.forName(s);
            } catch (final ClassNotFoundException e) {
                throw new ReflectionException(e);
            }
        };
    }
}

package br.com.armange.codetree.reflection.klass;

import java.lang.reflect.Constructor;

import br.com.armange.codetree.reflection.exception.ReflectionException;

public class ClassReflection {
    
    private ClassReflection() {}

    public static <T> Constructor<T> getDefaultConstructorFrom(final Class<T> sourceClass) {
        try {
            return sourceClass.getConstructor();
        } catch (final NoSuchMethodException | SecurityException e) {
            throw new ReflectionException(e);
        }
    }
    
    public static <T> T newInstanceFrom(final Class<T> sourceClass) {
        try {
            return sourceClass.newInstance();
        } catch (final SecurityException | InstantiationException | IllegalAccessException e) {
            throw new ReflectionException(e);
        }
    }
}

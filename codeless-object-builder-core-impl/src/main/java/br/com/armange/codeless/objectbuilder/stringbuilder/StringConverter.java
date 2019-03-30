package br.com.armange.codeless.objectbuilder.stringbuilder;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import exception.ObjectBuilderException;

public class StringConverter {

    private final String source;
    
    private StringConverter(final String source) {
        this.source = source;
    }
    
    public static StringConverter of(final String source) {
        return new StringConverter(source);
    }
    
    public <T> T to(final Class<T> targetClass) {
        try {
            if (targetClass.equals(Character.class)) {
                return targetClass.getConstructor(String.class).newInstance(source.charAt(0));
            } else {
                return targetClass.getConstructor(String.class).newInstance(source);
            }
        } catch (final InstantiationException 
                | IllegalAccessException 
                | IllegalArgumentException
                | InvocationTargetException 
                | NoSuchMethodException 
                | SecurityException e) {
            throw new ObjectBuilderException(e);
        }
    }
    
    public Boolean toBoolean() {
        return new Boolean(source);
    }
    
    public Byte toByte() {
        return new Byte(source);
    }

    public Short toShort() {
        return new Short(source);
    }

    public Character toCharacter() {
        return new Character(source.charAt(0));
    }

    public Integer toInteger() {
        return new Integer(source);
    }

    public Long toLong() {
        return new Long(source);
    }

    public Float toFloat() {
        return new Float(source);
    }

    public Double toDouble() {
        return new Double(source);
    }

    public BigDecimal toBigDecimal() {
        return new BigDecimal(source);
    }
}

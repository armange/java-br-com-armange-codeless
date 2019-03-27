package br.com.armange.codeless.objectbuilder;

import java.math.BigDecimal;

public class StringConverter {

    private final String source;
    
    private StringConverter(final String source) {
        this.source = source;
    }
    
    public static StringConverter of(final String source) {
        return new StringConverter(source);
    }
    
    public <T> T to(final Class<T> targetClass) {
        switch (targetClass.getName()) {
        
        case "":
            return (T) toBoolean();
        
        default: 
            return null;
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

package br.com.armange.codeless.resourcebundle;

interface MessageFormat {

    String getMessage();
    
    default String format(Object... parameters) {
        return java.text.MessageFormat.format(getMessage(), parameters);
    }
}

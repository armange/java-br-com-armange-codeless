package br.com.armange.codeless.resourcebundle;

public enum DefaultMessages implements MessageFormat {
    
    REQUIRED_PARAMETER("The parameter \"{0}\" is required.");
    
    private String message;
    
    DefaultMessages(final String message) {
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
    
    @Override
    public String toString() {
        return getMessage();
    }
}

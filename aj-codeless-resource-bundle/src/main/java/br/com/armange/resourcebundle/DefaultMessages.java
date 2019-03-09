package br.com.armange.resourcebundle;

public enum DefaultMessages {
    
    REQUIRED_PARAMETER("The parameter '{0}' is required.")
    ;
    
    private String message;
    
    DefaultMessages(final String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}

package br.com.armange.codeless.reflection.exception;

public class ReflectionException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    /**
     * @see RuntimeException#RuntimeException(String)
     */
    public ReflectionException(final String message) {
        super(message);
    }
    
    /**
     * @see RuntimeException#RuntimeException(String, Throwable)
     */
    public ReflectionException(final String message, final Throwable cause) {
        super(message, cause);
    }
    
    /**
     * @see RuntimeException#RuntimeException(Throwable)
     */
    public ReflectionException(final Throwable cause) {
        super(cause);
    }
}

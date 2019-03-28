package exception;

public class ObjectBuilderException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    /**
     * @see RuntimeException#RuntimeException(String)
     */
    public ObjectBuilderException(final String message) {
        super(message);
    }
    
    /**
     * @see RuntimeException#RuntimeException(String, Throwable)
     */
    public ObjectBuilderException(final String message, final Throwable cause) {
        super(message, cause);
    }
    
    /**
     * @see RuntimeException#RuntimeException(Throwable)
     */
    public ObjectBuilderException(final Throwable cause) {
        super(cause);
    }
}

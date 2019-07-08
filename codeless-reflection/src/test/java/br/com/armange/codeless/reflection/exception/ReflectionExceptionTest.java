package br.com.armange.codeless.reflection.exception;

import org.junit.Assert;
import org.junit.Test;

public class ReflectionExceptionTest {

    private final String myMessage = "My message";

    @Test
    public void newReflectionExceptionWithMessage() {
        final ReflectionException reflectionException = new ReflectionException(myMessage);
        
        Assert.assertNotNull(reflectionException);
        
        Assert.assertEquals(myMessage, reflectionException.getMessage());
    }
    
    @Test
    public void newReflectionExceptionWithMessageAndCause() {
        final NullPointerException nullPointerException = new NullPointerException();
        final ReflectionException reflectionException = new ReflectionException(myMessage, nullPointerException);
        
        Assert.assertNotNull(reflectionException);
        
        Assert.assertEquals(myMessage, reflectionException.getMessage());
        Assert.assertEquals(nullPointerException, reflectionException.getCause());
    }
    
    @Test
    public void newReflectionExceptionWithCause() {
        final NullPointerException nullPointerException = new NullPointerException();
        final ReflectionException reflectionException = new ReflectionException(nullPointerException);
        
        Assert.assertNotNull(reflectionException);
        
        Assert.assertEquals(nullPointerException, reflectionException.getCause());
    }
}

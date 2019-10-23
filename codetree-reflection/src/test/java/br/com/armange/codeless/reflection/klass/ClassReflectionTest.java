package br.com.armange.codeless.reflection.klass;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.armange.codeless.reflection.exception.ReflectionException;
import br.com.armange.codeless.reflection.klass.artifact.AnyClassWithDefaultConstructorArtifact;
import br.com.armange.codeless.reflection.klass.artifact.AnyClassWithoutDefaultConstructorArtifact;

public class ClassReflectionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    
    @Test
    public void getDefaultConstructorFromAnyClas() {
        final Constructor<AnyClassWithDefaultConstructorArtifact> defaultConstructorFrom = ClassReflection
                .getDefaultConstructorFrom(AnyClassWithDefaultConstructorArtifact.class);
        
        Assert.assertNotNull(defaultConstructorFrom);
        
        try {
            defaultConstructorFrom.newInstance();
        } catch (final InstantiationException 
                | IllegalAccessException 
                | IllegalArgumentException
                | InvocationTargetException e) {
            e.printStackTrace();
            
            Assert.fail(e.getMessage());
        }
        
        Assert.assertEquals(AnyClassWithDefaultConstructorArtifact.DEFAULT_CONSTRUCTOR_OUTPUT_STREAM, outContent.toString());
    }
    
    @Test(expected = ReflectionException.class)
    public void throwReflectionExceptionWhenNotExistsDefaultConstructor() {
        ClassReflection.getDefaultConstructorFrom(AnyClassWithoutDefaultConstructorArtifact.class);
    }
    
    @Test
    public void getNewInstanceFromAnyClas() {
        ClassReflection.newInstanceFrom(AnyClassWithDefaultConstructorArtifact.class);
        
        Assert.assertEquals(AnyClassWithDefaultConstructorArtifact.DEFAULT_CONSTRUCTOR_OUTPUT_STREAM, outContent.toString());
    }
    
    @Test(expected = ReflectionException.class)
    public void throwReflectionExceptionWhenNewInstanceFails() {
        ClassReflection.newInstanceFrom(AnyClassWithoutDefaultConstructorArtifact.class);
    }
}

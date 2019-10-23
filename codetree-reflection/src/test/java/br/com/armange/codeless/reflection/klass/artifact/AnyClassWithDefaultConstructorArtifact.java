package br.com.armange.codeless.reflection.klass.artifact;

public class AnyClassWithDefaultConstructorArtifact {
    
    public static final String DEFAULT_CONSTRUCTOR_OUTPUT_STREAM = "Default Constructor.";

    public AnyClassWithDefaultConstructorArtifact() {
        System.out.print(DEFAULT_CONSTRUCTOR_OUTPUT_STREAM);
    }
}

package br.com.armange.codeless.reflection.klass.artifact;

public class AnyClassWithoutDefaultConstructorArtifact {
    
    private AnyClassWithoutDefaultConstructorArtifact() {}
    
    public AnyClassWithoutDefaultConstructorArtifact(final String output) {
        System.out.print(output);
    }
}

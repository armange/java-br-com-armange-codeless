package br.com.armange.boilerplate.singleton.artifacts;

import br.com.armange.boilerplate.singleton.annotation.Singleton;

@Singleton
public class FailedSingletonClassArtifact {
    public FailedSingletonClassArtifact() {}
    
    public static FailedSingletonClassArtifact getInstance() {
        return null;
    }
}

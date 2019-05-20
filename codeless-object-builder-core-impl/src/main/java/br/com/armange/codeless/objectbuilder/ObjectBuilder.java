package br.com.armange.codeless.objectbuilder;

import java.io.InputStream;

import br.com.armange.codeless.objectbuilder.inputstream.InputStreamReader;

public class ObjectBuilder {

    private ObjectBuilder() {}
    
    public static InputStreamReader ofInputStream(final InputStream inputStream) {
        return new InputStreamReader(inputStream);
    }
    
//    public 
    // ObjectBuilder.ofString.toX()
    // ObjectBuilder.ofInteger.toX()
}

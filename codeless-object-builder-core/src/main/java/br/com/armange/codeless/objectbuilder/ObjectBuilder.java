package br.com.armange.codeless.objectbuilder;

import java.io.InputStream;

public class ObjectBuilder {

    private ObjectBuilder() {}
    
    public Object fromInputStream(final InputStream inputStream) {
        return new InputStreamReader(inputStream);
    }
}

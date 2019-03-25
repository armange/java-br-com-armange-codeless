package br.com.armange.codeless.objectbuilder;

import java.io.IOException;
import java.io.InputStream;

class InputStreamReader {
    InputStream inputStream;
    
    InputStreamReader(final InputStream inputStream) {
        this.inputStream = inputStream;
    }
    
    public CsvReader csv(final String separator, final boolean hasHeader) throws IOException {
        return new CsvReader(inputStream, separator, hasHeader);
    }
}

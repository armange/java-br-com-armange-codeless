package br.com.armange.codeless.objectbuilder.inputstream;

import java.io.IOException;
import java.io.InputStream;

import br.com.armange.codeless.objectbuilder.csv.CsvReader;

public class InputStreamReader {
    InputStream inputStream;
    
    public InputStreamReader(final InputStream inputStream) {
        this.inputStream = inputStream;
    }
    
    public CsvReader ofCsv(final String separator, final boolean hasHeader) throws IOException {
        return new CsvReader(inputStream, separator, hasHeader);
    }
}

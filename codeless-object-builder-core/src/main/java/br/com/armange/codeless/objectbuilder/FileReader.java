package br.com.armange.codeless.objectbuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

class FileReader {
    InputStream csvFile;
    
    FileReader(final InputStream csvFile) {
        this.csvFile = csvFile;
    }
    
    FileReader(final File csvFile) {
        
    }
    
    public CsvReader csv(final String separator, final boolean hasHeader) throws IOException {
        return new CsvReader(csvFile, separator, hasHeader);
    }
}

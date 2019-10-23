package br.com.armange.codeless.objectbuilder.csv;

public class CsvLine {

    private final String[] header;
    private final String[] values;
    
    public CsvLine(final String[] header, final String[] values) {
        this.header = header;
        this.values = values;
    }

    public String[] getHeader() {
        return header;
    }

    public String[] getValues() {
        return values;
    }
}

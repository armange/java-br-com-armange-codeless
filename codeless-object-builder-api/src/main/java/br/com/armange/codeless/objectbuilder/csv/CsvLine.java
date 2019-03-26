package br.com.armange.codeless.objectbuilder.csv;

public class CsvLine {

    private String[] header;
    private String[] values;
    
    public CsvLine(final String[] header, final String[] values) {
        this.header = header;
        this.values = values;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }
}

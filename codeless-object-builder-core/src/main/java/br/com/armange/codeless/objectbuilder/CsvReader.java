package br.com.armange.codeless.objectbuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.function.Consumer;
import java.util.stream.Stream;

import br.com.armange.codeless.objectbuilder.csv.CsvLine;

class CsvReader {

    private final InputStream csvInputStream;
    private final String separator;
    private final boolean hasHead;
    private Stream<CsvLine> fileContent;
    private String[] head;
    private BufferedReader bufferedReader;

    CsvReader(final InputStream csvInputStream, final String separator, final boolean hasHeader) throws IOException {
        this.csvInputStream = csvInputStream;
        this.separator = separator;
        this.hasHead = hasHeader;

        readCsv();
    }

    private void readCsv() throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(csvInputStream));

        readHead();
        
        fileContent = bufferedReader
                .lines()
                .map(line -> new CsvLine(head, line.split(separator)))
                .onClose(closeBufferedReaderOnCloseStream());
    }

    private void readHead() throws IOException {
        if (hasHead) {
            head = bufferedReader.readLine().split(separator);
        }
    }

    private Runnable closeBufferedReaderOnCloseStream() {
        return () -> {
            try {
                bufferedReader.close();
            } catch (final IOException e) {
                throw new UncheckedIOException(e);
            }
        };
    }
    
    public Stream<CsvLine> stream() {
        return fileContent;
    }
    
    public String[] getHead() {
        return head;
    }

    public static void main(String[] args) {
        try {
            final File file = new File("/home/diego/Downloads/csv1.csv");
            
            final FileInputStream fileInputStream = new FileInputStream(file);
            
            final CsvReader csv = new CsvReader(fileInputStream, ",", true);

            Stream.of(csv.getHead()).forEach(printCsvElement());
            
            System.out.println("\n");
            
            csv.stream().forEach(printValues());
            
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Consumer<? super CsvLine> printValues() {
        return e -> {
            Stream.of(e.getValues()).forEach(printCsvElement());
            
            System.out.println("\n");
        };
    }

    private static Consumer<? super String> printCsvElement() {
        return f -> {
            System.out.print(String.join("", f, "\t"));
        };
    }
}

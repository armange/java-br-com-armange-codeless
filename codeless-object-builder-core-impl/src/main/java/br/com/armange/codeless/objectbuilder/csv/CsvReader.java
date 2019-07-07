package br.com.armange.codeless.objectbuilder.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import br.com.armange.codeless.objectbuilder.stringbuilder.StringConverter;
import br.com.armange.codeless.reflection.field.FieldReflection;
import br.com.armange.codeless.reflection.klass.ClassReflection;

public class CsvReader {

    private final InputStream csvInputStream;
    private final String separator;
    private final boolean hasHeader;
    private Stream<CsvLine> csvContent;
    private String[] header;
    private BufferedReader bufferedReader;

    public CsvReader(final InputStream csvInputStream, final String separator, final boolean hasHeader) throws IOException {
        this.csvInputStream = csvInputStream;
        this.separator = separator;
        this.hasHeader = hasHeader;

        readCsv();
    }

    private void readCsv() throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(csvInputStream));

        readHead();
        
        csvContent = bufferedReader
                .lines()
                .map(line -> new CsvLine(header, line.split(separator, -1)))
                .onClose(closeBufferedReaderOnCloseStream());
    }

    private void readHead() throws IOException {
        if (hasHeader) {
            header = bufferedReader.readLine().split(separator);
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
        return csvContent;
    }
    
    public String[] getHeader() {
        return header;
    }
    
    public <T> Stream<T> streamAs(final Class<T> targetClass) {
        return stream().map(mapToInstanceOf(targetClass));
    }

    private <T> Function<? super CsvLine, ? extends T> mapToInstanceOf(final Class<T> targetClass) {
//        return l -> {
//            final T instance = ClassReflection.newInstanceFrom(targetClass);
//            
//            IntStream
//                .range(0, (header.length-1))
//                .forEach(i -> 
//                    FieldReflection
//                        .ofField(l.getHeader()[i])
//                        .ofInstance(instance)
//                        .setValue((f,v) -> 
//                            StringConverter.of(v.toString()).to(f.getType()), 
//                            l.getValues()[i]));
//            
//            return instance;
//        };
        return null;
    }

    public static void main(String[] args) {
        try {
            final File file = new File("/home/diego/Downloads/csv1.csv");
            
            final FileInputStream fileInputStream = new FileInputStream(file);
            
            final CsvReader csv = new CsvReader(fileInputStream, ",", true);

            Stream.of(csv.getHeader()).forEach(printCsvElement());
            
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

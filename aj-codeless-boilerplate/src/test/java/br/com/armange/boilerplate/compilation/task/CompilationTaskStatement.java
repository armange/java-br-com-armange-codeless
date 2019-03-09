package br.com.armange.boilerplate.compilation.task;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.tools.Diagnostic.Kind;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class CompilationTaskStatement {

    private static final String JAVA_EXTENSION = ".java";
    private static final String DEFAULT_SOURCE_FOLDER = "src/test/java/";
    private final JavaCompiler compiler;
    private final StandardJavaFileManager fileManager;
    private final DiagnosticCollector<JavaFileObject> collector;
    
    public CompilationTaskStatement() {
        compiler = ToolProvider.getSystemJavaCompiler();
        collector = new DiagnosticCollector<JavaFileObject>();
        fileManager = compiler.getStandardFileManager(collector, Locale.US, StandardCharsets.UTF_8);
    }
    
//    public TaskResult getTaskResult(final Set<Class<?>> classSet) {
//        return generateTaskResult(generateTask(classSet.stream()));
//    }
    
    public TaskResult getTaskResult(final Class<?>... classToCompile) {
        final Stream<Class<?>> classStream = Stream.of(classToCompile);
        
        return generateTaskResult(generateTask(classStream));
    }
    
    private TaskResult generateTaskResult(final JavaCompiler.CompilationTask task) {
        final Boolean result = task.call();

        final Set<String> messages = collector.getDiagnostics()
            .stream()
            .filter(d -> d.getKind() == Kind.MANDATORY_WARNING 
                || d.getKind() == Kind.ERROR)
            .map(d -> d.getMessage(Locale.US))
            .collect(Collectors.toSet());
        
        return new TaskResult(result, messages);
    }

    private JavaCompiler.CompilationTask generateTask(final Stream<Class<?>> classStream) {
        final OutputStreamWriter stdout = new OutputStreamWriter(new ByteArrayOutputStream());

        final String[] classNames = classStream
            .map(this::getQualifiedPath)
            .toArray(size -> new String[size]);
        
        final JavaCompiler.CompilationTask task = compiler
                .getTask(stdout, fileManager, collector, null, null, fileManager
                        .getJavaFileObjects(classNames));
        return task;
    }

    private String getQualifiedPath(final Class<?> className) {
        return String.join("", DEFAULT_SOURCE_FOLDER, convertClassNameToPath(className), JAVA_EXTENSION);
    }

    private String convertClassNameToPath(final Class<?> className) {
        return className.getName().replaceAll("\\.", "/");
    }
}

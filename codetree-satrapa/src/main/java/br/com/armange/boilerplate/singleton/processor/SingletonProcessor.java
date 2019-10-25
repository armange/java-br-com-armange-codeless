package br.com.armange.boilerplate.singleton.processor;

import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;

import com.google.common.collect.ImmutableSet;

import br.com.armange.boilerplate.singleton.annotation.Singleton;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
public final class SingletonProcessor extends AbstractProcessor {

    public static final String MESSAGE_PUBLIC_CONSTRUCTOR = "The singleton class '%s' should not contain a public constructor";
    public static final String MESSAGE_CONFLICT_METHOD = "There is already a method named '%s' in '%s'";
    public static final Object METHOD_RESERVED_NAME = "getInstance";
    private Messager messager;

    @Override
    public synchronized void init(final ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        
        messager = processingEnv.getMessager();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return ImmutableSet.of(Singleton.class.getCanonicalName());
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv) {

        roundEnv.getElementsAnnotatedWith(Singleton.class)
            .forEach(e -> {
                final TypeElement typeElement = (TypeElement)e;
                
                validatePublicConstructor(e, typeElement);
                validateConflictingMethod(e, typeElement);
            });
        
        return false;
    }

    private <E extends Element> void validatePublicConstructor(final E e,final TypeElement typeElement){
        final List<ExecutableElement> methodsIn = ElementFilter
                .constructorsIn(typeElement.getEnclosedElements());
        
        final boolean hasPublicConstructor = methodsIn
                .stream()
                .filter(ee -> ElementKind.CONSTRUCTOR.equals(ee.getKind())
                        && ee.getModifiers().contains(Modifier.PUBLIC)
                        && !ee.isDefault())
                .findFirst()
                .isPresent();
    
        if (hasPublicConstructor) {
            messager.printMessage(Diagnostic.Kind.ERROR, 
                    String.format(MESSAGE_PUBLIC_CONSTRUCTOR, typeElement));
        }
    }
    
    private <E extends Element> void validateConflictingMethod(final E e,final TypeElement typeElement){
        final List<ExecutableElement> methodsIn = ElementFilter
                .methodsIn(typeElement.getEnclosedElements());
        
        final boolean hasConflictingMethod = methodsIn
                .stream()
                .filter(m -> m.getSimpleName().toString().equals(METHOD_RESERVED_NAME) 
                        && m.getModifiers().contains(Modifier.PUBLIC)
                        && m.getModifiers().contains(Modifier.STATIC)
                        && m.getReturnType().equals(typeElement.asType()))
                .findFirst()
                .isPresent();
    
        if (hasConflictingMethod) {
            messager.printMessage(Diagnostic.Kind.ERROR, 
                    String.format(MESSAGE_CONFLICT_METHOD, METHOD_RESERVED_NAME, 
                            typeElement));
        }
    }
}


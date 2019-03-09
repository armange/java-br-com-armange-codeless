package br.com.armange.boilerplate.singleton;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;

import br.com.armange.boilerplate.compilation.task.CompilationTaskStatement;
import br.com.armange.boilerplate.compilation.task.TaskResult;
import br.com.armange.boilerplate.singleton.artifacts.FailedSingletonClassArtifact;
import br.com.armange.boilerplate.singleton.artifacts.SuccessfullSingletonClassArtifact;
import br.com.armange.boilerplate.singleton.processor.SingletonProcessor;

public class SingletonProcessorTest {
    private CompilationTaskStatement compilationTaskStatement;
    
    @Before
    public void beforeTest() throws Exception {
        compilationTaskStatement = new CompilationTaskStatement();
    }

    @Test
    public void failWithConflictingMethod() throws Exception {
        final TaskResult taskResult = compilationTaskStatement
                .getTaskResult(FailedSingletonClassArtifact.class);
        
        final String conflictingMethodMessage = String.format(
                SingletonProcessor.MESSAGE_CONFLICT_METHOD, 
                SingletonProcessor.METHOD_RESERVED_NAME, 
                FailedSingletonClassArtifact.class.getName());
        
        final String publicConstructorMessage = String.format(
                SingletonProcessor.MESSAGE_PUBLIC_CONSTRUCTOR, 
                FailedSingletonClassArtifact.class.getName());
        
        final SoftAssertions softly = new SoftAssertions();
        
        softly.assertThat(taskResult.isFailed()).isTrue();
        softly.assertThat(taskResult.getMessages()).contains(
                conflictingMethodMessage, 
                publicConstructorMessage);
        softly.assertAll();
    }
    
    @Test
    public void successfullSingletonClass() throws Exception {
        final TaskResult taskResult = compilationTaskStatement
                .getTaskResult(SuccessfullSingletonClassArtifact.class);
        
        assertThat(taskResult.isFailed()).as(taskResult.getMessages().iterator().next()).isFalse();
    }
}

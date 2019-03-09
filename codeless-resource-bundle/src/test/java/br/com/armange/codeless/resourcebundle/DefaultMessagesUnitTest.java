package br.com.armange.codeless.resourcebundle;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class DefaultMessagesUnitTest {

    private final String messageRequiredParameter = "The parameter \"{0}\" is required.";
    
    @Test
    public void validateEnum() {
        assertThat(DefaultMessages.REQUIRED_PARAMETER).isEqualTo(DefaultMessages.valueOf("REQUIRED_PARAMETER"));
    }
    
    @Test
    public void getMessageMustReturnTheMessage() {
        assertThat(messageRequiredParameter).isEqualTo(DefaultMessages.REQUIRED_PARAMETER.getMessage());
    }
    
    @Test
    public void toStringMustReturnTheMessage() {
        assertThat(messageRequiredParameter).isEqualTo(DefaultMessages.REQUIRED_PARAMETER.toString());
    }
    
    @Test
    public void formatMustReturnTheFormattedMessage() {
        assertThat("The parameter \"X\" is required.").isEqualTo(DefaultMessages.REQUIRED_PARAMETER.format("X"));
    }
}

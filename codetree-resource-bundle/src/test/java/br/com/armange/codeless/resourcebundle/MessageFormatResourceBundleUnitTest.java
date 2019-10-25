package br.com.armange.codeless.resourcebundle;

import static org.assertj.core.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class MessageFormatResourceBundleUnitTest {

    private final String baseNameResource = "resource-bundle";
    private final String keyPlanetResource = "planet";
    private final String keyTemplateResource = "template";
    private final String resultEnglishPlanetResourceKey = "Mars";
    private final String resultPortuguesePlanetResourceKey = "Marte";
    private final String resultEnglishTemplateResourceKey;
    private final String resultPortugueseTemplateResourceKey;
    private final String localeEnLanguage = "en";
    private final String localeEnUSCountry = "US";
    private final String localePtLanguage = "pt";
    private final String localePtBRCountry = "BR";
    private final String localeInvalidCountry = "XX";
    private final Locale localeEnUS = new Locale(localeEnLanguage, localeEnUSCountry);
    private final Locale localePtBR = new Locale(localePtLanguage, localePtBRCountry);
    private final Locale localePtXX = new Locale(localePtLanguage, localeInvalidCountry);
    
    private final Date parameterDefaultDate;
    private final Object[] parametersToEnglishTemplateResourceKey;
    private final Object[] parametersToPortugueseTemplateResourceKey;
            
    
    public MessageFormatResourceBundleUnitTest() {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = null;
        
        try {
            date = simpleDateFormat.parse("19/10/1983 11:00");
        } catch (final ParseException e) {
            fail(e.getMessage());
        }
        
        parameterDefaultDate = date;
        resultEnglishTemplateResourceKey = "At 11:00 AM on October 19, 1983, we detected 7 spaceships on the planet Mars.";
        resultPortugueseTemplateResourceKey = "Às 11:00 em 19 de Outubro de 1983, nós detectamos 7 naves espaciais no planeta Marte.";
        parametersToEnglishTemplateResourceKey = new Object[] {resultEnglishPlanetResourceKey, 7, parameterDefaultDate};
        parametersToPortugueseTemplateResourceKey = new Object[] {resultPortuguesePlanetResourceKey, 7, parameterDefaultDate};
    }
    
    @Test
    public void emitMessageWithLanguageWithoutCountry() {
        final ResourceBundle resourceBundle = ResourceBundle
                .getBundle(baseNameResource, Locale.ENGLISH);
        
        final MessageFormatResourceBundle messageFormatResourceBundle = 
                new MessageFormatResourceBundle(resourceBundle);
        
        final String string = messageFormatResourceBundle.getString(keyPlanetResource);
        
        assertThat(string).isEqualTo(resultEnglishPlanetResourceKey);
    }
    
    @Test
    public void emitMessageWithLanguageWithNonExistentCountry() {
        final ResourceBundle resourceBundle = ResourceBundle
                .getBundle(baseNameResource, localeEnUS);
        final MessageFormatResourceBundle messageFormatResourceBundle = 
                new MessageFormatResourceBundle(resourceBundle);
        
        final String string = messageFormatResourceBundle.getString(keyPlanetResource);
        
        assertThat(string).isEqualTo(resultEnglishPlanetResourceKey);
    }
    
    @Test
    public void emitMessageWithLanguageAndCountry() {
        final ResourceBundle resourceBundle = ResourceBundle
                .getBundle(baseNameResource, localePtBR);
        
        final MessageFormatResourceBundle messageFormatResourceBundle = 
                new MessageFormatResourceBundle(resourceBundle);
        
        final String string = messageFormatResourceBundle.getString(keyPlanetResource);
        
        assertThat(string).isEqualTo(resultPortuguesePlanetResourceKey);
    }
    
    @Test
    public void emitMessageWithLanguageAndInvalidCountry() {
        final ResourceBundle resourceBundle = ResourceBundle
                .getBundle(baseNameResource, localePtXX);
        
        final MessageFormatResourceBundle messageFormatResourceBundle = 
                new MessageFormatResourceBundle(resourceBundle);
        
        final String string = messageFormatResourceBundle.getString(keyPlanetResource);
        
        assertThat(string).isEqualTo(resultPortuguesePlanetResourceKey);
    }
    
    @Test
    public void emitMessageWithParameters() {
        final ResourceBundle resourceBundle = ResourceBundle
                .getBundle(baseNameResource, Locale.ENGLISH);
        
        final MessageFormatResourceBundle messageFormatResourceBundle = 
                new MessageFormatResourceBundle(resourceBundle);
        
        final String string = messageFormatResourceBundle
                .getStringWithParameters(keyTemplateResource, parametersToEnglishTemplateResourceKey);
        
        assertThat(string).isEqualTo(resultEnglishTemplateResourceKey);
    }
    
    @Test
    public void emitMessageWithUnicode() {
        final ResourceBundle resourceBundle = ResourceBundle
                .getBundle(baseNameResource, localePtBR);
        
        final MessageFormatResourceBundle messageFormatResourceBundle = 
                new MessageFormatResourceBundle(resourceBundle);
        
        final String string = messageFormatResourceBundle
                .getStringWithParameters(keyTemplateResource, parametersToPortugueseTemplateResourceKey);
        
        assertThat(string).isEqualTo(resultPortugueseTemplateResourceKey);
    }
    
    @Test
    public void messageFormatBundleMustReturnResourceBundle() {
        final ResourceBundle resourceBundle = ResourceBundle
                .getBundle(baseNameResource, localePtBR);
        
        final MessageFormatResourceBundle messageFormatResourceBundle = 
                new MessageFormatResourceBundle(resourceBundle);
        
        final ResourceBundle returnedResourceBundle = messageFormatResourceBundle.getResourceBundle();
        
        assertThat(returnedResourceBundle).isEqualTo(resourceBundle);
    }
}

package br.com.armange.resourcebundle;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.inject.Inject;

public class MessageFormatResourceBundle {

    private final ResourceBundle resourceBundle;
    private final MessageFormat formatter = new MessageFormat(String.);
    private final Locale defaultLocale = Locale.getDefault();
    
    @Inject
    public MessageFormatResourceBundle(final ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }
    
    public String getStringWithParameters(final String key, Object... parameters) {
        final String unformatedMessage = resourceBundle.getString(key);
        
        formatter.setLocale(defaultLocale);

        formatter.applyPattern(unformatedMessage);
        
        return formatter.format(parameters);
    }
}

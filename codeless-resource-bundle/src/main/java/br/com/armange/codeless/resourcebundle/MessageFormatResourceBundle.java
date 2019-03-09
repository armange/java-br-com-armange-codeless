package br.com.armange.codeless.resourcebundle;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.inject.Inject;

import br.com.armange.codeless.core.StringUtil;

public class MessageFormatResourceBundle {

    private final ResourceBundle resourceBundle;
    private final MessageFormat formatter = new MessageFormat(StringUtil.EMPTY);
    
    @Inject
    public MessageFormatResourceBundle(final ResourceBundle resourceBundle) {
        formatter.setLocale(resourceBundle.getLocale());
        
        this.resourceBundle = resourceBundle;
    }
    
    public String getStringWithParameters(final String key, final Object... parameters) {
        formatter.applyPattern(resourceBundle.getString(key));
        
        return formatter.format(parameters);
    }
    
    public String getString(final String key) {
        return resourceBundle.getString(key);
    }
    
    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }
}

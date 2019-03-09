//package br.com.armange.resourcebundle;
//
//import java.text.MessageFormat;
//import java.util.Date;
//import java.util.Locale;
//
//public class Test {
//
//    static void displayMessage(Locale currentLocale) {
//
//        System.out.println("currentLocale = " + currentLocale.toString());
//        System.out.println();
//
//        MessageFormatResourceBundle messages = (MessageFormatResourceBundle) MessageFormatResourceBundle.getBundle("MessageBundle",
//                currentLocale);
//
//        Object[] messageArguments = { messages.getString("planet"), new Integer(7),
//                new Date() };
//
//        MessageFormat formatter = new MessageFormat("");
//        formatter.setLocale(currentLocale);
//
//        formatter.applyPattern(messages.getString("template"));
//        String output = formatter.format(messageArguments);

//        System.out.println(output);
//        
//        messages.hello();
//    }
//
//    static public void main(String[] args) {
//        displayMessage(new Locale("en", "US"));
//        System.out.println();
//        displayMessage(new Locale("de", "DE"));
//    }
//}
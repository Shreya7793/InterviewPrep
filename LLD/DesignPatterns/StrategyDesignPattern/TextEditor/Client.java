package LLD.DesignPatterns.StrategyDesignPattern.TextEditor;

/*
Consider a text processing application that needs to perform different types of text transformations
based on user preferences.
 */
public class Client {
    public static void main(String []args){
        TextProcessor textProcessor=new TextProcessor();
        // Uppercase transformation
        textProcessor.setTextTransformerStrategy(new UpperCaseTextTransformerStrategy());
        String uppercaseText=textProcessor.process("testuppercase");
        System.out.println("Uppercase: " + uppercaseText);
        // Lowercase transformation
        textProcessor.setTextTransformerStrategy(new LowerCaseTextTransformerStrategy());
        String lowercaseText=textProcessor.process("TESTLOWERCASE");
        System.out.println("Lowercase: " + lowercaseText);
    }
}

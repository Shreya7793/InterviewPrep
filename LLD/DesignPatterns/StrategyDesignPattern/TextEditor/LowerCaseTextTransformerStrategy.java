package LLD.DesignPatterns.StrategyDesignPattern.TextEditor;

public class LowerCaseTextTransformerStrategy implements TextTransformerStrategy{
    @Override
    public String transform(String str) {
        return str.toLowerCase();
    }
}

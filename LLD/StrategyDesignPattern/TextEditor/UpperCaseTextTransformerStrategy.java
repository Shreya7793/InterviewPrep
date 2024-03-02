package LLD.StrategyDesignPattern.TextEditor;

public class UpperCaseTextTransformerStrategy implements TextTransformerStrategy{
    @Override
    public String transform(String str) {
        return str.toUpperCase();
    }
}

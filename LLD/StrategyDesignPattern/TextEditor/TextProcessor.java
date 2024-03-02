package LLD.StrategyDesignPattern.TextEditor;

//Context
public class TextProcessor {
    TextTransformerStrategy textTransformerStrategy;
    void setTextTransformerStrategy(TextTransformerStrategy textTransformerStrategy){
        this.textTransformerStrategy=textTransformerStrategy;
    }

    String process(String str){
        return this.textTransformerStrategy.transform(str);
    }
}

package Stack;

import java.util.List;
import java.util.Stack;

public class ValidParenthesis {
    static boolean isValid(String str){
        Stack<Character> parenthesisStack=new Stack<>();
        char []strChars=new char[str.length()];
        for(int i=0; i<strChars.length;i++){
            if(parenthesisStack.isEmpty() && (strChars[i]==']'||strChars[i]=='}'||strChars[i]==')'))
                return false;
            else if(parenthesisStack.isEmpty() && (strChars[i]=='['||strChars[i]=='{'||strChars[i]=='('))
                parenthesisStack.push(strChars[i]);
            else if((strChars[i]=='[') && parenthesisStack.peek()==']')
                parenthesisStack.pop();
            else if((strChars[i]=='{') && parenthesisStack.peek()=='}')
                parenthesisStack.pop();
            else if((strChars[i]=='(') && parenthesisStack.peek()==')')
                parenthesisStack.pop();
        }
        return parenthesisStack.isEmpty();
    }
    public static void main(){

    }
}

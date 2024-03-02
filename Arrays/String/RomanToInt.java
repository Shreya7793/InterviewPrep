package Arrays.String;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RomanToInt {
    public static int romanToInt(String s) {
        Map<Character, Integer> romanValues = new HashMap<>();
        int result=0;
        int previousValue=0;
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int currentValue = romanValues.get(currentChar);
            if(i>0 && currentValue>previousValue){
                result += currentValue - 2*previousValue;
            }else
                result += currentValue;
            previousValue=currentValue;
        }

        return result;
    }
  /*  public static String intToRoman(int num) {
        Map<Integer,Character> romanValues = new TreeMap<>();
        int result=0;
        int previousValue=0;
        romanValues.put(1,'I');
        romanValues.put(5,'V');
        romanValues.put(10,'X');
        romanValues.put(50,'L');
        romanValues.put(100,'C');
        romanValues.put(500,'D');
        romanValues.put(1000,'M');
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int currentValue = romanValues.get(currentChar);
            if(i>0 && currentValue>previousValue){
                result += currentValue - 2*previousValue;
            }else
                result += currentValue;
            previousValue=currentValue;
        }

        return result;
    }*/
    static void main(String []args){
        String str="IV";
        System.out.println("Roman to Int?"+romanToInt(str));
     //   System.out.println("Roman to Int?"+intToRoman(5));
    }
}

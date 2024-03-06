package Recursion;

import java.util.ArrayList;
import java.util.List;
/*
Problem Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
Solution link:https://www.youtube.com/watch?v=tWnHbSHwNmA
 */
public class LetterCombinationsofPhoneNumber {
    static void createCombinations(int ind, String digits, String []mappings, StringBuilder sb, List<String> ans){
        if(ind>=digits.length()){
            ans.add(sb.toString()); //adding output to the ans list
            return;
        }
        int num=digits.charAt(ind)-'0'; //Eg: 23 => num=2 when ind=0
        String value=mappings[num]; //value=abc i.e mapping[2] ;finding corresponding mapping

        for(int i=0;i<value.length();i++){
            sb.append(value.charAt(i));
            createCombinations(ind+1,digits,mappings,sb,ans);
            sb.deleteCharAt(sb.length()-1); //Remove the character while backtracking
        }
    }
    public static void main(String []args){
        List<String> ans=new ArrayList<>();
        int ind=0;
        StringBuilder sb=new StringBuilder("");
        String []mappings={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; //Keypad mapping
        String digits="23";
        if(digits.length()==0)
            System.out.println("");
        createCombinations(0,digits,mappings,sb,ans);
        System.out.println(""+ans);

    }
}

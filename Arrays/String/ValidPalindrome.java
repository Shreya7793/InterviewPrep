package Arrays.String;

import java.util.Locale;

/*
Problem Link: https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150

 */
public class ValidPalindrome {
    static boolean isValidPalindrome(String str){
        StringBuilder sb=new StringBuilder();
        char [] strChars= str.toCharArray();
        for(int i=0;i<strChars.length;i++){
            if(Character.isLetterOrDigit(strChars[i]))
                sb.append(strChars[i]);
        }
        str=sb.toString().toLowerCase();
        int leftPtr=0, rightPtr=str.length()-1;
        while(leftPtr<=rightPtr){
            if(str.charAt(leftPtr)!=str.charAt(rightPtr))
                return false;
            leftPtr++;
            rightPtr--;
        }
        return true;
    }
    static void main(String []args){
        String str="A man, a plan, a canal: Panama";
        System.out.println("Is Valid Palindrome?"+isValidPalindrome(str));
    }
}

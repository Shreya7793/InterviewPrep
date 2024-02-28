package SlidingWindow;

import java.net.Inet4Address;
import java.util.HashSet;
import java.util.Set;

/*
Problem Statement: Given a string s, find the length of the longest  substring without repeating characters.
Leetcode: https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/1187630837/
Hint: Sliding Window + HashSet
 */
public class LongestSubstringWithoutRepeatingChar {

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int leftPtr=0, rightPtr=0;
        Set <Character> charSet=new HashSet<>();
        int maxLen = Integer.MIN_VALUE;
        char [] strChars =s.toCharArray();
        int strLen;
        while(leftPtr<=rightPtr && rightPtr<s.length()){
            if(charSet.size()<=2){
                if(!charSet.contains(strChars[rightPtr])) {
                    charSet.add(strChars[rightPtr]);
                }
                strLen=rightPtr-leftPtr+1;
                maxLen=Math.max(maxLen,strLen);
                rightPtr++;
            }else{
                charSet.remove(strChars[leftPtr]);
                leftPtr++;
            }
        }
        return maxLen;
    }
    static int longestSubstringWithoutRepeatingChar(String str){
        int leftPtr=0, rightPtr=0;
        char []strChars = str.toCharArray();
        int maxLen=Integer.MIN_VALUE;
        Set<Character> charSet = new HashSet<>();
        while(leftPtr<=rightPtr && rightPtr<str.length()){
                if(!charSet.contains(strChars[rightPtr])){
                    charSet.add(strChars[rightPtr]);
                    ++rightPtr;
                    maxLen = Math.max(maxLen,charSet.size());
                }else {
                    charSet.remove(strChars[leftPtr]);
                    ++leftPtr;
                }
        }
        return maxLen;
    }
    public static void main(String []args){
        String str="abcabcbb";
        str="aab";
        System.out.println("longestSubstringWithoutRepeatingChar:"+longestSubstringWithoutRepeatingChar(str));
    }
}

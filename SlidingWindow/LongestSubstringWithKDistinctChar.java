package SlidingWindow;

import java.util.HashMap;
import java.util.Map;
/*
Problem Link: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
Problem Statement:
Given a string s and an integer k, return the length of the longest substring of s that contains
at most k distinct characters.
Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.

Solution: https://www.youtube.com/watch?v=k--bSleyD4E
Hint: Sliding Window, HashMap -> restrict the hashmap size to k
 */
public class LongestSubstringWithKDistinctChar {

    static int longestSubstringWithKDistinctChar(String s, int k){

        int leftPtr=0,rightPtr=0;
        int strLen= s.length();
        int maxLen=Integer.MIN_VALUE;
        Map<Character, Integer> charCountMap = new HashMap<>();
        char []strChars = s.toCharArray();
        while(leftPtr<=rightPtr && rightPtr<strLen){
            char charAtRightPtr=strChars[rightPtr];
            if(charCountMap.size()<k) {
                if (charCountMap.containsKey(charAtRightPtr))
                    charCountMap.put(charAtRightPtr, charCountMap.get(charAtRightPtr) + 1);
                else
                    charCountMap.put(charAtRightPtr, 1);
                ++rightPtr;
            }else{
                char charAtLeftPtr=strChars[leftPtr];
                charCountMap.put(charAtLeftPtr,charCountMap.get(charAtLeftPtr)-1);
                ++leftPtr;
                if(charCountMap.get(charAtLeftPtr)==0)
                    charCountMap.remove(charAtLeftPtr);
            }
            maxLen=Math.max(maxLen,rightPtr-leftPtr+1);
        }
        return maxLen;
    }
    public static void main(){
        String str="eceba";
        int k=2;
        str="aa";
        k=1;
        System.out.println(""+longestSubstringWithKDistinctChar(str,k));
    }

}

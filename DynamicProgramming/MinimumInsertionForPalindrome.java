package DynamicProgramming;

import java.util.Arrays;

/*
Video Link: https://www.youtube.com/watch?v=xPBLEj41rFU&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=31
No. of Min insertion = Length of String - Length(Longest Palindromic Subsequence)
The logic for finding the minimum number of insertions required is based on finding the longest palindromic subsequence
within the string.
The intuition is that the characters outside this longest palindromic subsequence need to be inserted to make
the string a palindrome.
 */
public class MinimumInsertionForPalindrome {
    static int longestPalindromicSequence(String str1, String str2){
        int len1=str1.length();
        int len2=str2.length();
        int [][]dp=new int[len1+1][len2+1];
        for(int []rows:dp)
            Arrays.fill(rows, -1);
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++)
                if(i>0&&j>0){
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }else{
                    dp[i][j]=0;
                }
        }
        return dp[len1][len2];
    }
    static String reverse(String str){
        int len=str.length();
        char [] strChars=str.toCharArray();
        for(int i=0;i<len/2;i++)
        {
            char temp=strChars[i];
            strChars[i]=strChars[len-i-1];
            strChars[len-i-1]=temp;
        }
        return new String(strChars);
    }
    public static void main(String []args){
        String str="aabca";
        int longestPalindromicSequenceLength=longestPalindromicSequence(str, reverse(str));
        System.out.println("Length of longestPalindromicSequenceLength:"+longestPalindromicSequenceLength);
        int minNumberofInsertions=str.length()-longestPalindromicSequenceLength;
        System.out.println("Minimum number of Insertions"+minNumberofInsertions);
    }
}

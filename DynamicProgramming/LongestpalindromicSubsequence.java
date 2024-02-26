package DynamicProgramming;
/*
Prolem Link: https://takeuforward.org/data-structure/longest-palindromic-subsequence-dp-28/
* Brute force: To generate all subsequence using recursive way, find the longest of them all TC: 2^N
*The longest palindromic subsequence of a string is the longest common subsequence of the given string and its reverse
TC: N^2 ; SC: N^2

* */

import java.sql.Statement;
import java.util.Arrays;

public class LongestpalindromicSubsequence {
    static String reverse(String str){
        char []strChars= str.toCharArray();
        int len=strChars.length;
        for(int i=0;i<len/2;i++){
            char temp=strChars[i];
            strChars[i]=strChars[len-i-1];
            strChars[len-i-1]=temp;
        }
        return new String(strChars);
    }
    static int[][] longestpalindromicSubsequence(String str, String reverseStr){
        int len1=str.length();
        int len2=reverseStr.length();
        int [][]dp=new int[len1+1][len2+1];
        for(int []rows:dp)
            Arrays.fill(rows,-1);
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i>0 && j>0) {
                    if (str.charAt(i-1) == reverseStr.charAt(j-1))
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                else
                    dp[i][j]=0; //In the recursive logic, we set the base case to if(ind1<0 || ind2<0)
                // but we can’t set the dp array’s index to -1.
                // Therefore a hack for this issue is to shift every index by 1 towards the right.
            }
        }
        return dp;
    }
    /*
    Video Link: https://www.youtube.com/watch?v=-zI4mrF2Pb4&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=28
    https://takeuforward.org/data-structure/print-longest-common-subsequence-dp-26/
     */
    static String printLongestPalindromicSubsequenceStr(String str1, String str2, int [][]dp){
        StringBuilder sb=new StringBuilder("");
        int n=str1.length();
        int m=str2.length();
        int i=n, j=m;
        int len=dp[n][m]; //Length of longest common subsequence
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                --i;
                --j;
            }
            else if(dp[i-1][j]>dp[i][j-1])
                --i;
            else
                --j;
        }
        return  sb.toString();
    }

    public static void main(String []args){
        String str="BABB";
        String reverseStr=reverse(str);
        int [][]dp=longestpalindromicSubsequence(str,reverseStr);
        System.out.print("The Length of Longest Palindromic Subsequence is "+dp[str.length()][reverseStr.length()]);
        System.out.print("\nThe Longest Palindromic Subsequence is "+printLongestPalindromicSubsequenceStr(str,reverseStr, dp));
    }
}

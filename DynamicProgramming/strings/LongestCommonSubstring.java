package DynamicProgramming.strings;
/*
* Solution: https://www.youtube.com/watch?v=_wP9mWNPL5w&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=30
* Problem Statement:Longest Common Substring
* We need to print the length of the longest common substring.
* Hint: Use tabulation 2D array -> max value in the dp array is the answer
* */
import java.util.Arrays;
public class LongestCommonSubstring {
    /*
    static String longestCommonsubstringWithMemoisation(String str1, String str2, int ind1, int ind2, int[][]dp) {
        if (ind1 < 0 || ind2 < 0)
            return "";
        if (dp[ind1][ind2] != -1)
            return "";
        if (str1.charAt(ind1) == str2.charAt(ind2)) {
            if(ind1>0 && ind2==0)
                dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2];
            else if(ind1>0 && ind2>0)
                dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2-1];
            else
                dp[ind1][ind2]=1;
            return str1.charAt(ind1) + longestCommonsubstringWithMemoisation(str1, str2, ind1 - 1, ind2 - 1, dp);
        } else {
            dp[ind1][ind2] = 0;
            return "";
        }
    }

    static String longestCommonSubsequenceWithRecursion(String str1, String str2, int ind1, int ind2,int len) {
        if(ind1>str1.length()-1||ind2>str2.length()-1)
            return ""; //Base case: reached end of one of the strings
        // If characters match, continue checking for the next characters
        if(str1.charAt(ind1)==str2.charAt(ind2)){
            return str1.charAt(ind1)+longestCommonSubsequenceWithRecursion(str1,str2,ind1+1,ind2+1, len+1);
        }
        // If characters don't match, reset the length and continue checking
        String substring1=longestCommonSubsequenceWithRecursion(str1,str2,ind1+1,ind2,0);
        String substring2=longestCommonSubsequenceWithRecursion(str1,str2,ind1,ind2+1,0);
        // Return the longer substring found
        return substring1.length()>substring2.length()?substring1:substring2;
    }*/

    public static void main(String [] args){
        String str1="abc";
        String str2="bced";
        int len1=str1.length();
        int len2=str2.length();
        String longestCommonSubstring = "";
        int [][]dp =new int[len1+1][len2+1]; //Note this! since row0 and col0 to 0
        int maxLen=0;
        int endIndex=-1; // Initialize the ending index of the LCS
        //Step1: set the first row and column as 0-> dont need this step as by default it's set to 0
       /* for(int i=0;i<len1+1;i++)
            dp[i][0]=0; //setting the column0 as 0
        for(int j=0;j<len2+1;j++)
            dp[0][j]=0; //setting the row0 as 0*/
        //Step2: fill the dp array, row represent string1, col represent string2
        for(int i=1; i<=len1;i++){ //Note the loop is <=length since we are starting from 1
            for(int j=1;j<=len2;j++){
                // If the characters at the current indices are the same, extend the LCS
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    endIndex = i; // Update the ending index of the LCS
                    maxLen = Math.max(maxLen, dp[i][j]); // Update the maximum LCS length
                }
                else
                    dp[i][j]=0; // Reset LCS length if characters don't match
                // Note that in subsequence we calcucate the max(f(ind1-1,ind2),f(ind1,ind2-1))-> this creates a break
                // since we need substring we dont consider these values. hence set it to 0
                }
            }
        System.out.println("Longest Common Substring Length: " + maxLen);

        if (endIndex != -1) {
            // Extract the Longest Common Substring using the ending index and max length
            int start=endIndex - maxLen;
            String lcs = str1.substring(start, endIndex);
            System.out.println("Longest Common Substring: " + lcs);
        } else {
            System.out.println("No common substring found.");
        }
    }
}

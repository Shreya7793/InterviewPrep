package DynamicProgramming;
/*
* Solution: https://www.youtube.com/watch?v=_wP9mWNPL5w&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=30
* */
import java.util.Arrays;
public class LongestCommonSubstring {
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
    }

    public static void main(String [] args){
        String str1="abc";
        String str2="beced";
        int len1=str1.length();
        int len2=str2.length();
        String longestCommonSubstring = "";
        System.out.println("Longest Common Sunsequence: " + longestCommonSubsequenceWithRecursion(str1, str2, 0, 0, 0));

        int [][]dp =new int[len1][len2];
        for(int []row:dp)
            Arrays.fill(row,-1);
        int maxLen=0;
        int endIndex=-1; // Initialize the ending index of the LCS
        for(int i=0; i<len1;i++){
            for(int j=0;j<len2;j++){
                if(str1.charAt(i)==str2.charAt(j)) {
                   if(i>0&&j>0)
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                   else
                       dp[i][j] = 1;
                   endIndex = i; // Update the ending index of the LCS
                   maxLen = Math.max(maxLen, dp[i][j]);
                }
                else
                    dp[i][j]=0;
                }
            }
        System.out.println("Longest Common Substring Length: " + maxLen);

        if (endIndex != -1) {
            // Extract the Longest Common Substring using the ending index and max length
            int start=endIndex - maxLen + 1;
            String lcs = str1.substring(start, endIndex + 1);
            System.out.println("Longest Common Substring: " + lcs);
        } else {
            System.out.println("No common substring found.");
        }

    }
    }

package DynamicProgramming.strings;

import java.util.Arrays;

/*
For eg:

Strings like “cab”,” bc” will not be called as a subsequence of “abc” as the characters are not coming in the same order.
Note: For a string of length n, the number of subsequences will be 2n.
Solution: https://www.youtube.com/watch?v=-zI4mrF2Pb4&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=28
Ref: https://takeuforward.org/data-structure/longest-common-subsequence-dp-25/
TC: Recursion: O(2^n * 2^m) for both the strings
TC: Using Memoization- O(N*M)
SC: O()
Tabular format:O(N*M)
 */
public class LongestCommonSubsequence {
     static int lcsLengthWithRecursion(String str1, String str2, int ind1, int ind2){
         if(ind1<0 || ind2<0) //If it's the end of the string then the lcs is -
             return 0 ;
         //This block will be executed only when the characters are match
         if(str1.charAt(ind1)==str2.charAt(ind2))
            return 1+ lcsLengthWithRecursion(str1,str2, ind1-1, ind2-1);//if its a match, then check next index for both
         //Not match- take the max of next index
        return 0+Math.max(lcsLengthWithRecursion(str1,str2, ind1-1, ind2),lcsLengthWithRecursion(str1,str2, ind1, ind2-1));
     }
    static String lcsStringWithRecursion(String str1, String str2, int ind1, int ind2){
        if(ind1<0 || ind2<0)
            return "" ;
        if(str1.charAt(ind1)==str2.charAt(ind2))
            return str1.charAt(ind1)+ lcsStringWithRecursion(str1,str2, ind1-1, ind2-1);

        String lcs1=lcsStringWithRecursion(str1,str2, ind1-1, ind2);
        String lcs2=lcsStringWithRecursion(str1,str2, ind1, ind2-1);

        return lcs1.length()>lcs2.length()?lcs1:lcs2; //whichever has greater length
    }
    static int lcsLengthWithMemoisation(String str1, String str2, int ind1, int ind2, int [][]dp){
        if(ind1<0 || ind2<0)
            return 0 ;
        if(dp[ind1][ind2]!=-1)
            return dp[ind1][ind2];
        if(str1.charAt(ind1)==str2.charAt(ind2))
            return dp[ind1][ind2]=1+ lcsLengthWithMemoisation(str1,str2, ind1-1, ind2-1, dp);
        return dp[ind1][ind2]=Math.max(lcsLengthWithMemoisation(str1,str2, ind1-1, ind2, dp),lcsLengthWithMemoisation(str1,str2, ind1, ind2-1, dp));
    }
    public static void main(String []args){
         String str1= "abc";
         String str2="bcd";
         int len1= str1.length();
         int len2=str2.length();
         int [][]dp = new int[len1][len2];
         for(int rows[]:dp)
             Arrays.fill(rows,-1);
        System.out.println("Length of subsequence: "+lcsLengthWithRecursion(str1,str2, str1.length()-1, str2.length()-1));
        System.out.println("Subsequence String: "+lcsStringWithRecursion(str1,str2, str1.length()-1, str2.length()-1));
        System.out.println("Length of subsequence using Memoisation: "+lcsLengthWithMemoisation(str1,str2, str1.length()-1, str2.length()-1,dp));


        for(int i=0; i<len1;i++){
            for(int j=0;j<len2;j++){
                if(str1.charAt(i)==str2.charAt(j)) {
                    if(i>0&&j>0)
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    else
                        dp[i][j] = 1;
                }
                else {
                    if (i==0 || j==0)
                        dp[i][j]=0;
                    else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[j][i - 1]);
                }
            }
        }
        System.out.println("Length of subsequence using Tabular format: "+dp[len1-1][len2-1]);


    }
}

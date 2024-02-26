package DynamicProgramming;

import java.util.Arrays;

/*
Video Link: https://www.youtube.com/watch?v=yMnH0jrir0Q&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=32
Total number of deletions= Length of (String1)-length of(LCS)
Total number of insertions= Length of (String2)-length of (LCS)
 */
public class MinimumInsertionDeletionToEquateTwoStrings {

    static int longestCommonSequenceLength(String str1, String str2){
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
    public static void main(String []args){
        String str1="aa";
        String str2="ana";
        int longestCommonSequenceLength=longestCommonSequenceLength(str1, str2);
        System.out.println("Length of Longest Common Sequence="+longestCommonSequenceLength);
        int numberofInsertions = str1.length()-longestCommonSequenceLength;
        int numberofDeletions = str2.length()-longestCommonSequenceLength;
        System.out.println("Minimum Number of Insertions & Deletion="+(numberofInsertions+numberofDeletions));

    }
}

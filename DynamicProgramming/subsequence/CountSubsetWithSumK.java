package DynamicProgramming.subsequence;

import java.util.Arrays;

/*
Problem Link: https://takeuforward.org/data-structure/count-subsets-with-sum-k-dp-17/
To count the number of subset with sum k.
To count no. of subsets=we will sum all ways i.e pick+not pick
 */
public class CountSubsetWithSumK {
    /*
    Time Complexity: O(N*K)
    Reason: There are N*K states therefore at max ‘N*K’ new problems will be solved.
    Space Complexity: O(N*K) + O(N)
    Reason: We are using a recursion stack space(O(N)) and a 2D array ( O(N*K)).
     */
    static int countSubsetWithSumK(int ind, int target, int []nums, int [][]dp){
        if(ind==0) {
            if (target == nums[ind])
                return 1;
            else
                return 0;
        }
        if(target==0)
            return 1;
        if(dp[ind][target]!=-1)
            return dp[ind][target];
        int pick=0;
        if(nums[ind]<=target)
            pick=countSubsetWithSumK(ind-1,target-nums[ind],nums,dp);
        int notPick=countSubsetWithSumK(ind-1,target,nums,dp);

        return dp[ind][target]=pick+notPick;
    }
    public static void main(String []args){
        int nums[] = {1, 2, 2, 3};
        int sum = 3;
        int [][]dp=new int[nums.length][sum+1]; //col index will go from 0 to sum. Therefor size would be till sum+1
        for(int []rows:dp)
            Arrays.fill(rows,-1);
        System.out.println("The number of subsets found are " + countSubsetWithSumK(nums.length-1,sum, nums,dp));
    }
}

package DynamicProgramming.subsequence;

import java.util.Arrays;
//Problem Link: https://takeuforward.org/data-structure/unbounded-knapsack-dp-23/
//Infinite supply of weights
//Each weight is associated with a value, we have to maximise the value
public class UnboundedKnapsack {

    /*
    Time Complexity: O(N*W)
    Reason: There are N*W states therefore at max ‘N*W’ new problems will be solved.
    Space Complexity: O(N*W) + O(N)
    Reason: We are using a recursion stack space(O(N)) and a 2D array ( O(N*
     */
    static int knapsackWithMemoisation(int ind, int targetWeight, int []weight, int []val, int [][]dp){
        if(ind==0) {
            if (weight[0] <= targetWeight)
                return (targetWeight/weight[0])*val[ind];
            else
                return 0;
        }
        if(dp[ind][targetWeight]!=-1)
            return dp[ind][targetWeight];
        int pick = Integer.MIN_VALUE;
        if(weight[ind]<=targetWeight)
            pick= val[ind] + knapsackWithMemoisation(ind, targetWeight-weight[ind], weight, val,dp);
        int notPick = knapsackWithMemoisation(ind-1, targetWeight,weight,val,dp);

        return dp[ind][targetWeight]=Math.max(pick, notPick);
    }
    public static void main(String []args){
        int[] wt = { 2, 4, 6 };
        int[] val = { 5, 11, 13 };
        int W = 10;
        int n=wt.length;
        //The size of the input array is ‘N’, so the index will always lie between ‘0’ and ‘n-1’.
        // The capacity can take any value between ‘0’ and ‘W’. Therefore we take the dp array as dp[n][W+1]
        int [][]dp=new int[wt.length][W+1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println("knapsackWithMemoisation:"+knapsackWithMemoisation(n-1,W,wt,val,dp));

    }
}

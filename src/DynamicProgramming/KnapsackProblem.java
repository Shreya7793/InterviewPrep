package DynamicProgramming;

import java.util.Arrays;

/*
Problem Link: https://takeuforward.org/data-structure/0-1-knapsack-dp-19/#google_vignette
A thief wants to rob a store. He is carrying a bag of capacity W.
The store has ‘n’ items. Its weight is given by the ‘wt’ array and its value by the ‘val’ array.
He can either include an item in its knapsack or exclude it but can’t partially have it as a fraction.
We need to find the maximum value of items that the thief can steal.
Recursion: TC: O(2^N); SC: O(N)
Memoisation:
TC: O(N*W) -> this can be calculated from the dp array index
There are N*W states therefore at max ‘N*W’ new problems will be solved.
Space Complexity: O(N*W) + O(N)
Reason: We are using a recursion stack space(O(N)) and a 2D array ( O(N*W)).

 */
public class KnapsackProblem {
    static int knapsackWithRecursion(int ind, int targetWeight, int []weight, int []val){
        if(ind==0) {
            if (weight[0] <= targetWeight)
                return weight[0];
            else
                return 0;
        }
        int pick = Integer.MIN_VALUE;
        if(weight[ind]<targetWeight)
            pick= val[ind] + knapsackWithRecursion(ind-1, targetWeight-weight[ind], weight, val);
        int notPick = knapsackWithRecursion(ind-1, targetWeight,weight,val);

        return Math.max(pick, notPick);
    }
    //int ind, int targetWeight are the changing parameters so DP array will contain that
    static int knapsackWithMemoisation(int ind, int targetWeight, int []weight, int []val, int [][]dp){
        if(ind==0) {
            if (weight[0] <= targetWeight)
                return weight[0];
            else
                return 0;
        }
        if(dp[ind][targetWeight]!=-1)
            return dp[ind][targetWeight];
        int pick = Integer.MIN_VALUE;
        if(weight[ind]<targetWeight)
            pick= val[ind] + knapsackWithRecursion(ind-1, targetWeight-weight[ind], weight, val);
        int notPick = knapsackWithRecursion(ind-1, targetWeight,weight,val);

        return dp[ind][targetWeight]=Math.max(pick, notPick);
    }
    public static void main(String []args){
        int[] wt = {1, 2, 4, 5};
        int[] val = {5, 4, 8, 6};
        int targetWeight = 5;
        int len=wt.length;
        System.out.println("knapsackWithRecursion: The Maximum value of items the thief can steal is " + knapsackWithRecursion(len-1,targetWeight,wt, val));
        int [][]dp=new int[len][targetWeight+1];
        for(int []rows:dp)
            Arrays.fill(rows, -1);
        System.out.println("knapsackWithMemoisation:" + knapsackWithMemoisation(len-1,targetWeight,wt, val,dp));

    }
}

package DynamicProgramming.subsequence;
/*
* Problem Link: https://takeuforward.org/data-structure/minimum-coins-dp-20/
* Video Link: https://www.youtube.com/watch?v=myPeWb3Y68A&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=21
* Following are Variation:
* 1. Minimum no. of coins to make a target/Amount.
* 2. Minumum elements
*Recursion:
* TC: O(2^N)
* SC: >>O(N) since we are repeating coins so it can go uptil target
* Memoisation:
*
*
* */

import java.io.IOException;
import java.util.Arrays;

public class MinimumCoins {
    static int minimumCoinsWithRecursion(int ind, int target,int []coins){
        //Base case: Since we are solutioning for n-1, we look at index 0 as base case
        if(ind==0) {
            if (target%coins[ind]==0) //if target is divisible Eg. target=6, coin[0]=2 => 3(i.e 6/2) coins required
                return target/coins[ind];
            else
                return Integer.MAX_VALUE; //can take (int) Math.pow(10, 9); also so that we don't face overflow
        }
        int pick=Integer.MAX_VALUE; //we have to find min coins to assign max value
        if(coins[ind]<=target)
            //Note: Whenever we have infinite supplies/multiple use -> in take scenario stand at the same index
            pick = 1 + minimumCoinsWithRecursion(ind, target-coins[ind], coins); //taking the coin, so adding 1
        int nonPick= 0+minimumCoinsWithRecursion(ind-1, target, coins);

        return Math.min(pick, nonPick); //return the minumum of combo of pick/non-pick
    }
    static int minimumCoinsWithMemoisation(int ind, int target,int []coins, int [][]dp){
        if(ind==0) {
            if (target%coins[ind]==0)
                return target/coins[ind];
            else
                return Integer.MAX_VALUE; //can take (int) Math.pow(10, 9); also so that we don't face overflow
        }
        if(dp[ind][target]!=-1)
            return dp[ind][target];
        int pick=Integer.MAX_VALUE;
        if(coins[ind]<=target)
            //Note: Whenever we have infinite supplies/multiple use -> in take scenario stand at the same index
            pick = 1 + minimumCoinsWithMemoisation(ind, target-coins[ind], coins,dp);
        int nonPick= minimumCoinsWithMemoisation(ind-1, target, coins,dp);

        return dp[ind][target]=Math.min(pick, nonPick);
    }
    public static void main(String []args){
        int coins[] = { 1, 2, 3 };
        int target = 7;
        int len=coins.length;
        int [][]dp=new int[len][target+1];
        for(int []rows:dp)
            Arrays.fill(rows, -1);
        System.out.println("minimumCoinsWithRecursion:"+minimumCoinsWithRecursion(len-1,target,coins));
        System.out.println("minimumCoinsWithMemoisation:"+minimumCoinsWithMemoisation(len-1,target,coins,dp));


    }
}
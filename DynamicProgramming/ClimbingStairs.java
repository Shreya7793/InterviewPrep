package DynamicProgramming;

import java.util.Arrays;

/*
Problem Statement: Count Ways To Reach The N-th Stairs
*https://www.youtube.com/watch?v=mLfjzJsN8us&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=3
* https://takeuforward.org/data-structure/dynamic-programming-climbing-stairs/
* TC With recursion: O(2^n)
TC with memoisation: O(n) ; n is the number of steps
 */
public class ClimbingStairs {

    static int climbingStairsWithRecursion(int n){
        if(n<=1)
            return 1;
        return climbingStairsWithRecursion(n-1) + climbingStairsWithRecursion(n-2);
    }
    static int climbingStairsWithMemoisation(int ind, int []dp){
        if(ind<1)
            return 1;
        if(dp[ind]!=-1)
            return dp[ind];
        return dp[ind]=climbingStairsWithMemoisation(ind-1, dp) + climbingStairsWithMemoisation(ind-2, dp);
    }
    static int climbingStairs(int n){
        if (n<=1) //Base case: 0 or 1 step can be climbed in 1 way
            return 1;
        int []dp=new int[n+1];
        dp[0]=1; //there is only 1 way to climb 0 steps
        dp[1]=1; //There is only 2 way to climb 1 steps
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String args[]){
        int n=3;
        int []dp=new int[n];
        Arrays.fill(dp, -1);
        System.out.println("No. of ways to climb n steps="+climbingStairsWithRecursion(n));
        System.out.println("No. of ways to climb n steps="+climbingStairsWithMemoisation(n-1, dp));
        System.out.println("No. of ways to climb n steps="+climbingStairs(n));
    }
}

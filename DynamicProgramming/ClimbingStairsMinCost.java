package DynamicProgramming;

import java.util.Arrays;

/*
Problem: Min Cost Climbing Stairs
You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
Once you pay the cost, you can either climb one or two steps.
Problem Ref: https://leetcode.com/problems/min-cost-climbing-stairs/
Ref: Videos: https://www.youtube.com/watch?v=S31W3kohFDk
 */
public class ClimbingStairsMinCost {
    //Time limit Exceeded because of Recursion
    static int calcMinCostUsingRecursion(int ind, int []cost){
        if(ind==1||ind==0)
            return cost[ind]; //we can start either from 0th or 1st stair as per the question
        if(ind<0)
            return 0;
       int stepOne=cost[ind]+calcMinCostUsingRecursion(ind-1,cost); //cost of wherever we are standing is added
       int stepTwo=cost[ind]+calcMinCostUsingRecursion(ind-2,cost); //cost of wherever we are standing is added
        return Math.min(stepOne,stepTwo);
    }
    //Overlapping subproblems are store in dp array
    //Recursion stack + dp array=> space complexity=O(N)+O(N)
    static int calcMinCostUsingMemoisation(int ind, int []cost, int []dp){
        if(ind==1||ind==0)
            return cost[ind]; //we can start either from 0th or 1st stair as per the question
        if(ind<0)
            return 0;
        if(dp[ind]!=-1)
            return dp[ind];
        int stepOne=cost[ind]+calcMinCostUsingMemoisation(ind-1,cost,dp); //cost of wherever we are standing is added
        int stepTwo=cost[ind]+calcMinCostUsingMemoisation(ind-2,cost,dp); //cost of wherever we are standing is added
        return dp[ind]=Math.min(stepOne,stepTwo);
    }

    //only dp array=> space complexity=O(N)+O(N)
    static int calcMinCostUsingTabulation(int []cost){
        int n=cost.length;
        //Step1: Create DP array
        int []dp=new int[n];
        //Step2: base case analysis
        dp[0]=cost[0];
        dp[1]=cost[1];
        //3rd step
        for(int i=2;i<n;i++){
            // similar to this stepdp[ind]=Math.min(stepOne,stepTwo)
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
    public static void main(String[] args) {
        ClimbingStairsMinCost solution = new ClimbingStairsMinCost();
        int[] cost = {10, 15, 20};
        //Either we can start from n-1 or n-2 => not that its same as it we are starting from 0 or 1, we are thinking in reverse here
        System.out.println("calcMinCostUsingRecursion"+Math.min(calcMinCostUsingRecursion(cost.length-1,cost),calcMinCostUsingRecursion(cost.length-2,cost))); // Output: 15

        int []dp=new int[cost.length];
        Arrays.fill(dp, -1);
        System.out.println("calcMinCostUsingMemoisation"+Math.min(calcMinCostUsingMemoisation(cost.length-1,cost,dp),calcMinCostUsingMemoisation(cost.length-2,cost,dp))); // Output: 15

        System.out.println("calcMinCostUsingTabulation"+calcMinCostUsingTabulation(cost));
    }
}

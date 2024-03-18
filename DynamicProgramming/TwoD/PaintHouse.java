package DynamicProgramming.TwoD;

import java.util.Arrays;

/*
Leetcode Link: https://leetcode.com/problems/paint-house/description/
There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.

For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
Return the minimum cost to paint all houses.

Brute force:
For 1st House= We have 3 choices
For 2nd House= We have 2 choices
For 3rd House= We have 2 choices
.
.
For Nth House= We have 2 choices
There total 2^n ways.
Video solution: https://www.youtube.com/watch?v=-w67-4tnH5U

 */
class PaintHouse{
    public static int minPaintCost(int [][]costs, int [][]dp){
        dp[0]=costs[0];
        int n=costs.length;
        for(int i=1;i<costs.length;i++){
            dp[i][0]=costs[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=costs[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2]=costs[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
        }
        return Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
    }
    public static void main(String []args){
        int[][] costs = {{17, 2, 17},
                {16, 16, 5},
                {14, 3, 19}};
        int [][] dp = new int[costs.length][3];
        for(int []rows:dp){
            Arrays.fill(rows, -1);
        }
        System.out.println(minPaintCost(costs,dp));
    }
}
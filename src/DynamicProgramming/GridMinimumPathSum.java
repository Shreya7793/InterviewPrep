package DynamicProgramming;

import java.util.Arrays;

/*
Problem: We are given an “N*M” matrix of integers.
We need to find a path from the top-left corner to the bottom-right corner of the matrix,
such that there is a minimum cost past that we select.
Minimum Path Sum: https://www.youtube.com/watch?v=_rgTlyky1uQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=12
Problem Link: https://takeuforward.org/data-structure/minimum-path-sum-in-a-grid-dp-10/
 */
public class GridMinimumPathSum {
    static int GridMinimumPathSumUsingRecursion(int i, int j, int [][]arr){
        // If we're at the top-left cell, return its value
        if(i==0&&j==0)
            return arr[0][0];
        // If we're out of bounds, then set it to some max value
        if(i<0||j<0)
            return Integer.MAX_VALUE;
        // Calculate the sum of the current cell plus the minimum sum path from above and from the left
        int up = arr[i][j]+GridMinimumPathSumUsingRecursion(i-1,j,arr);
        int left = arr[i][j]+GridMinimumPathSumUsingRecursion(i,j-1,arr);
        return Math.min(up,left);
    }
    static int GridMinimumPathSumUsingMemoisation(int i, int j, int [][]arr, int [][]dp){
        if(i==0&&j==0)
            return arr[0][0];
        if(i<0||j<0)
            return Integer.MAX_VALUE;

        // If we've already calculated this cell, return the stored result
        if(dp[i][j]!=-1)
            return dp[i][j];
        int up = arr[i][j] + GridMinimumPathSumUsingRecursion(i-1,j,arr);
        int left = arr[i][j] + GridMinimumPathSumUsingRecursion(i,j-1,arr);

        // Store the minimum of the two possible paths
        return dp[i][j]=Math.min(up,left);
    }
    static int minSumPathUtil(int i, int j, int[][] matrix, int[][] dp) {
        // Base cases
        if (i == 0 && j == 0)
            return matrix[0][0]; // If we're at the top-left cell, return its value
        if (i < 0 || j < 0)
            return (int) Math.pow(10, 9); // If we're out of bounds, return a large value
        if (dp[i][j] != -1)
            return dp[i][j]; // If we've already calculated this cell, return the stored result

        // Calculate the sum of the current cell plus the minimum sum path from above and from the left
        int up = matrix[i][j] + minSumPathUtil(i - 1, j, matrix, dp);
        int left = matrix[i][j] + minSumPathUtil(i, j - 1, matrix, dp);

        // Store the minimum of the two possible paths
        return dp[i][j] = Math.min(up, left);
    }
    public static void main(){
        // Define the matrix
        int matrix[][] = {
                {5, 9, 6},
                {11, 5, 2}
        };
        int numRows=matrix.length;
        int numCols=matrix[0].length;
        System.out.println("GridMinimumPathSumUsingRecursion:"+GridMinimumPathSumUsingRecursion(numRows-1,numCols-1,matrix));
        int [][]dp=new int[numRows][numCols];
        for(int []rows:dp)
            Arrays.fill(rows, -1);
        System.out.println("GridMinimumPathSumUsingMemoisation:"+minSumPathUtil(numRows-1,numCols-1,matrix,dp));

    }
}

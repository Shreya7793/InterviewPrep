package DynamicProgramming;

import java.util.Arrays;

/*
Video Link: https://www.youtube.com/watch?v=sdE0A2Oxofw&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=9
Problem Link: https://takeuforward.org/data-structure/grid-unique-paths-dp-on-grids-dp8/
Problem1:Given two values M and N, which represent a matrix[M][N].
We need to find the total unique paths from the top-left cell (matrix[0][0]) to the rightmost cell (matrix[M-1][N-1]).

Problem2: Maze with obstacles:
We are given an “N*M” Maze. The maze contains some obstacles.
A cell is ‘blockage’ in the maze if its value is -1.
0 represents non-blockage. There is no path possible through a blocked cell.
Video Link: https://www.youtube.com/watch?v=TmhpgXScLyY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=11
Problem Link: https://takeuforward.org/data-structure/grid-unique-paths-2-dp-9/
 */
public class GridUniquePaths {
   /*
   Time Complexity: O(M*N)
   Reason: At max, there will be M*N calls of recursion.
   Space Complexity: O((N-1)+(M-1)) + O(M*N)
   Reason: We are using a recursion stack space: O((N-1)+(M-1)), here (N-1)+(M-1) is the path length and an external DP Array of size ‘M*N’.
    */
    static int sumUniquePathUsingMemoisation(int i, int j,int[][]dp){
        // If we reach the starting cell (0, 0), there's one way to reach it.
        if(i==0 && j==0)
            return 1;
        // If we go out of bounds, there's no way to reach the cell.
        if(i<0 ||j<0)
            return 0;
        // If the value for this cell is already computed, return it.
        if(dp[i][j]!=-1)
            return dp[i][j];
        // Calculate the number of ways by moving up and moving left.
        int up=sumUniquePathUsingMemoisation(i-1,j,dp);
        int left=sumUniquePathUsingMemoisation(i,j-1,dp);
        return dp[i][j]=up+left;
    }
    static int sumUniquePath2UsingMemoisation(int i, int j,int [][]maze,int[][]dp){
        // If we reach the starting cell (0, 0), there's one way to reach it.
        if(i==0 && j==0)
            return 1;
        // If we go out of bounds, there's no way to reach the cell.
        // If there's an obstacle at this cell or out of bounds, return 0
        if (i >= 0 && j >= 0 && maze[i][j] == -1)
            return 0;
        if(i<0 ||j<0)
            return 0;
        // If the value for this cell is already computed, return it.
        if(dp[i][j]!=-1)
            return dp[i][j];
        // Calculate the number of ways by moving up and moving left.
        int up=sumUniquePath2UsingMemoisation(i-1,j,maze,dp);
        int left=sumUniquePath2UsingMemoisation(i,j-1,maze,dp);
        return dp[i][j]=up+left;
    }
    public static void main(){
        int m=3 ; //row
        int n=2; //col
        int [][]dp=new int[m][n];
        for(int []rows:dp)
            Arrays.fill(rows, -1);
        System.out.println(sumUniquePathUsingMemoisation(m-1,n-1,dp));
        System.out.println("Maze with Obstacles!!");
        int[][] maze = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };
        int numrows= maze.length;
        int numCols= maze[0].length;
        int [][]dpMaze2=new int[numrows][numCols];
        for(int []rows:dpMaze2)
            Arrays.fill(rows, -1);
        System.out.println(sumUniquePath2UsingMemoisation(numrows-1,numCols-1,maze,dpMaze2));

    }
}

package DynamicProgramming;

import java.util.Arrays;

/*
Video Link: https://www.youtube.com/watch?v=AE39gJYuRog&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=8
Problem Statement: A Ninja has an ‘N’ Day training schedule.
He has to perform one of these three activities (Running, Fighting Practice, or Learning New Moves) each day.
There are merit points associated with performing an activity each day. The same activity can’t be performed on
two consecutive days. We need to find the maximum merit points the ninja can attain in N Days.
 */

public class NinjaTraining {
    static int maxPointUsingMemoisation(int day, int last, int [][]points, int [][]dp){
        // Base case: When it's the first day (day == 0)
        if(day==0){
            int maxpoint=Integer.MIN_VALUE;
            // Loop through the three activities
            for(int i=0;i<=2;i++)
            {
                maxpoint=Math.max(maxpoint,points[0][i]);
            }
            return dp[day][last]=maxpoint;
        }

        // If the result is already calculated, return it
        if(dp[day][last]!=-1)
            return dp[day][last];
        // Loop through the three activities on the current day
        int maxpoint=Integer.MIN_VALUE;
        for(int i=0;i<=2;i++){
            //if i-th activity not equal to last activity
            if(i!=last){
                // 1. Calculate the points for the current activity
                // 2. Recursively calculate the maximum points for the previous day
                int activityPoint= points[day][i] + maxPointUsingMemoisation(day-1, last, points, dp);
                maxpoint= Math.max(maxpoint,activityPoint);
            }
        }
        System.out.println(dp[day][last]);
        return dp[day][last]=maxpoint; //Store the answer that you're returning
    }
    public static void main(){
    // Define the points for each activity on each day
        int[][] points = {{10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}};
        int noOfDays= points.length;
        int [][]dp=new int[noOfDays][4];
        for(int []row:dp)
            Arrays.fill(row, -1);
        System.out.println("Maximum Points Using Memoisation: "+maxPointUsingMemoisation(noOfDays-1,3,points,dp));
    }
}

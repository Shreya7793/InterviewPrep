package DynamicProgramming;

import java.util.Arrays;

/*
Max sum of Non-adjacent elements
Problem Statement: Given an array of ‘N’  positive integers, we need to return the maximum sum of the subsequence
such that no two elements of the subsequence are adjacent elements in the array.
Hint: subsequence => pick /not pick
Problem Link: https://takeuforward.org/data-structure/maximum-sum-of-non-adjacent-elements-dp-5/
Video Link: https://www.youtube.com/watch?v=fJaKO8FbDdo&t=1s
houseRobberWithRecursion= TC=~O(2^N)
houseRobberWithMemoisation= TC= O(N) ; since we are fetching the overalapping subproblems from the dp array in 0(1) time
Space Complexity: O(N)
Reason: We are using a recursion stack space(O(N)) and an array (again O(N)).
Therefore total space complexity will be O(N) + O(N) ≈ O(N)
houseRobberWithTabulation:
Time Complexity: O(N)
Reason: We are running a simple iterative loop
Space Complexity: O(N)
Reason: We are using an external array of size ‘n+1’.
 */
public class HouseRobber1 {

    static int houseRobberWithRecursion(int ind, int []arr){
        //base case
        if(ind==0) //if we have reached here means the adacent element has not be chosen so return the value at the index
            return arr[ind];
        if(ind<0) // If the index is negative, there are no elements left to consider.
            return 0;
        //if we are at ind, we have two options-pick ind or not pick ind
        //in case we pick, we cannot pick the adacent elem in the next recursion call
        int pick = arr[ind] + houseRobberWithRecursion(ind-2, arr);
        int notPick = 0 + houseRobberWithRecursion(ind-1, arr);

        return Math.max(pick , notPick);
    }
    static int houseRobberWithMemoisation(int ind, int []arr, int []dp){
        if(ind==0)
            return ind;
        if(ind<0)
            return 0;
        if(dp[ind]!=-1)
            return dp[ind];
        int pick = arr[ind] + houseRobberWithMemoisation(ind-2, arr,dp);
        int notPick = 0 + houseRobberWithMemoisation(ind-1, arr,dp);

        return dp[ind]=Math.max(pick , notPick);
    }
    static int houseRobberWithTabulation(int []arr, int []dp){
        int n=arr.length;
        if(n==0) // Handle the case when the array is empty
            return 0;
        if(n==1) // Handle the case when there is only one house
            return arr[0];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        for(int i=2; i<n;i++) {
            int pick = arr[i] + dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n-1]; // Return the maximum value obtained after considering all houses
    }
    public static void main(String []args){
        int arr[] = {2, 1, 4, 9};
        int n =arr.length;

        // Using recursion
        int result = houseRobberWithRecursion(n-1, arr);
        System.out.println("Result with recursion: " + result);

        // Using memoization
        int []dp = new int[arr.length];
        Arrays.fill(dp, -1);
        result = houseRobberWithMemoisation(n-1, arr,dp);
        System.out.println("Result with memoization: " + result);

        // Using tabulation
        dp = new int[arr.length];
        Arrays.fill(dp, -1);
        result = houseRobberWithTabulation( arr,dp);
        System.out.println("Result with tabulation: " + result);
    }
}

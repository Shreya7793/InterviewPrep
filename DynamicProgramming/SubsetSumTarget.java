package DynamicProgramming;

import java.util.Arrays;
/*
Video Link: https://www.youtube.com/watch?v=fWX9xDmIzRI&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=16
Problem Link: https://takeuforward.org/data-structure/subset-sum-equal-to-target-dp-14/
You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.
Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.

Recursion
TC: O(2^N), where N is the number of elements in the input array arr
SC: function is O(N) as well, where N is the maximum recursion depth.
This space is used to store the function call stack during the recursive calls.
Since each recursive call consumes space on the stack, and the maximum depth of the recursion is
proportional to the size of the input array, the space complexity is linear with respect to the size of the input array.

Memoisation:
TC: O(N * target) ; N is the number of elements in the array and target is the target sum.
This is because there are N * target subproblems to solve, and each subproblem takes constant time to solve
Sc:
 */
public class SubsetSumTarget {
    static boolean subsetSumEqualsTargetWithRecursion(int ind,int target, int []arr){
        // Base case: If the target sum is reached, return true
        if(target==0)
            return true;
        // Base case: If all elements have been considered but target sum is not reached, return false
        if (ind < 0) {
            return false;
        }
        boolean pick=false;
        if(arr[ind]<=target)
            pick=subsetSumEqualsTargetWithRecursion(ind-1, target-arr[ind],arr);
        boolean notPick=subsetSumEqualsTargetWithRecursion(ind-1, target,arr);
        return pick||notPick;
    }
    static int subsetSumEqualsTargetWithMemoisation(int ind,int target, int []arr, int [][]dp){
        // Base case: If the target sum is reached, return true
        if(target==0)
            return 1;
        // Base case: If all elements have been considered but target sum is not reached, return false
        if (ind < 0) {
            return 0;
        }
        if(dp[ind][target]!=-1)
            return dp[ind][target];
        int pick=0;
        if(arr[ind]<=target)
            pick=subsetSumEqualsTargetWithMemoisation(ind-1, target-arr[ind],arr,dp);
        int notPick=subsetSumEqualsTargetWithMemoisation(ind-1, target,arr,dp);
        return dp[ind][target]=pick|notPick; //bitwise OR operation
    }
    public static void main(String args[]){
        int arr[] = { 1, 2, 3, 4 };
        int target = 4;
        System.out.println("subsetSumEqualsTargetWithRecursion:"+subsetSumEqualsTargetWithRecursion(arr.length-1,target,arr));
        int [][]dp=new int[arr.length][target+1]; //target+1 so that we can handle from 0 to target
        for(int []rows:dp)
            Arrays.fill(rows, -1);
        System.out.println("subsetSumEqualsTargetWithMemoisation:"+subsetSumEqualsTargetWithMemoisation(arr.length-1,target,arr,dp));

    }
}

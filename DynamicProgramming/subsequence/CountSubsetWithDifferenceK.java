package DynamicProgramming.subsequence;

import java.util.Arrays;

/*
Problem Link: https://takeuforward.org/data-structure/count-partitions-with-given-difference-dp-18/
S1-s2=D;-> eq1 s1>=s2
s1+s2=Total sum->eq 2
eq1+eq2=> s1=(D+Total Sum)/2

This question is similar to : Target Sum Link:https://takeuforward.org/data-structure/target-sum-dp-21/
Problem statement:
We are given an array ‘ARR’ of size ‘N’ and a number ‘Target’.
Our task is to build an expression from the given array where we can place a ‘+’ or ‘-’ sign in front of an integer.
We want to place a sign in front of every integer of the array and get our required target.
We need to count the number of ways in which we can achieve our required target.
 */
public class CountSubsetWithDifferenceK {
    /*
    Time Complexity: O(N*K)
    Reason: There are N*K states therefore at max ‘N*K’ new problems will be solved.
    Space Complexity: O(N*K) + O(N)
    Reason: We are using a recursion stack space(O(N)) and a 2D array ( O(N*K)).
     */
   static int countSubsetWithDifferenceK(int ind, int target, int []nums, int[][]dp){
       //Base Case:
        if(ind==0){
            if(nums[ind]==target)
                return 1;
            else
                return 0;
        }
        if(target==0)
            return 1;

        /* This is the base case if array has 0 as one of it's element
       // Base case: If we have reached the first element
       if (ind == 0) {
           // Check if the target is 0 and the first element is also 0
           if (target == 0 && arr[0] == 0)
               return 2;
           // Check if the target is equal to the first element or 0
           if (target == 0 || target == arr[0])
               return 1;
           return 0;
       }
       */
        if(dp[ind][target]!=-1)
            return dp[ind][target];

        int pick=0;
        if(nums[ind]<=target)
            pick=countSubsetWithDifferenceK(ind-1,target-nums[ind],nums,dp);
        int notPick=countSubsetWithDifferenceK(ind-1,target,nums,dp);

        return dp[ind][target]=pick+notPick; //find all ways=sum of pick ways+sum of notpick ways
    }
    public static void main(String []args){
        int nums[] = {5,2,6,4};
        int diff = 3; int sum=0;

        for(int i=0;i<nums.length;i++)
            sum += nums[i];
        int target=(diff+sum)/2;

        int [][]dp=new int[nums.length][target+1]; //col index will go from 0 to sum. Therefor size would be till sum+1
        for(int []rows:dp)
            Arrays.fill(rows,-1);

        System.out.println("The number of subsets found are " + countSubsetWithDifferenceK(nums.length-1,target, nums,dp));
    }
}

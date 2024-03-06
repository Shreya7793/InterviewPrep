package DynamicProgramming.subsequence;

import java.util.Arrays;

/*
Problem Ref: https://takeuforward.org/data-structure/partition-equal-subset-sum-dp-15/
Problem: We are given an array ‘ARR’ with N positive integers. We need to find if we can partition the array into two subsets
such that the sum of elements of each subset is equal to the other.
If we can partition, return true else return false.

Hint: If S is odd, then two subsets with equal sum is not possible
S1+S2=Sum; if s1==s2
=> 2s1=sum
=> s1=sum/2;
This means that we need to check for one subset, then automatically we are getting the remaining 1 subset.
This becomes same as the subset problem with target.
 */
public class PartitionEqualSubsetSum {

    /*
     TC:  O(N*K) + O(N) There are N*K states therefore at max ‘N*K’ new problems will be solved and
     we are running a for loop for ‘N’ times to calculate the total sum
     SC: We are using a recursion stack space(O(N)) and a 2D array ( O(N*K)).
     */
    static boolean findEqualSubsetSum(int ind, int target, int []nums, int [][]dp){
        if(ind==0) { //at ind=0, if elem=target then we have found the subset=> return true
            if (nums[ind] == target)
                return true;
        }
        if(target==0) // If the target sum is 0, we have found a valid subset
            return true;
        if(dp[ind][target]==-1)
            return dp[ind][target]==0?false:true;
        boolean pick=false;
        if(nums[ind]<=target)
         pick=findEqualSubsetSum(ind-1,target-nums[ind],nums,dp);
        boolean notPick=findEqualSubsetSum(ind-1,target,nums,dp);
        dp[ind][target]=pick || notPick?1:0;
        return pick || notPick;
    }

    public static void main(String []args){
        int []nums={2, 3, 3, 3, 4, 5};
        int sum=0;
        boolean findEqualSubsetSum=false;
        for(int i=0;i<nums.length;i++)
            sum += nums[i];
        if(sum%2==1){
            System.out.println("Equal subset not possible");
        }
        else {
            int target=sum/2;
            int [][]dp=new int[nums.length][target+1];
            for(int []rows:dp)
                Arrays.fill(rows,-1);
            System.out.println(findEqualSubsetSum(nums.length-1,target,nums,dp));
        }

    }
}

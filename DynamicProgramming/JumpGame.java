package DynamicProgramming;

import java.util.Arrays;

/*
For Array of size N,
1)Recursion:
TC: O(n^max(nums))
max(nums) is the maximum value in the nums array.
This is because, in the worst case, each position might explore all possible jumps, leading to
n recursive calls, and the work done at each call is bounded by the maximum value in the nums array.
2)Memoisation: O(n)
3) Tabulation
 */
public class JumpGame {

    static boolean canJumpWithRecursion(int ind, int []nums){
        if(ind== nums.length-1)
            return true;
        for(int i=nums[ind];i>0;i--) {
            if(canJumpWithRecursion(i+ind, nums))
                return true; //If any jump lead to the end of the array , return true
        }
        return false;
    }
    static boolean canJumpWithMemoisation(int ind, int []nums, Boolean[]dp){
        if(ind== nums.length-1)
            return true;
        if(dp[ind]!=null)
            return dp[ind];
        for(int i=nums[ind];i>0;i--) {
            if(canJumpWithMemoisation(i+ind, nums,dp))
                return dp[ind]=true; //If any jump lead to the end of the array , return true
        }
        return false;
    }
    static boolean numOfJumpWithRecursion(int ind, int []nums){
        if(ind== nums.length-1)
            return true;
        for(int i=nums[ind];i>0;i--) {
            if(numOfJumpWithRecursion(i+ind, nums))
                return true; //If any jump lead to the end of the array , return true
        }
        return false;
    }
    public static void main(String []args){
        int []nums={2,3,1,1,4};
        Boolean []dp= new Boolean[nums.length];
        Arrays.fill(dp,null);
        System.out.println("canJumpWithRecursion:"+canJumpWithRecursion(0,nums));
        System.out.println("canJumpWithMemoisation:"+canJumpWithMemoisation(0,nums,dp));
    }
}

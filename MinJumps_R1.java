/*
Minimum number of jumps to reach end
Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3 (1-> 3 -> 9 -> 9)
Explanation: Jump from 1st element to 2nd element as there is only 1 step.
Now there are three options 5, 8 or 9. If 8 or 9 is chosen then the end node 9 can be reached. So 3 jumps are made.
Input:  arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
Output: 10
Explanation: In every step a jump is needed so the count of jumps is 10.
 */

import java.util.Arrays;

public class MinJumps_R1 {

    static int calcMinJumps(int []nums, int ind, int []dp){
        if(ind>=nums.length)
            return 1;
        if(dp[ind]!=-1)
            return dp[ind];
        int count=0;
        int notcount=0;
        for(int i=0;i<=ind;i++) {
            count = calcMinJumps(nums, ind + nums[i],dp);
            notcount=calcMinJumps(nums,ind,dp);
        }
        return dp[ind]=Math.min(count,notcount);
    }

    public static void main(){
        int []nums= {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        nums= new int[]{1, 3, 5};
        int []dp =new int[nums.length];
        Arrays.fill(dp, -1);
        System.out.println(calcMinJumps(nums,0,dp));
    }


}

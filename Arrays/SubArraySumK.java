package Arrays;

import java.util.HashMap;
import java.util.Map;

/*
Problem Statement:Given an array of integers and an integer k, return the total number of subarrays whose sum equals k.
Problem Link: https://takeuforward.org/arrays/count-subarray-sum-equals-k/
 */
//TODO: use prefix sum
public class SubArraySumK {
    static int maxLenSubArrSumK(int []nums, int k){
        Map <Integer,Integer>prefixsumCntMap = new HashMap<>();
        int preSum=0, maxLen=0;
        prefixsumCntMap.put(0,1);
        for(int i=0;i<nums.length;i++){
            preSum += nums[i];
            if(preSum==k){
                Math.max(maxLen,i+1);
            }



        }
        return count;
    }
    public static void main(String []args){
        int []nums={3, 1, 2, 4};
        int k=6;
        System.out.println("No. of subarray with sum k="+countSubArrSumK(nums,k));
    }
}

package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
Eg:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int leftPtr = 0;
        int rightPtr = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int arrLen = nums.length;

        while (rightPtr < arrLen) {
            if (sum < target) {
                sum += nums[rightPtr];
                rightPtr++;
            } else {
                minLength = Math.min(minLength, rightPtr - leftPtr);
                sum -= nums[leftPtr];
                leftPtr++;
            }
        }

        while (sum >= target && leftPtr < arrLen) {
            minLength = Math.min(minLength, rightPtr - leftPtr);
            sum -= nums[leftPtr];
            leftPtr++;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    static int minSubarrayTargetSumusingHashmap( int target,int []nums){
        int minLen=0;
        int sum=0;
        Map<Integer,Integer> prefixSumIndexMap= new HashMap<>();
        int len=nums.length;
        for(int i=0;i<len;i++){
            sum += nums[i];
            prefixSumIndexMap.put(sum,i);
            if(sum==target){
                minLen = i+1;
            }else {
                if (sum > target) {
                    //check if complementary value present
                    int complementarySum = sum - target;
                    if (prefixSumIndexMap.get(complementarySum) != null) {
                        int subArrLen=prefixSumIndexMap.get(sum) - prefixSumIndexMap.get(complementarySum);
                        if(minLen==0)
                            minLen=subArrLen;
                        else
                            minLen = Math.min(minLen,subArrLen);
                    }
                }
            }
        }
        return minLen;
    }
    public static void main(String []args){
        int []nums={2,3,1,2,4,3};
        int target=7;
        System.out.println("Minimum Size Subarray Sum"+minSubarrayTargetSumusingHashmap(target, nums));
        nums= new int[]{2, 3, 1, 2, 4, 3};
        target=11;
        System.out.println("Minimum Size Subarray Sum"+minSubArrayLen(target, nums));

    }
}

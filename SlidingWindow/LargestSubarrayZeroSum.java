package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Problem Statement: Given an array containing both positive and negative integers,
we have to find the length of the longest subarray with the sum of all elements equal to zero.

Problem Link: https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum/
Example 1:
Input Format: N = 6, array[] = {9, -3, 3, -1, 6, -5}
Result: 5
Explanation: The following subarrays sum to zero:
{-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
Since we require the length of the longest subarray, our answer is 5!

Worst case: to generate all subarrays, O(N^2)
Hint: use Hashmap<K,V>  <prefix sum,index>

 */
public class LargestSubarrayZeroSum {
    static int largestSubarrayZeroSum( int target,int []arr){
        int maxLen=Integer.MIN_VALUE;
        int sum=0;
        Map<Integer,Integer> prefixSumIndexMap= new HashMap<>();
        int len=arr.length;
        for(int i=0;i<len;i++){
            sum += arr[i];
            if(sum==0){
                maxLen = i+1;
            }else{
                if(prefixSumIndexMap.get(sum)!=null){
                    maxLen = Math.max(maxLen,i-prefixSumIndexMap.get(sum));
                }else
                    prefixSumIndexMap.put(sum,i);
            }
        }
        return maxLen==Integer.MIN_VALUE?0:maxLen;
    }
    public static void main(String []args){
        int []nums={1,2, -2, 4, -4};
        int target=4;
        System.out.println("Minimum Size Subarray Sum:"+largestSubarrayZeroSum(target, nums));
    }
}


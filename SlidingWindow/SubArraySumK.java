package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Problem Statement:Given an array of integers and an integer k, return the total number of subarrays whose sum equals k.
Problem Link: https://takeuforward.org/arrays/count-subarray-sum-equals-k/
Using HashMap:
Solution Link: https://www.youtube.com/watch?v=XzwUBIkR9pA
TC: O(N)
SC: O(N)-> hashmap

This can be solved using two pinter approach also.

The following sum takes care of 4 problems' patterns:
1. Longest Subarray w/ sum k
2. Min Subarray w/ sum k
3. Longest Subarray w/ sum 0
4. Count the num of subarray w/ sum k
 */
//TODO: use prefix sum
public class SubArraySumK {
    static int longestSubArrSumK(int []nums, int sum){
        Map <Integer,Integer>prefixsumCntMap = new HashMap<>();
        int currSum=0;
        int start=0,end=0;
        int maxLen=Integer.MIN_VALUE; //To find max length of subarray
        int minLen=Integer.MAX_VALUE; //To find min length of subarray
        int count=0; //To count number of subarray
        for(int i=0;i<nums.length;i++){
            currSum += nums[i];
           //To handle edge case where sum is same from 0th index
            //Eg: {0,0,0,4} sum=4 => longest subarray would be of size 4
            if(currSum-sum==0){
                start=0;
                end=i;
                maxLen=Math.max(maxLen,end-start+1);
                minLen=Math.min(minLen,end-start+1);
                ++count;
                break;
            }
            else if(prefixsumCntMap.containsKey(currSum-sum)){
                start=prefixsumCntMap.get(currSum-sum)+1;
                end=i;
                maxLen=Math.max(maxLen,end-start+1);
                minLen=Math.min(minLen,end-start+1);
                ++count;
            }else
                prefixsumCntMap.put(currSum,i);

        }
        //Length=end-start+1;
        System.out.println("Max Len:"+maxLen+" Min Length:"+minLen);
        System.out.println("No. of subarrays"+count);
        return end-start+1;
    }
    public static void main(String []args){
        int []nums={0,0, 4, 1,0, 4};
        nums=new int[]{1,2,-2,4,-4};
        int sum=0;
        System.out.println("No. of subarray with sum k="+longestSubArrSumK(nums,sum));
    }
}

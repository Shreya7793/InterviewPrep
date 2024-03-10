package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Problem Link: https://leetcode.com/problems/two-sum/description/?envType=study-plan-v2&envId=top-interview-150
Problem Link(Sorted array): https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150
Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Approach 1: Using Hashmap-> for sorted and unsorted array
Approach2: Using Two Pointers-> Used in sorted array

 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> elemIndexMap = new HashMap<>(); //Stores element and index
        for (int i = 0; i < nums.length; i++) {
            if (elemIndexMap.containsKey(target - nums[i])) { //Note this!
                return new int[]{elemIndexMap.get(target - nums[i]), i};
            }
            elemIndexMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
    public static int[] twoSumSortedArr(int[] numbers, int target) { //USing two ponters
        int leftPtr=0, rightPtr=numbers.length-1; //Two pointers at two ends
        int sum=0;
        while(leftPtr<numbers.length || rightPtr>0){
            sum=numbers[leftPtr]+numbers[rightPtr];
            if(sum==target)
                return new int[]{leftPtr+1, rightPtr+1}; //Note the question asked to add 1
            else if(sum<target)
                ++leftPtr;
            else
                --rightPtr;
        }
        return new int[]{-1, -1};
    }
    public static void main(String []args){
        int []nums={2,7,11,15};
        int target=9;
        System.out.println("twoSum:"+ Arrays.toString(twoSum(nums,target)));
        System.out.println("twoSumSortedArr:"+ Arrays.toString(twoSumSortedArr(nums,target)));

    }
}

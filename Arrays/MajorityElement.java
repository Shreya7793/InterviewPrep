package Arrays;

import java.util.HashMap;
import java.util.Map;

/*
Problem Link: https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
Solution Ref:  https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/
The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.
Example 1:
Input: nums = [3,2,3]
Output: 3
Brute Force: to count the appearence of every elemnent and check if the count>n/2
TC: O(N^2)
Optimised: Using Hashmap-> extra space
Moore's algorithm: https://www.youtube.com/watch?v=X0G5jEcvroo
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int majority= nums.length/2;
        Map<Integer,Integer> numFreqMap= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(numFreqMap.containsKey(nums[i]))
                numFreqMap.put(nums[i],numFreqMap.getOrDefault((nums[i]),0)+1);
            else
                numFreqMap.put(nums[i],1);
        }
        for(Map.Entry<Integer,Integer> mapEntry:numFreqMap.entrySet()){
            if(mapEntry.getValue()>majority)
                return mapEntry.getKey();
        }
        return -1;
    }
    //Using Moore's Voting Algorithm
    public static int majorityElementMooreAlgo(int[] nums) {
        int elem=nums[0];
        int count=1;
        //Moore's Algo
        for(int i=1;i<nums.length;i++) {
            if(nums[i]==elem) {
                ++count;
            }
            else
            {
                if(count>0)
                    --count;
                else
                    elem=nums[i];
            }
        }
        //check if the stored element is the majority element
        int elemCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==elem)
                ++elemCount;
        }
        if(elemCount>nums.length/2)
            return elem;
        else
            return -1;
    }
    public static void main(String []args){
        int []nums={2,2,1,1,1,2,2};
        System.out.println("Majority Element:"+majorityElement(nums));
        System.out.println("Using Moore's Algorithm!");
        System.out.println("Majority Element:"+majorityElementMooreAlgo(nums));
    }
}

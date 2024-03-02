package Arrays;

import java.util.HashMap;
import java.util.Map;

/*
Problem Link: https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
Solution Ref:  https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int majority= nums.length/2;
        Map<Integer,Integer> numFreqMap= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(numFreqMap.containsKey(nums[i]))
                numFreqMap.put(nums[i],numFreqMap.get(nums[i])+1);
            else
                numFreqMap.put(nums[i],1);
        }
        for(Map.Entry<Integer,Integer> mapEntry:numFreqMap.entrySet()){
            if(mapEntry.getValue()>majority)
                return mapEntry.getKey();
        }
        return -1;
    }
    public static void main(String []args){
        int []nums={2,2,1,1,1,2,2};
        System.out.println("Majority Element:"+majorityElement(nums));
    }
}

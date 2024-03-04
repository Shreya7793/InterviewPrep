package Arrays;

import java.util.Arrays;

/*
Remove Duplicates from Sorted Array II
Problem Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
Problem Statement: at most 2 duplicates in a sorted order
Two Pointers i=0, j=1
TC: O(N)
SC: O(1)
 */
public class RemoveDuplicates {
    static int removeDuplicates(int []nums){
        int leftPtr=0,cnt=1;// Initialize count to 1 because the first occurrence is always valid
        for(int rightPtr=1; rightPtr<nums.length;rightPtr++){
            //if its not equal , no need to check the count
            if(nums[leftPtr]!=nums[rightPtr]){ //compare the previous element to current element
                ++leftPtr;
                nums[leftPtr]=nums[rightPtr];
                cnt=1; //reset the counter since it's a new element
            }
            else{//if the prev & curr elem are same
                    if(cnt<2){ //means that we haven't reached atmost 2 elements
                        ++leftPtr;
                        nums[leftPtr]=nums[rightPtr];
                        ++cnt;
                    }
                }
    }
        System.out.println(Arrays.toString(nums));
        return leftPtr;
    }
    public static void main(String [] args){
        int []nums={1,2,2,2,3,3};
        nums= new int[]{1,1,1,2,2,3};
        System.out.println("removeDuplicates"+removeDuplicates(nums));
    }
}

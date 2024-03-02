package Arrays;

import java.util.Arrays;

/*
Problem Link: https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
TC: O(N)
SC: While using temp arr=O(N) ; w/o using temp arr O(1)
 */
public class RotateArray {
    //uses temp array
    public static int[] rotateRight(int[] nums, int k) {
        //copy to temp array
        int []temp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            temp[i]=nums[i];
        }
        for(int i=0;i<k;i++){
            temp[i]=nums[i+k+1];
        }
        int j=0;
        for(int i=k;i<nums.length;i++){
            temp[i]=nums[i-k];
            j++;
        }
        return temp;
    }
    public static int[] rotateRightWithoutTemp(int[] nums, int k) {
        int n=nums.length;
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
        return nums;
    }
    public static int[] rotateLeftWithoutTemp(int[] nums, int k) {
        int n=nums.length;
        // Handle edge cases where k might be greater than the length of the array
        k %= nums.length;
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
        return nums;
    }
    public static int[] reverse(int []arr, int start, int end){
        while(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            ++start;
            --end;
        }
        return arr;
    }
    public static void main(String []args){
        int []nums={1,2,3,4,5,6,7};
        int kSteps=3; //in case kSteps>nums.length ; then simplify using KSteps=KSteps%nums.length
        System.out.println("rotateRight:"+ Arrays.toString(rotateRight(nums,kSteps)));
        System.out.println("rotateRight without temp arr:"+ Arrays.toString(rotateRightWithoutTemp(nums,kSteps)));
    }


}

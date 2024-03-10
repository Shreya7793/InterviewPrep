package Arrays;
/*
Problem Statement: To find maximum sum in sub array
Brute force - to find all sub arrays and the find max sum. TC=0(N^2)
Youtube: https://www.youtube.com/watch?v=HCL4_bOd3-4
Kadanes's Algorithm:
Kadane's algorithm is used to find the maximum sum contiguous subarray within a one-dimensional array of numbers.
The intuition of the algorithm is not to consider the subarray as a part of the answer if its sum is less than 0.
Subarray with a sum less than 0 will always reduce our answer and so this type of subarray cannot be a part of the subarray with maximum sum.
-Always move to the right of the array and keep on adding
-If sum<0 , then drop because it’s of no more significance to me
TC = O(N)
SC= O(1)
 */
public class MaxSumInSubArray {
    //Kadane's Algo
    static int maxSumInSubArray(int []nums){
        int maxSum=0;
        int currSum=0;
        for(int i=0;i<nums.length;i++){ //Always move towards right
            currSum += nums[i];
            if(currSum>maxSum){
                maxSum=currSum;
            }
            if(currSum<0)
                currSum=0; //If sum<0 , then drop because it’s of no more significance in maximising the sum
        }
        return maxSum;
    }
    public static void main(String []args){
        int []nums={5,-4,-2,6,-1};
        System.out.println("max Sum In SubArray:"+maxSumInSubArray(nums));
    }
}

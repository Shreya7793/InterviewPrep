package Arrays;
/*
https://leetcode.com/problems/remove-element/submissions/1196855454/?envType=study-plan-v2&envId=top-interview-150
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Hint: Two Pointers, one pointer at start, other at the end
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int leftPtr=0;int rightPtr=nums.length-1;
        while(leftPtr<=rightPtr){
            if(nums[leftPtr]==val){
                int temp=nums[leftPtr];
                nums[leftPtr]=nums[rightPtr];
                nums[rightPtr]=temp;
                --rightPtr;
            }else{
                ++leftPtr;
            }
        }
        return leftPtr;
    }
    public static void main(String []args){
        int []nums={3,2,2,3};
        int val=3;
        System.out.println(removeElement(nums,val));
    }
}

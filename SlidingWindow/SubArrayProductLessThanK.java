package SlidingWindow;
/*
Ref: https://leetcode.com/problems/subarray-product-less-than-k/description/
 */
public class SubArrayProductLessThanK {
    public int countSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0; // If k is less than or equal to 1, no subarray product will be less than k

        int count = 0;
        int product = 1;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

                // Shrink the window from the left until the product is less than k{
                while (product >= k) {
                    product /= nums[left];
                    left++;
                }
            //Whenever we are expanding the window for the next loop, we add the element, that's why +1 in the expression
            count += right - left + 1;
        }
            return count;
    }

    public static void main(String[] args) {
        SubArrayProductLessThanK solution = new SubArrayProductLessThanK();
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(solution.countSubarrayProductLessThanK(nums, k)); // Output should be 8
    }
}

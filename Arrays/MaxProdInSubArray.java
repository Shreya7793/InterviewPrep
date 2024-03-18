package Arrays;

public class MaxProdInSubArray {
    public static int maxProductSubArray(int []nums){
        int prefixProd=1;
        int suffixProd=1;
        int maxProd=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                prefixProd=1;
                suffixProd=1;
            }
            prefixProd=nums[i]*prefixProd;
            suffixProd=nums[nums.length-i-1]*suffixProd; //suffix prod is from the end
            maxProd=Math.max(maxProd,Math.max(prefixProd,suffixProd));
        }
        return  maxProd;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 0, -4, -5};
        int answer = maxProductSubArray(arr);
        System.out.println("The maximum product subarray is: " + answer);
    }
}

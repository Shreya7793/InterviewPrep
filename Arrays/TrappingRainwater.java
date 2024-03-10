package Arrays;
/*
Problem Link: https://leetcode.com/problems/trapping-rain-water/description/
Solution Link: https://www.youtube.com/watch?v=UZG3-vZlFM4
Hint: Use two auxilarry arrays: left, right and fill with max values to the left and right respectively
 */
public class TrappingRainwater {
    static int trappingRainwater(int []height){
        int []left=new int[height.length];
        int []right=new int[height.length];
        int leftMax=Integer.MIN_VALUE;
        int rightMax=Integer.MIN_VALUE;
        int rainWaterUnit=0;
        //Fill the left array by taking the maximum left value
        for(int i=0;i<height.length;i++){
            leftMax=Math.max(leftMax,height[i]);
            left[i]=leftMax;
        }
        //Fill the right array by taking the maximum right value
        for(int i=height.length-1;i>=0;i--){
            rightMax=Math.max(rightMax,height[i]);
            right[i]=rightMax;
        }
        for(int i=0;i<height.length;i++){
            rainWaterUnit += Math.min(right[i],left[i])-height[i]; //The formula: Min(left-right)-height
        }
        return rainWaterUnit;
    }
    public static void main(String []args){
        int []height={3,1,2,4,0,1,3,2};
        System.out.println("trapping Rainwater= "+trappingRainwater(height));
    }
}

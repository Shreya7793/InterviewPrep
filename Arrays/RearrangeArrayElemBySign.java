package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Problem Statement: https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
Solution:   https://takeuforward.org/arrays/rearrange-array-elements-by-sign/
Video Solution: https://www.youtube.com/watch?v=h4aBagy4Uok&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=10
Two variety:
1. No. of Positive & Negative same -> here we can do with one aux arr
2. No. of Positive & Negative not same -> would need to list -> postive and negative list; only brute force approach will work here
 */
public class RearrangeArrayElemBySign {

    //This optimal solution works if there are equal number of positive or negative elements
    static int[] rearrangeArrayElementsBySign(int []nums){
        int []auxArr=new int[nums.length];
        int posInd=0, negInd=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0)
            {
                auxArr[posInd]=nums[i];
                posInd += 2;
            }else{
                auxArr[negInd]=nums[i];
                negInd += 2;
            }
        }
        return auxArr;
    }
    static int[] rearrangeArrayElementsBySignBrute(int []nums){
        List<Integer> posList = new ArrayList<>();
        List<Integer> negList = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0)
            {
                posList.add(nums[i]);
            }else{
                negList.add(nums[i]);
            }
        }
        if(posList.size()>negList.size()){ //No. of postive > No. of negative
            for(int i=0;i<negList.size();i++){
                nums[2*i]=posList.get(i);
                nums[2*i+1]=negList.get(i);
            }
            int index=negList.size()*2;
            for(int i=negList.size();i<posList.size();i++){
                nums[index]=nums[i];
                ++index;
            }
        }else{ //No. of Negative > No. of Positive
            for(int i=0;i<posList.size();i++){
                nums[2*i]=posList.get(i);
                nums[2*i+1]=negList.get(i);
            }
            int index=posList.size()*2;
            for(int i=posList.size();i<negList.size();i++){
                nums[index]=nums[i];
                ++index;
            }
        }
        return nums;
    }
    public static void main(String []args){
        int []nums={3,1,-2,-5,2,-4}; //No. of Positive = No. of negative
        System.out.println("rearrangeArrayElementsBySign"+ Arrays.toString(rearrangeArrayElementsBySign(nums)));
        System.out.println("rearrangeArrayElementsBySignBrute"+ Arrays.toString(rearrangeArrayElementsBySignBrute(nums)));


    }
}

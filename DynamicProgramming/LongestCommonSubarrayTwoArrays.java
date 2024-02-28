package DynamicProgramming;
public class LongestCommonSubarrayTwoArrays {
    static int longestSubtringTwoArrays(int ind1, int ind2, int []arr1, int[] arr2, int maxCount){
        if(ind1==arr1.length || ind2==arr2.length)
            return maxCount;

        //If current elements are equal recursively check the next elements
        if(arr1[ind1]==arr2[ind2])
            maxCount=Math.max(maxCount, longestSubtringTwoArrays(ind1+1, ind2+1, arr1, arr2, maxCount+1));

        /*Two Possibilities
          1. Exclude current elem of A, continue with B
          2. Exclude current elem of B, continue with A
         */
        int count1=longestSubtringTwoArrays(ind1, ind2+1, arr1, arr2, 0);
        int count2=longestSubtringTwoArrays(ind1+1, ind2, arr1, arr2, 0);

        return maxCount=Math.max(maxCount,Math.max(count1,count2));
    }
    public static void main(String []args){
        int []arr1={1,3,7};
        int []arr2={1,0,3};
        int maxCount= 0;
        System.out.println("longestSubtringTwoArrays:"+longestSubtringTwoArrays(0,0,arr1, arr2,maxCount));
    }

}

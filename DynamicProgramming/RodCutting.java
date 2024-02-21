package DynamicProgramming;
/*
Video Link: https://www.youtube.com/watch?v=mO8XpGoJwuo&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=25
Problem Link: https://takeuforward.org/data-structure/rod-cutting-problem-dp-24/
We are given a rod of size ‘N’. It can be cut into pieces.
Each length of a piece has a particular price given by the price array.
Our task is to find the maximum revenue that can be generated by selling the rod after cutting( if required) into pieces.
TC: >O(2^N) as we are taking one index repeatedly
 */
public class RodCutting {
    static int rodCuttingWithRecursion(int ind, int targetRodLength, int []prices){
        if(ind==0){
            return targetRodLength*prices[0]; //at 0th index rod length is 1; therefore we need to cut it for 1 length, targerRodlength times
        }
        int pick=Integer.MIN_VALUE; //since we are looking for maximum value
        int rodLength= ind+1; //prices={2,5,7,8,10} ; 2 is the price of rodlength 1 i.e at index 0; 5 @ index 2 is price for rodLength 2
        //we can choose ind as many times as we want.
        // Hence we don't move index. similar to infinite supplies
        if(rodLength<=targetRodLength)
            pick=prices[ind]+rodCuttingWithRecursion(ind,targetRodLength-rodLength,prices);

        int notPick=rodCuttingWithRecursion(ind-1, targetRodLength, prices);

        return Math.max(pick,notPick);
    }
    public static void main(String []args){
        int []prices={2,5,7,8,10};
        int rodLength=5;
        int len=prices.length;
        System.out.println("rodCuttingWithRecursion:"+rodCuttingWithRecursion(len-1,rodLength,prices));
    }
}
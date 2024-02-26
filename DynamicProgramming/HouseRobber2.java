package DynamicProgramming;

import java.util.Arrays;

/*

Video Link: https://www.youtube.com/watch?v=3WaxQMELSkw&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=7
Problem Link: https://takeuforward.org/data-structure/dynamic-programming-house-robber-dp-6/
 */
public class HouseRobber2 {
    static int houseRobberWithTabulation(int []arr){
        int n=arr.length;
        int []dp=new int[n];
        Arrays.fill(dp, -1);
        dp[0]=arr[0];
        dp[1]=Math.max(dp[0],arr[1]);
        for(int i=2;i<n;i++){
            int pick=arr[i] + arr[i-2];
            int notPick= arr[i-1];
            dp[i]=Math.max(pick,notPick);
        }
        return dp[n-1];
    }
    public static void main(String []args){
        int origArr[] = {2, 1, 4, 9};
        int arrWithoutFirst[]=new int[origArr.length-1];
        int arrWithoutLast[]=new int[origArr.length-1];
        for(int i=1;i<origArr.length;i++){
            arrWithoutFirst[i-1]=origArr[i];
        }
        for(int i=0;i<origArr.length-1;i++){
            arrWithoutLast[i]=origArr[i];
        }
        int resultWithoutFirstElem = houseRobberWithTabulation(arrWithoutFirst);
        System.out.println("Result Without First Elem: " + resultWithoutFirstElem);
        int resultWithoutLastElem = houseRobberWithTabulation(arrWithoutLast);
        System.out.println("Result Without Last Elem: " + resultWithoutLastElem);
        System.out.println("Result with tabulation: " + Math.max(resultWithoutFirstElem,resultWithoutLastElem));
    }
}

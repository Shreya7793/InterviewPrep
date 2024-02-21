package DynamicProgramming;
/*
*https://www.youtube.com/watch?v=mLfjzJsN8us&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=3
* https://takeuforward.org/data-structure/dynamic-programming-climbing-stairs/
 */
public class ClimbingStairs {
    static int climbingStairs(int n){
        if (n<=1) //Base case: 0 or 1 step can be climbed in 1 way
            return 1;
        int []dp=new int[n+1];
        dp[0]=1; //there is only 1 way to climb 0 steps
        dp[1]=1; //There is only 2 way to climb 1 steps
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String args[]){
        int n=3;
        System.out.println("No. of ways to climb n steps="+climbingStairs(n));
    }
}

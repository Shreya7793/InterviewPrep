package DynamicProgramming;

import java.util.Arrays;

public class FrogJump {
   //Using Recursion - O(2^n)
    static int minEnergyUsingMemoization(int []height, int currentStair, int []dp){
        if(currentStair==0){
            return 0;
        }
        if(dp[currentStair]!=-1)
            return dp[currentStair];
        int energyOneStep = minEnergyUsingMemoization(height, currentStair -1, dp) + Math.abs(height[currentStair]-height[currentStair-1]);
        int energyTwoStep = Integer.MAX_VALUE;
        if(currentStair>1)
            energyTwoStep = minEnergyUsingMemoization(height, currentStair -2, dp) +Math.abs(height[currentStair]-height[currentStair-2]);
        return dp[currentStair]=Math.min(energyOneStep,energyTwoStep);
    }
    //Convert to memoization
    /*
    https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/
    Time Complexity: 0(N)
    Reason: The overlapping subproblems will return the answer in constant time O(1). Therefore the total number of new subproblems we solve is ‘n’. Hence total time complexity is O(N).

Space Complexity: O(N)

Reason: We are using a recursion stack space(O(N)) and an array (again O(N)). Therefore total space complexity will be O(N) + O(N) ≈ O(N)
     */
    static int minEnergyUsingRecursion(int []height, int currentStair, int targetStair){
        if(currentStair==targetStair){
            return 0;
        }

        int energyTwoStep = Integer.MAX_VALUE;
        int energyOneStep = minEnergyUsingRecursion(height, currentStair -1, targetStair) + Math.abs(height[currentStair]-height[currentStair-1]);
        if(currentStair>1)
            energyTwoStep = minEnergyUsingRecursion(height, currentStair -2, targetStair) +Math.abs(height[currentStair]-height[currentStair-2]);

        return Math.min(energyOneStep,energyTwoStep);
    }
    /*
    Video Link: https://www.youtube.com/watch?v=Kmh3rhyEtB8&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=5
    Problem Link: https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/
    * TC: O(N*K) -> no. of subproblems*k
    * SC: O(N)+O(N) -> recursion stack space of N+ array of sizde N
    * */
    static int minEnergyKStepsUsingMemoization(int []height, int []dp, int ind, int k ){
        // Base case: If we are at the beginning (index 0), no cost is needed.
        if(ind==0)
            return 0;
        // If the result for this index has been previously calculated, return it.
        if(dp[ind]!=-1)
            return dp[ind];
        int minEnergy=Integer.MAX_VALUE;
        // Loop to try all possible jumps from '1' to 'k'
        for(int i=1;i<=k;i++)
        {
            if(ind-i>=0){
                int jump= minEnergyKStepsUsingMemoization(height, dp,ind-i, k) + Math.abs(height[ind]-height[ind-i]);
                minEnergy=Math.min(minEnergy, jump);
            }
        }
        return dp[ind]=minEnergy;
    }
    public static void main(String []args){
        int[] height = {10, 15, 20}; // Example heights
        int n = height.length-1;
        int targetStair = n - 1; // Target stair is the last stair
        int []dp=new int[n];
        Arrays.fill(dp, -1);
        //int minEnergyRequired = minEnergy(height, 0, targetStair);
       // System.out.println("Minimum energy required: " + minEnergyRequired);
        int minEnergyRequired = minEnergyUsingMemoization(height, n-1, dp);
        System.out.println("Minimum energy required: " + minEnergyRequired);
        System.out.println("*************************************************");
        System.out.println("FROG JUMP K STEPS");
        height= new int[]{30, 10, 60, 10, 60, 50};
        int k = 2;
        dp=new int[height.length];
        Arrays.fill(dp, -1);
        minEnergyRequired = minEnergyKStepsUsingMemoization(height, dp, n,k);
        System.out.println("Minimum energy required for K Jumps: " + minEnergyRequired);
    }
}

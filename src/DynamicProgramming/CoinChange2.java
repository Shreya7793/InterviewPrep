package DynamicProgramming;
/*
Problem Link: https://takeuforward.org/data-structure/coin-change-2-dp-22/
Video Link: https://www.youtube.com/watch?v=HgyouUi11zk&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=23
 */
public class CoinChange2 {
    static int coinChangeWithRecursion(int ind, int target, int []coins) {
        if(ind==0){
            if(target%coins[ind]==0)
                return 1;
            else return 0;
        }
        int pick = 0;
        if(coins[ind]<=target)
            pick = coinChangeWithRecursion(ind, target-coins[ind],coins);
        int notPick= coinChangeWithRecursion(ind-1, target,coins);
        return pick+notPick;
    }
    public static void main(String []args) {
        int coins[] = {1, 2, 3};
        int target = 4;
        int len = coins.length;
        System.out.println("coinChangeWithRecursion:"+coinChangeWithRecursion(len-1,target,coins));

    }
}

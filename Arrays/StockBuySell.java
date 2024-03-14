package Arrays;
/*
Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Solution Link: https://www.youtube.com/watch?v=34WE6kwq49U
 */
public class StockBuySell {

    //Using Auillary space
    static int maxProfitApproach1(int nums[]){
        int []maxPriceArr=new int[nums.length];
        int maxPrice=Integer.MIN_VALUE;
        int maxProfit=0;
        for(int i=nums.length-1;i>=0;i--){
            maxPrice=Math.max(maxPrice,nums[i]);
            maxPriceArr[i]=maxPrice;
        }
        for(int i=0;i<nums.length;i++){
            maxProfit=Math.max(maxProfit,Math.abs(maxPriceArr[i]-nums[i]));
        }
        return maxProfit;
    }
    static int maxProfitApproach2(int nums[]){
        int []maxPriceArr=new int[nums.length];
        int maxPrice=Integer.MIN_VALUE;
        int maxProfit=0;
        for(int i=nums.length-1;i>=0;i--){
            maxPrice=Math.max(maxPrice,nums[i]);
            maxPriceArr[i]=maxPrice;
        }
        for(int i=0;i<nums.length;i++){
            maxProfit=Math.max(maxProfit,Math.abs(maxPriceArr[i]-nums[i]));
        }
        return maxProfit;
    }
    //Uses DP
    static int maxProfitUsingDP(int nums[]){
        int minBuyPrice=nums[0]; //initial buy price
        int profit=0; //initial profit - buy at the same day , sell at the same day=> no profit
        for(int i=1;i<nums.length;i++){
            int cost=nums[i]-minBuyPrice; //Sell-buy
            profit=Math.max(profit,cost);
            minBuyPrice=Math.min(minBuyPrice,nums[i]); //update the buy price by min
        }
        return profit;
    }
    public static void main(String []args){
        int []nums={3,1,4,8,7,2,5}; //Max Profit is 7
        System.out.println("maxProfitApproach1="+maxProfitApproach1(nums));
        System.out.println("maxProfitUsingDP="+maxProfitUsingDP(nums));
    }
}

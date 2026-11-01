class Solution {
    public int maxProfit(int[] prices) {
    
//    int cp=0;
//     int maxp=0;
//     for(int i=0;i<prices.length;i++){
//        for(int j=i+1; j<prices.length; j++){
//         cp= prices[j]-prices[i];
//         maxp=Math.max(cp,maxp);
//        }
    
//     }
//     return maxp; 
//     }
        int minBuy = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            minBuy = Math.min(minBuy, prices[i]);
            int profit = prices[i] - minBuy;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}

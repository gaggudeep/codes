import java.util.*;

class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int maxProfitSoFar = 0, minSoFar = prices[0];
        for(int i  = 1 ; i < prices.length ; i++)
        {
            maxProfitSoFar= Math.max(maxProfitSoFar, prices[i] - minSoFar);
            minSoFar = Math.minSoFar(minSoFar, prices[i]);
        }
        return maxProfitSoFar;
    }
}
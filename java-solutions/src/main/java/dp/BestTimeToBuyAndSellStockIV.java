package dp;

/**
 * @author FLIGHT
 * <p>
 * 188. Best Time to Buy and Sell Stock IV
 * Solved
 * Hard
 * Topics
 * Companies
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 * <p>
 * Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 * <p>
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class BestTimeToBuyAndSellStockIV {

  private int[] prices;
  private int[][][] cache;

  public int maxProfit(int k, int[] prices) {
    this.cache = new int[prices.length][k + 1][2];
    this.prices = prices;
    return dp(0, k, 0);
  }

  private int dp(int i, int transactionsRemaining, int holding) {
    if (i == prices.length || transactionsRemaining == 0)
      return 0;

    if (cache[i][transactionsRemaining][holding] == 0) {
      cache[i][transactionsRemaining][holding] = compute(i, transactionsRemaining, holding);
    }

    return cache[i][transactionsRemaining][holding];
  }

  private int compute(int i, int transactionsRemaining, int holding) {
    int doingNothing = dp(i + 1, transactionsRemaining, holding);

    if (holding == 1)
      return Math.max(doingNothing, prices[i] + dp(i, transactionsRemaining - 1, 0));
    else
      return Math.max(doingNothing, -prices[i] + dp(i, transactionsRemaining, 1));
  }
}

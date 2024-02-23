package dp;

/**
 * @author FLIGHT
 * <p>
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * Find the maximum profit you can achieve. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * Example 2:
 * <p>
 * Input: prices = [1]
 * Output: 0
 */
public class BestTimeToBuyAndSellStockWithCooldown {

  private int[] prices;
  private int[][] memo;

  public int maxProfit(int[] prices) {
    this.prices = prices;
    this.memo = new int[prices.length][2];
    return dp(0, 0);
  }

  private int dp(int i, int holding) {
    if (i >= prices.length)
      return 0;

    if (memo[i][holding] != 0)
      return memo[i][holding];

    int doingNothing = dp(i + 1, holding);
    if (holding == 1)
      return memo[i][holding] = Math.max(doingNothing, prices[i] + dp(i + 2, 0));
    else
      return memo[i][holding] = Math.max(doingNothing, -prices[i] + dp(i + 1, 1));
  }
}

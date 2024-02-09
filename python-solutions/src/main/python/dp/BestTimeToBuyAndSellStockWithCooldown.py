from functools import cache
from typing import List


# 309. Best Time to Buy and Sell Stock with Cooldown

# You are given an array prices where prices[i] is the price of a given stock on the ith day.
#
# Find the maximum profit you can achieve.
# You may complete as many transactions as you like
# (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
#
# After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
# Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
#
#
#
# Example 1:
#
# Input: prices = [1,2,3,0,2]
# Output: 3
# Explanation: transactions = [buy, sell, cooldown, buy, sell]
# Example 2:
#
# Input: prices = [1]
# Output: 0
class Solution:
  def maxProfit(self, prices: List[int]) -> int:

    @cache
    def dp(i, holding):
      if i >= len(prices):
        return 0

      doing_nothing = dp(i + 1, holding)

      if holding == 1:
        return max(doing_nothing, prices[i] + dp(i + 2, 0))
      else:
        return max(doing_nothing, -prices[i] + dp(i + 1, 1))

    return dp(0, 0)

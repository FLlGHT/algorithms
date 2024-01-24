from functools import cache
from typing import List


# 64. Minimum Path Sum
# Given a m x n grid filled with non-negative numbers,
# find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
#
# Note: You can only move either down or right at any point in time.
#
#
#
# Example 1:
#
#
# Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
# Output: 7
# Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
# Example 2:
#
# Input: grid = [[1,2,3],[4,5,6]]
# Output: 12
class Solution:

    # top-down solution

  def minPathSum(self, grid: List[List[int]]) -> int:
    rows, columns = len(grid), len(grid[0])

    @cache
    def dp(row, column):
      if row < 0 or column < 0:
        return float('inf')

      if row == 0 and column == 0:
        return grid[row][column]

      return grid[row][column] + min(dp(row - 1, column), dp(row, column - 1))

    return dp(rows - 1, columns - 1)

    # bottom-up solution

  def minPathSum2(self, grid: List[List[int]]) -> int:
    rows, columns = len(grid), len(grid[0])
    dp = [[0] * columns] * rows
    dp[0][0] = grid[0][0]

    for row in range(rows):
      for column in range(columns):
        if row > 0 and column > 0:
          dp[row][column] = grid[row][column] + min(dp[row - 1][column], dp[row][column - 1])
        elif row > 0:
          dp[row][column] = grid[row][column] + dp[row - 1][column]
        elif column > 0:
          dp[row][column] = grid[row][column] + dp[row][column - 1]

    return dp[rows - 1][columns - 1]

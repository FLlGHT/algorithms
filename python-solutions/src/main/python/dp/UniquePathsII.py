from functools import cache
from typing import List


# 63. Unique Paths II
# You are given an m x n integer array grid.
# There is a robot initially located in the top-left corner (i.e., grid[0][0]).
# The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
# The robot can only move either down or right at any point in time.
#
# An obstacle and space are marked as 1 or 0 respectively in grid.
# A path that the robot takes cannot include any square that is an obstacle.
#
# Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
#
# The testcases are generated so that the answer will be less than or equal to 2 * 109.
#
#
#
# Example 1:
#
#
# Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
# Output: 2
# Explanation: There is one obstacle in the middle of the 3x3 grid above.
# There are two ways to reach the bottom-right corner:
# 1. Right -> Right -> Down -> Down
# 2. Down -> Down -> Right -> Right
# Example 2:
#
#
# Input: obstacleGrid = [[0,1],[0,0]]
# Output: 1
class Solution:
  def uniquePathsWithObstacles(self, obstacle_grid: List[List[int]]) -> int:
    rows, columns = len(obstacle_grid), len(obstacle_grid[0])

    @cache
    def dp(row, column):
      if row < 0 or column < 0 or obstacle_grid[row][column] == 1:
        return 0

      if row == 0 and column == 0:
        return 1

      return dp(row - 1, column) + dp(row, column - 1)

    return dp(rows - 1, columns - 1)


if __name__ == '__main__':
  grid: List[List[int]] = [[0] * 4 for _ in range(2)]
  solution = Solution()
  solution.uniquePathsWithObstacles(obstacle_grid=grid)

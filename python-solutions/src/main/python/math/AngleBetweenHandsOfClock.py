# 1344. Angle Between Hands of a Clock
# Given two numbers, hour and minutes, return the smaller angle (in degrees)
# formed between the hour and the minute hand.
#
# Answers within 10-5 of the actual value will be accepted as correct.
#
#
#
# Example 1:
#
#
# Input: hour = 12, minutes = 30
# Output: 165
# Example 2:
#
#
# Input: hour = 3, minutes = 30
# Output: 75
# Example 3:
#
#
# Input: hour = 3, minutes = 15
# Output: 7.5
class Solution:
  def angleClock(self, hour: int, minutes: int) -> float:
    hour_position = 5 * (hour % 12) + ((minutes * 1.0 / 60) * 5)
    minute_position = minutes * 1.0

    bigger = max(minute_position, hour_position)
    smaller = min(minute_position, hour_position)

    difference = min(bigger - smaller, 60 - bigger + smaller)

    return (difference / 60) * 360

from typing import List

# 281. Zigzag Iterator

# Given two vectors of integers v1 and v2, implement an iterator to return their elements alternately.
#
# Implement the ZigzagIterator class:
#
# ZigzagIterator(List<int> v1, List<int> v2) initializes the object with the two vectors v1 and v2.
# boolean hasNext() returns true if the iterator still has elements, and false otherwise.
# int next() returns the current element of the iterator and moves the iterator to the next element.
#
#
# Example 1:
#
# Input: v1 = [1,2], v2 = [3,4,5,6]
# Output: [1,3,2,4,5,6]
# Explanation: By calling next repeatedly until hasNext returns false,
# the order of elements returned by next should be: [1,3,2,4,5,6].
# Example 2:
#
# Input: v1 = [1], v2 = []
# Output: [1]
# Example 3:
#
# Input: v1 = [], v2 = [1]
# Output: [1]
class ZigzagIterator:

  def __init__(self, v1: List[int], v2: List[int]):
    self.index_1, self.index_2 = 0, 0
    self.vector_1, self.vector_2 = v1, v2

  def next(self) -> int:
    if self.index_1 < len(self.vector_1) and (self.index_1 == self.index_2 or self.index_2 >= len(self.vector_2)):
      result = self.vector_1[self.index_1]
      self.index_1 += 1

      return result

    result = self.vector_2[self.index_2]
    self.index_2 += 1
    return result

  def hasNext(self) -> bool:
    return self.index_1 < len(self.vector_1) or self.index_2 < len(self.vector_2)

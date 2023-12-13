# 242. Valid Anagram

# Given two strings s and t, return true if t is an anagram of s, and false otherwise.
#
# An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
# typically using all the original letters exactly once.
#
# Example 1:
#
# Input: s = "anagram", t = "nagaram"
# Output: true
# Example 2:
#
# Input: s = "rat", t = "car"
# Output: false

class Solution:
  def isAnagram(self, s: str, t: str) -> bool:
    alphabet = [0] * 26

    for letter in s:
      alphabet[ord(letter) - ord('a')] += 1

    for letter in t:
      alphabet[ord(letter) - ord('a')] -= 1

    for i in range(len(alphabet)):
      if alphabet[i] != 0:
        return False

    return True


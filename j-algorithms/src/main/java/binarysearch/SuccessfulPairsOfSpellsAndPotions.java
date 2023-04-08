package binarysearch;

import java.util.Arrays;

/**
 * 2300. Successful Pairs of Spells and Potions
 * <p>
 * You are given two positive integer arrays spells and potions, of length n and m respectively,
 * where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.
 * <p>
 * You are also given an integer success.
 * A spell and potion pair is considered successful if the product of their strengths is at least success.
 * <p>
 * Return an integer array pairs of length n
 * where pairs[i] is the number of potions that will form a successful pair with the ith spell.
 */
public class SuccessfulPairsOfSpellsAndPotions {

  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    Arrays.sort(potions);
    int[] result = new int[spells.length];

    for (int i = 0; i < spells.length; ++i) {
      long successFactor = (success + spells[i] - 1) / spells[i];
      int startPosition = binarySearch(potions, successFactor);
      result[i] = potions.length - startPosition;
    }
    return result;
  }

  private int binarySearch(int[] potions, long successFactor) {
    int left = 0, right = potions.length;

    while (left < right) {
      int middle = left + (right - left) / 2;

      if (potions[middle] < successFactor)
        left = middle + 1;
      else
        right = middle;
    }
    return right;
  }
}

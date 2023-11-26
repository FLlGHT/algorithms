package math;

import java.util.HashMap;
import java.util.Map;

/**
 * 914. X of a Kind in a Deck of Cards
 * <p>
 * You are given an integer array deck where deck[i] represents the number written on the ith card.
 * <p>
 * Partition the cards into one or more groups such that:
 * <p>
 * Each group has exactly x cards where x > 1, and
 * All the cards in one group have the same integer written on them.
 * Return true if such partition is possible, or false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: deck = [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
 * Example 2:
 * <p>
 * Input: deck = [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 */
public class XofKindInDeckOfCards {

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> groups = new HashMap<>();
        int gcd = 0;

        for (int card : deck)
            groups.put(card, groups.getOrDefault(card, 0) + 1);

        for (int count : groups.values())
            gcd = greatestCommonDivisor(gcd, count);

        return gcd > 1;
    }

    private int greatestCommonDivisor(int first, int second) {
        return second == 0 ? first : greatestCommonDivisor(second, first % second);
    }
}

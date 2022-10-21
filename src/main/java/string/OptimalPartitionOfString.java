package string;


import java.util.HashSet;
import java.util.Set;

/**
 * 2405. Optimal Partition of String
 * <p>
 * Given a string s, partition the string into one or more substrings such that the characters in each substring are unique.
 * That is, no letter appears in a single substring more than once.
 * <p>
 * Return the minimum number of substrings in such a partition.
 * <p>
 * Note that each character should belong to exactly one substring in a partition.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abacaba"
 * Output: 4
 * Explanation:
 * Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
 * It can be shown that 4 is the minimum number of substrings needed.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "ssssss"
 * Output: 6
 * Explanation:
 * The only valid partition is ("s","s","s","s","s","s").
 */
public class OptimalPartitionOfString {

    public int partitionString(String s) {
        int partCount = 1;

        Set<Character> currentWord = new HashSet<>();
        for (char letter : s.toCharArray()) {
            if (currentWord.contains(letter)) {
                currentWord.clear();
                partCount++;
            }
            currentWord.add(letter);
        }
        return partCount;
    }
}

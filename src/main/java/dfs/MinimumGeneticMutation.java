package dfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 433. Minimum Genetic Mutation
 * <p>
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
 * <p>
 * Suppose we need to investigate a mutation from a gene string start to a gene string end
 * where one mutation is defined as one single character changed in the gene string.
 * <p>
 * For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
 * There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.
 * <p>
 * Given the two gene strings start and end and the gene bank bank, return the minimum number of mutations needed to mutate from start to end.
 * If there is no such a mutation, return -1.
 * <p>
 * Note that the starting point is assumed to be valid, so it might not be included in the bank.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
 * Output: 1
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * Output: 2
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
 * Output: 3
 */
public class MinimumGeneticMutation {
    private int min = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        Set<String> valid = Arrays.stream(bank).collect(Collectors.toSet());
        dfs(start, end, 0, valid, new HashSet<>());
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void dfs(String current, String end, int changes, Set<String> valid, Set<String> visited) {
        if (changes >= min || visited.contains(current))
            return;

        visited.add(current);
        if (current.equals(end))
            min = changes;

        for (String validString : valid) {
            if (isOneDifference(current, validString))
                dfs(validString, end, changes + 1, valid, visited);
        }
        visited.remove(current);
    }

    private boolean isOneDifference(String first, String second) {
        int differences = 0;
        for (int i = 0; differences <= 1 && i < first.length(); ++i) {
            if (first.charAt(i) != second.charAt(i))
                differences++;
        }

        return differences == 1;
    }
}

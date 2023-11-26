package unionfind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 737. Sentence Similarity II
 * <p>
 * We can represent a sentence as an array of words, for example,
 * the sentence "I am happy with leetcode" can be represented as arr = ["I","am",happy","with","leetcode"].
 * <p>
 * Given two sentences sentence1 and sentence2 each represented as a string array and given an array of string pairs similarPairs where
 * similarPairs[i] = [xi, yi] indicates that the two words xi and yi are similar.
 * <p>
 * Return true if sentence1 and sentence2 are similar, or false if they are not similar.
 * <p>
 * Two sentences are similar if:
 * <p>
 * They have the same length (i.e., the same number of words)
 * sentence1[i] and sentence2[i] are similar.
 * Notice that a word is always similar to itself, also notice that the similarity relation is transitive.
 * For example, if the words a and b are similar, and the words b and c are similar, then a and c are similar.
 * <p>
 * Example 1:
 * <p>
 * Input: sentence1 = ["great","acting","skills"], sentence2 = ["fine","drama","talent"],
 * similarPairs = [["great","good"],["fine","good"],["drama","acting"],["skills","talent"]]
 * Output: true
 * Explanation: The two sentences have the same length and each word i of sentence1 is also similar to the corresponding word in sentence2.
 * Example 2:
 * <p>
 * Input: sentence1 = ["I","love","leetcode"], sentence2 = ["I","love","onepiece"],
 * similarPairs = [["manga","onepiece"],["platform","anime"],["leetcode","platform"],["anime","manga"]]
 * Output: true
 * Explanation: "leetcode" --> "platform" --> "anime" --> "manga" --> "onepiece".
 * Since "leetcode is similar to "onepiece" and the first two words are the same, the two sentences are similar.
 * Example 3:
 * <p>
 * Input: sentence1 = ["I","love","leetcode"], sentence2 = ["I","love","onepiece"],
 * similarPairs = [["manga","hunterXhunter"],["platform","anime"],["leetcode","platform"],["anime","manga"]]
 * Output: false
 * Explanation: "leetcode" is not similar to "onepiece".
 */
public class SentenceSimilarityII {

    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length)
            return false;

        int[] groups = createGroups(similarPairs.size());
        Map<String, Integer> wordToIndex = new HashMap<>();

        int index = 0;
        for (List<String> similarPair : similarPairs) {
            String word1 = similarPair.get(0), word2 = similarPair.get(1);
            wordToIndex.putIfAbsent(word1, index++);
            wordToIndex.putIfAbsent(word2, index++);

            merge(groups, wordToIndex.get(word1), wordToIndex.get(word2));
        }

        for (int i = 0; i < sentence1.length; ++i) {
            String word1 = sentence1[i], word2 = sentence2[i];

            if (!word1.equals(word2) && !isSimilar(groups, wordToIndex, word1, word2))
                return false;
        }

        return true;
    }

    private boolean isSimilar(int[] groups, Map<String, Integer> wordToIndex, String word1, String word2) {
        if (!wordToIndex.containsKey(word1) || !wordToIndex.containsKey(word2))
            return false;

        return find(groups, wordToIndex.get(word1)) == find(groups, wordToIndex.get(word2));
    }

    private int[] createGroups(int pairCount) {
        int[] groups = new int[pairCount * 2];
        for (int i = 0; i < groups.length; i++)
            groups[i] = i;

        return groups;
    }
    private void merge(int[] groups, int firstWordIndex, int secondWordIndex) {
        int firstGroup = find(groups, firstWordIndex);
        int secondGroup = find(groups, secondWordIndex);

        if (firstGroup != secondGroup)
            groups[firstGroup] = secondGroup;
    }


    private int find(int[] groups, int wordIndex) {
        if (groups[wordIndex] == wordIndex)
            return wordIndex;

        return find(groups, groups[wordIndex]);
    }

}

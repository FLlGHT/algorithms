package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 1832. Check if the Sentence Is Pangram
 * <p>
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 * <p>
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 * Output: true
 * Explanation: sentence contains at least one of every letter of the English alphabet.
 * Example 2:
 * <p>
 * Input: sentence = "leetcode"
 * Output: false
 */
public class CheckIfTheSentenceIsPangram {

    public boolean checkIfPangram(String sentence) {
        Set<Character> letters = new HashSet<>();
        for (char letter : sentence.toCharArray())
            letters.add(letter);

        return letters.size() == 26;
    }
}

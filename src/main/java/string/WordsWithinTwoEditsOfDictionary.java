package string;


import java.util.ArrayList;
import java.util.List;

/**
 * 2452. Words Within Two Edits of Dictionary
 * <p>
 * You are given two string arrays, queries and dictionary. All words in each array comprise of lowercase English letters and have the same length.
 * <p>
 * In one edit you can take a word from queries, and change any letter in it to any other letter.
 * Find all words from queries that, after a maximum of two edits, equal some word from dictionary.
 * <p>
 * Return a list of all words from queries, that match with some word from dictionary after a maximum of two edits.
 * Return the words in the same order they appear in queries.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: queries = ["word","note","ants","wood"], dictionary = ["wood","joke","moat"]
 * Output: ["word","note","wood"]
 * Explanation:
 * - Changing the 'r' in "word" to 'o' allows it to equal the dictionary word "wood".
 * - Changing the 'n' to 'j' and the 't' to 'k' in "note" changes it to "joke".
 * - It would take more than 2 edits for "ants" to equal a dictionary word.
 * - "wood" can remain unchanged (0 edits) and match the corresponding dictionary word.
 * Thus, we return ["word","note","wood"].
 * Example 2:
 * <p>
 * Input: queries = ["yes"], dictionary = ["not"]
 * Output: []
 * Explanation:
 * Applying any two edits to "yes" cannot make it equal to "not". Thus, we return an empty array.
 */
public class WordsWithinTwoEditsOfDictionary {

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> twoEditWords = new ArrayList<>();

        for (String fromQuery : queries) {
            for (String fromDictionary : dictionary) {
                if (maximumTwoEdits(fromQuery, fromDictionary)) {
                    twoEditWords.add(fromQuery);
                    break;
                }
            }
        }
        return twoEditWords;
    }

    private boolean maximumTwoEdits(String from, String to) {
        int edits = 0;

        for (int i = 0; i < from.length(); ++i) {
            if (from.charAt(i) != to.charAt(i))
                edits++;

            if (edits > 2)
                return false;
        }

        return true;
    }
}

package string;


/**
 * 2047. Number of Valid Words in a Sentence
 * <p>
 * A sentence consists of lowercase letters ('a' to 'z'), digits ('0' to '9'), hyphens ('-'),
 * punctuation marks ('!', '.', and ','), and spaces (' ') only. Each sentence can be broken down into one or more tokens separated by one or more spaces ' '.
 * <p>
 * A token is a valid word if all three of the following are true:
 * <p>
 * It only contains lowercase letters, hyphens, and/or punctuation (no digits).
 * There is at most one hyphen '-'. If present, it must be surrounded by lowercase characters ("a-b" is valid, but "-ab" and "ab-" are not valid).
 * There is at most one punctuation mark. If present, it must be at the end of the token ("ab,", "cd!", and "." are valid, but "a!b" and "c.," are not valid).
 * Examples of valid words include "a-b.", "afad", "ba-c", "a!", and "!".
 * <p>
 * Given a string sentence, return the number of valid words in sentence.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: sentence = "cat and  dog"
 * Output: 3
 * Explanation: The valid words in the sentence are "cat", "and", and "dog".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: sentence = "!this  1-s b8d!"
 * Output: 0
 * Explanation: There are no valid words in the sentence.
 * "!this" is invalid because it starts with a punctuation mark.
 * "1-s" and "b8d" are invalid because they contain digits.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: sentence = "alice and  bob are playing stone-game10"
 * Output: 5
 * Explanation: The valid words in the sentence are "alice", "and", "bob", "are", and "playing".
 * "stone-game10" is invalid because it contains digits.
 */
public class NumberOfValidWordInSentence {

    public int countValidWords(String sentence) {
        String[] tokens = sentence.split(" ");
        int countValid = 0;
        for (String token : tokens) {
            if (!token.isEmpty() && isValid(token))
                countValid++;
        }

        return countValid;
    }

    private boolean isValid(String token) {
        for (int position = 0, hyphenCount = 0; position < token.length(); ++position) {
            char currentChar = token.charAt(position);

            if (Character.isDigit(currentChar))
                return false;

            else if (currentChar == '-') {
                hyphenCount++;
                if (position == 0 || position == token.length() - 1 || hyphenCount > 1
                        || !Character.isLetter(token.charAt(position - 1)) || !Character.isLetter(token.charAt(position + 1)))
                    return false;
            }

            else if ((currentChar == '!' || currentChar == '.' || currentChar == ',') && position < token.length() - 1)
                return false;
        }

        return true;
    }
}

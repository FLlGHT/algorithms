package string;


/**
 * 1758. Minimum Changes To Make Alternating Binary String
 * <p>
 * You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.
 * <p>
 * The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.
 * <p>
 * Return the minimum number of operations needed to make s alternating.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "0100"
 * Output: 1
 * Explanation: If you change the last character to '1', s will be "0101", which is alternating.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: s = "10"
 * Output: 0
 * Explanation: s is already alternating.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: s = "1111"
 * Output: 2
 * Explanation: You need two operations to reach "0101" or "1010".
 */
public class MinimumChangesToMakeAlternatingBinaryString {

    public int minOperations(String s) {
        String fromOne = generateResult(s);
        int fromZeroChanges = 0, fromOneChanges = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != fromOne.charAt(i))
                fromOneChanges++;
            else
                fromZeroChanges++;
        }

        return Math.min(fromOneChanges, fromZeroChanges);
    }

    private String generateResult(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0, letter = 1; i < s.length(); ++i) {
            result.append(letter);
            letter = 1 - letter;
        }

        return result.toString();
    }
}

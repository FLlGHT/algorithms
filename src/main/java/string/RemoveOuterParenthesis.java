package string;

/**
 * 1021. Remove Outermost Parentheses
 * <p>
 * A valid parentheses string is either empty "", "(" + A + ")", or A + B,
 * where A and B are valid parentheses strings, and + represents string concatenation.
 * <p>
 * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 * A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B,
 * with A and B nonempty valid parentheses strings.
 * <p>
 * Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
 * <p>
 * Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: s = "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation:
 * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
 * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: s = "()()"
 * Output: ""
 * Explanation:
 * The input string is "()()", with primitive decomposition "()" + "()".
 * After removing outer parentheses of each part, this is "" + "" = "".
 */
public class RemoveOuterParenthesis {

    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();

        int open = 0, closed = 0, last = -1;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(')
                open++;
            else
                closed++;

            if (open == closed) {
                result.append(s, last + 2, i);
                last = i;
            }
        }

        return result.toString();
    }
}

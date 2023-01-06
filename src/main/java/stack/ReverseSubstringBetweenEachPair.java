package stack;

import java.util.Stack;

/**
 * 1190. Reverse Substrings Between Each Pair of Parentheses
 * <p>
 * You are given a string s that consists of lower case English letters and brackets.
 * <p>
 * Reverse the strings in each pair of matching parentheses, starting from the innermost one.
 * <p>
 * Your result should not contain any brackets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "(abcd)"
 * Output: "dcba"
 * Example 2:
 * <p>
 * Input: s = "(u(love)i)"
 * Output: "iloveu"
 * Explanation: The substring "love" is reversed first, then the whole string is reversed.
 * Example 3:
 * <p>
 * Input: s = "(ed(et(oc))el)"
 * Output: "leetcode"
 * Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
 */
public class ReverseSubstringBetweenEachPair {

  public String reverseParentheses(String s) {
    Stack<Character> stack = new Stack<>();

    for (char symbol : s.toCharArray()) {
      if (symbol == ')')
        reverseLast(stack);
      else
        stack.push(symbol);
    }

    return stackToString(stack);
  }

  private void reverseLast(Stack<Character> stack) {
    StringBuilder reversed = new StringBuilder();
    while (!stack.isEmpty() && stack.peek() != '(')
      reversed.append(stack.pop());

    stack.pop();

    for (char symbol : reversed.toString().toCharArray())
      stack.push(symbol);
  }

  private String stackToString(Stack<Character> stack) {
    StringBuilder result = new StringBuilder();

    while (!stack.isEmpty())
      result.insert(0, stack.pop());

    return result.toString();
  }


}

//
// Created by fedorenko on 17.10.2022.
//

#ifndef C_ALGORITMS_REMOVEOUTERMOSTPARENTHESES_H
#define C_ALGORITMS_REMOVEOUTERMOSTPARENTHESES_H

#include <string>

using namespace std;

/**
 * 1021. Remove Outermost Parentheses
 *
 * A valid parentheses string is either empty "", "(" + A + ")", or A + B,
 * where A and B are valid parentheses strings, and + represents string concatenation.

For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B,
 with A and B nonempty valid parentheses strings.

Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.

Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.

Example 1:

Input: s = "(()())(())"
Output: "()()()"
Explanation:
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".


Example 2:

Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation:
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".


Example 3:

Input: s = "()()"
Output: ""
Explanation:
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
 */
class RemoveOutermostParentheses {

public:
    string removeOuterParentheses(string s) {
        string result;

        int open = 0, closed = 0, last = -1;
        for (int i = 0; i < s.length(); ++i) {
            if (s[i] == '(')
                open++;
            else
                closed++;

            if (open == closed) {
                result += s.substr(last + 2, i - last - 2);
                last = i;
            }
        }

        return result;
    }
};


#endif //C_ALGORITMS_REMOVEOUTERMOSTPARENTHESES_H

package string;


import java.util.ArrayList;
import java.util.List;

/**
 * 38. Count and Say
 * <p>
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1),
 * which is then converted into a different digit string.
 * To determine how you "say" a digit string,
 * split it into the minimal number of substrings such that each substring contains exactly one unique digit.
 * Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
 * <p>
 * For example, the saying and conversion for digit string "3322251":
 * <p>
 * <p>
 * Given a positive integer n, return the nth term of the count-and-say sequence.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: "1"
 * Explanation: This is the base case.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 */
public class CountAndSay {

    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; ++i) {
            List<int[]> pairs = toPairs(result);
            result = toInteger(pairs);
        }

        return result;
    }


    private List<int[]> toPairs(String number) {
        List<int[]> pairs = new ArrayList<>();
        int[] lastPair = new int[] {number.charAt(0) - '0', 1};
        for (int i = 1; i < number.length(); ++i) {
            int current = number.charAt(i) - '0';

            if (current != lastPair[0]) {
                pairs.add(new int[] {lastPair[0], lastPair[1]});

                lastPair[0] = current;
                lastPair[1] = 1;
            }

            else
                lastPair[1]++;
        }

        pairs.add(lastPair);
        return pairs;
    }

    private String toInteger(List<int[]> pairs) {
        StringBuilder number = new StringBuilder();
        for (int[] pair : pairs)
            number.append(pair[1]).append(pair[0]);

        return number.toString();
    }
}

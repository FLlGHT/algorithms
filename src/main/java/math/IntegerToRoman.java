package math;


import java.util.Map;

/**
 * 12. Integer to Roman
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II.
 * The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 3
 * Output: "III"
 * Explanation: 3 is represented as 3 ones.
 * Example 2:
 * <p>
 * Input: num = 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 3:
 * <p>
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class IntegerToRoman {


    public String intToRoman(int number) {
        Map<Integer, Character> map = Map.of(1, 'I', 5, 'V', 10, 'X', 50, 'L', 100, 'C', 500, 'D', 1000, 'M');
        StringBuilder roman = new StringBuilder();

        int multiplier = 1;
        while (number > 0) {
            int digit = number % 10;

            if (digit == 4 || digit == 9)
                roman.insert(0, "" + map.get(multiplier) + map.get((digit + 1) * multiplier));
            else
                roman.insert(0, (digit >= 5 ? map.get(5 * multiplier) : "") + (map.get(multiplier)
                                                                                  .toString()
                                                                                  .repeat(digit >= 5
                                                                                          ? digit - 5
                                                                                          : digit)));

            number = number / 10;
            multiplier *= 10;
        }

        return roman.toString();
    }
}

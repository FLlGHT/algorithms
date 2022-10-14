package array;


/**
 * 1652. Defuse the Bomb
 * <p>
 * You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code of length of n and a key k.
 * <p>
 * To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.
 * <p>
 * If k > 0, replace the ith number with the sum of the next k numbers.
 * If k < 0, replace the ith number with the sum of the previous k numbers.
 * If k == 0, replace the ith number with 0.
 * As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].
 * <p>
 * Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: code = [5,7,1,4], k = 3
 * Output: [12,10,16,13]
 * Explanation: Each number is replaced by the sum of the next 3 numbers.
 * The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.
 * Example 2:
 * <p>
 * Input: code = [1,2,3,4], k = 0
 * Output: [0,0,0,0]
 * Explanation: When k is zero, the numbers are replaced by 0.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: code = [2,4,9,3], k = -2
 * Output: [12,5,6,13]
 * Explanation: The decrypted code is [3+9, 2+3, 4+2, 9+4]. Notice that the numbers wrap around again.
 * If k is negative, the sum is of the previous numbers.
 */
public class DefuseTheBomb {

    public int[] decrypt(int[] code, int k) {
        int[] decrypted = new int[code.length];
        if (k == 0)
            return decrypted;

        for (int index = 0; index < code.length; ++index)
            decrypted[index] = sum(code, index, k);

        return decrypted;
    }

    private int sum(int[] code, int index, int k) {
        int sum = 0;
        for (int offset = 1; offset <= Math.abs(k); ++offset) {
            int offsetDirection = k < 0 ? -offset : offset;
            int prevIndex = (code.length + index + offsetDirection) % code.length;
            sum += code[prevIndex];
        }

        return sum;
    }
}

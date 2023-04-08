package array;


/**
 * 1646. Get Maximum in Generated Array
 * <p>
 * You are given an integer n. A 0-indexed integer array nums of length n + 1 is generated in the following way:
 * <p>
 * nums[0] = 0
 * nums[1] = 1
 * nums[2 * i] = nums[i] when 2 <= 2 * i <= n
 * nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n
 * Return the maximum integer in the array nums
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 7
 * Output: 3
 * Explanation: According to the given rules:
 * nums[0] = 0
 * nums[1] = 1
 * nums[(1 * 2) = 2] = nums[1] = 1
 * nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
 * nums[(2 * 2) = 4] = nums[2] = 1
 * nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
 * nums[(3 * 2) = 6] = nums[3] = 2
 * nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
 * Hence, nums = [0,1,1,2,1,3,2,3], and the maximum is max(0,1,1,2,1,3,2,3) = 3.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: 1
 * Explanation: According to the given rules, nums = [0,1,1]. The maximum is max(0,1,1) = 1.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: n = 3
 * Output: 2
 * Explanation: According to the given rules, nums = [0,1,1,2]. The maximum is max(0,1,1,2) = 2.
 */
public class GetMaximumInGeneratedArray {

    public int getMaximumGenerated(int n) {
        if (n <= 1) return n;

        int[] generated = new int[n + 1];
        generated[0] = 0; generated[1] = 1;
        int max = 1;

        for (int i = 0; 2 * i + 1 <= n; ++i) {
            generated[2 * i] = generated[i];
            generated[2 * i + 1] = generated[i] + generated[i + 1];
            max = Math.max(max, Math.max(generated[2 * i], generated[2 * i + 1]));
        }

        return max;
    }
}

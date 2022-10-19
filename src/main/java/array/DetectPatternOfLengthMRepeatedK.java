package array;


/**
 * 1566. Detect Pattern of Length M Repeated K or More Times
 * <p>
 * Given an array of positive integers arr, find a pattern of length m that is repeated k or more times.
 * <p>
 * A pattern is a subarray (consecutive sub-sequence) that consists of one or more values, repeated multiple times consecutively without overlapping.
 * A pattern is defined by its length and the number of repetitions.
 * <p>
 * Return true if there exists a pattern of length m that is repeated k or more times, otherwise return false.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,2,4,4,4,4], m = 1, k = 3
 * Output: true
 * Explanation: The pattern (4) of length 1 is repeated 4 consecutive times. Notice that pattern can be repeated k or more times but not less.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: arr = [1,2,1,2,1,1,1,3], m = 2, k = 2
 * Output: true
 * Explanation: The pattern (1,2) of length 2 is repeated 2 consecutive times. Another valid pattern (2,1) is also repeated 2 times.
 * <p>
 * Example 3:
 * <p>
 * Input: arr = [1,2,1,2,1,3], m = 2, k = 3
 * Output: false
 * Explanation: The pattern (1,2) is of length 2 but is repeated only 2 times. There is no pattern of length 2 that is repeated 3 or more times.
 */
public class DetectPatternOfLengthMRepeatedK {

    public boolean containsPattern(int[] arr, int length, int repeatCount) {
        for (int start = 0; start <= arr.length - length * repeatCount; ++start) {
            boolean isPatternCorrect = true;
            for (int wordNumber = 1; wordNumber < repeatCount && isPatternCorrect; ++wordNumber) {
                for (int indexInPattern = 0; indexInPattern < length; ++indexInPattern) {
                    if (arr[start + indexInPattern] != arr[start + (wordNumber * length) + indexInPattern]) {
                        isPatternCorrect = false;
                        break;
                    }
                }
                if (isPatternCorrect && wordNumber == repeatCount - 1)
                    return true;
            }
        }
        return false;
    }
}

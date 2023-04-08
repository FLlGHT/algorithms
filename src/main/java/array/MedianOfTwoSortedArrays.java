package array;

/**
 * 4. Median of Two Sorted Arrays
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class MedianOfTwoSortedArrays {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length + nums2.length];

    for (int i = 0, firstIndex = 0, secondIndex = 0; i <= result.length / 2; ++i) {
      int first = firstIndex < nums1.length ? nums1[firstIndex] : Integer.MAX_VALUE;
      int second = secondIndex < nums2.length ? nums2[secondIndex] : Integer.MAX_VALUE;

      if (first > second) {
        secondIndex++;
        result[i] = second;
      } else {
        firstIndex++;
        result[i] = first;
      }
    }

    return processResult(result);
  }

  private double processResult(int[] result) {
    boolean even = result.length % 2 == 0;

    if (even)
      return (result[result.length / 2] + result[result.length / 2 - 1]) / 2.0;
    else
      return result[result.length / 2] * 1.0;
  }
}

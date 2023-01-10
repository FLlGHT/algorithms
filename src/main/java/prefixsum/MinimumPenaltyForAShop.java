package prefixsum;

import java.util.ArrayList;
import java.util.List;

/**
 * 2483. Minimum Penalty for a Shop
 * <p>
 * You are given the customer visit log of a shop represented by a 0-indexed string customers consisting only of characters 'N' and 'Y':
 * <p>
 * if the ith character is 'Y', it means that customers come at the ith hour
 * whereas 'N' indicates that no customers come at the ith hour.
 * If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:
 * <p>
 * For every hour when the shop is open and no customers come, the penalty increases by 1.
 * For every hour when the shop is closed and customers come, the penalty increases by 1.
 * Return the earliest hour at which the shop must be closed to incur a minimum penalty.
 * <p>
 * Note that if a shop closes at the jth hour, it means the shop is closed at the hour j.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: customers = "YYNY"
 * Output: 2
 * Explanation:
 * - Closing the shop at the 0th hour incurs in 1+1+0+1 = 3 penalty.
 * - Closing the shop at the 1st hour incurs in 0+1+0+1 = 2 penalty.
 * - Closing the shop at the 2nd hour incurs in 0+0+0+1 = 1 penalty.
 * - Closing the shop at the 3rd hour incurs in 0+0+1+1 = 2 penalty.
 * - Closing the shop at the 4th hour incurs in 0+0+1+0 = 1 penalty.
 * Closing the shop at 2nd or 4th hour gives a minimum penalty. Since 2 is earlier, the optimal closing time is 2.
 * Example 2:
 * <p>
 * Input: customers = "NNNNN"
 * Output: 0
 * Explanation: It is best to close the shop at the 0th hour as no customers arrive.
 * Example 3:
 * <p>
 * Input: customers = "YYYY"
 * Output: 4
 * Explanation: It is best to close the shop at the 4th hour as customers arrive at each hour.
 */
public class MinimumPenaltyForAShop {

  public int bestClosingTime(String customers) {
    List<Count> count = count(customers);
    return earliest(customers, count);
  }

  private int earliest(String customers, List<Count> count) {
    Count last = count.get(customers.length() - 1);
    int minPenalty = customers.length(), earliest = customers.length();
    for (int i = 0; i <= customers.length(); ++i) {
      boolean isFirst = i == 0;
      Count previous = isFirst ? null : count.get(i - 1);
      int penalty = isFirst ? last.y : (previous.n + (last.y - previous.y));

      if (penalty < minPenalty) {
        minPenalty = penalty;
        earliest = i;
      }
    }

    return earliest;
  }

  private List<Count> count(String customers) {
    List<Count> count = new ArrayList<>();
    for (int i = 0, yCount = 0, nCount = 0; i < customers.length(); ++i) {
      if (customers.charAt(i) == 'N')
        nCount++;
      else
        yCount++;

      count.add(new Count(yCount, nCount));
    }
    return count;
  }

  private record Count(int y, int n) {}
}

package greedy;

/**
 *
 * 2498. Frog Jump II
 *
 * positions of stones in a river.
 * <p>
 * A frog, initially on the first stone, wants to travel to the last stone and then return to the first stone. However, it can jump to any stone at most once.
 * <p>
 * The length of a jump is the absolute difference between the position of the stone the frog is currently on and the position of the stone to which the frog jumps.
 * <p>
 * More formally, if the frog is at stones[i] and is jumping to stones[j], the length of the jump is |stones[i] - stones[j]|.
 * The cost of a path is the maximum length of a jump among all jumps in the path.
 * <p>
 * Return the minimum cost of a path for the frog.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: stones = [0,2,5,6,7]
 * Output: 5
 * Explanation: The above figure represents one of the optimal paths the frog can take.
 * The cost of this path is 5, which is the maximum length of a jump.
 * Since it is not possible to achieve a cost of less than 5, we return it.
 */
public class FrogJumpII {

  public int maxJump(int[] stones) {
    int maxJump = stones[1] - stones[0];
    for (int i = 2; i < stones.length; ++i)
      maxJump = Math.max(stones[i] - stones[i - 2], maxJump);

    return maxJump;
  }
}

package math;


/**
 * 365. Water and Jug Problem
 * <p>
 * You are given two jugs with capacities jug1Capacity and jug2Capacity liters.
 * There is an infinite amount of water supply available. Determine whether it is possible to measure exactly targetCapacity liters using these two jugs.
 * <p>
 * If targetCapacity liters of water are measurable, you must have targetCapacity liters of water contained within one or both buckets by the end.
 * <p>
 * Operations allowed:
 * <p>
 * Fill any of the jugs with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full, or the first jug itself is empty.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4
 * Output: true
 * Explanation: The famous Die Hard example
 * Example 2:
 * <p>
 * Input: jug1Capacity = 2, jug2Capacity = 6, targetCapacity = 5
 * Output: false
 * Example 3:
 * <p>
 * Input: jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3
 * Output: true
 */
public class WaterAndJugProblem {

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        return jug1Capacity + jug2Capacity >= targetCapacity && targetCapacity % greatestCommonDivisor(jug1Capacity, jug2Capacity) == 0;
    }

    private int greatestCommonDivisor(int a, int b) {
        return b == 0 ? a : greatestCommonDivisor(b, a % b);
    }
}

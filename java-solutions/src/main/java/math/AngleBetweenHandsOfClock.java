package math;

/**
 * @author FLIGHT
 * <p>
 * 1344. Angle Between Hands of a Clock
 * Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.
 * <p>
 * Answers within 10-5 of the actual value will be accepted as correct.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: hour = 12, minutes = 30
 * Output: 165
 * Example 2:
 * <p>
 * <p>
 * Input: hour = 3, minutes = 30
 * Output: 75
 * Example 3:
 * <p>
 * <p>
 * Input: hour = 3, minutes = 15
 * Output: 7.5
 */
public class AngleBetweenHandsOfClock {

  public double angleClock(int hour, int minutes) {
    double hourPosition = 5 * (hour % 12) + ((minutes * 1.0 / 60) * 5);
    double minutePosition = minutes * 1.0;

    double bigger = Math.max(minutePosition, hourPosition);
    double smaller = Math.min(minutePosition, hourPosition);

    double difference = Math.min(bigger - smaller, 60 - bigger + smaller);

    return (difference / 60) * 360;
  }
}

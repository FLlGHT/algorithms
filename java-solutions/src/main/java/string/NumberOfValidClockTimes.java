package string;

/**
 * 2437. Number of Valid Clock Times
 * <p>
 * You are given a string of length 5 called time, representing the current time on a digital clock in the format "hh:mm".
 * The earliest possible time is "00:00" and the latest possible time is "23:59".
 * <p>
 * In the string time, the digits represented by the ? symbol are unknown, and must be replaced with a digit from 0 to 9.
 * <p>
 * Return an integer answer, the number of valid clock times that can be created by replacing every ? with a digit from 0 to 9.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: time = "?5:00"
 * Output: 2
 * Explanation: We can replace the ? with either a 0 or 1, producing "05:00" or "15:00". Note that we cannot replace it with a 2,
 * since the time "25:00" is invalid. In total, we have two choices.
 * Example 2:
 * <p>
 * Input: time = "0?:0?"
 * Output: 100
 * Explanation: Each ? can be replaced by any digit from 0 to 9, so we have 100 total choices.
 * Example 3:
 * <p>
 * Input: time = "??:??"
 * Output: 1440
 * Explanation: There are 24 possible choices for the hours, and 60 possible choices for the minutes. In total, we have 24 * 60 = 1440 choices.
 */
public class NumberOfValidClockTimes {

    public int countTime(String time) {
        char hoursFirst = time.charAt(0), hoursSecond = time.charAt(1), minutesFirst = time.charAt(3), minutesSecond = time.charAt(4);
        int minutesChoices = (minutesFirst == '?' ? 6 : 1) * (minutesSecond == '?' ? 10 : 1), hoursChoices = 1;

        if (hoursFirst == '?')
            hoursChoices = hoursSecond == '?' ? 24 : (hoursSecond - '0' >= 4) ? 2 : 3;

        else if (hoursSecond == '?')
            hoursChoices = (hoursFirst - '0' == 2) ? 4 : 10;

        return hoursChoices * minutesChoices;
    }
}

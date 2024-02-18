package priorityqueue;

import java.util.*;

/**
 * @author FLIGHT
 * 2402. Meeting Rooms III
 * <p>
 * You are given an integer n. There are n rooms numbered from 0 to n - 1.
 * <p>
 * You are given a 2D integer array meetings where
 * meetings[i] = [starti, endi] means that a meeting will be held during the half-closed time interval [starti, endi).
 * All the values of starti are unique.
 * <p>
 * Meetings are allocated to rooms in the following manner:
 * <p>
 * Each meeting will take place in the unused room with the lowest number.
 * If there are no available rooms, the meeting will be delayed until a room becomes free.
 * The delayed meeting should have the same duration as the original meeting.
 * When a room becomes unused, meetings that have an earlier original start time should be given the room.
 * Return the number of the room that held the most meetings.
 * If there are multiple rooms, return the room with the lowest number.
 * <p>
 * A half-closed interval [a, b) is the interval between a and b including a and not including b.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
 * Output: 0
 * Explanation:
 * - At time 0, both rooms are not being used. The first meeting starts in room 0.
 * - At time 1, only room 1 is not being used. The second meeting starts in room 1.
 * - At time 2, both rooms are being used. The third meeting is delayed.
 * - At time 3, both rooms are being used. The fourth meeting is delayed.
 * - At time 5, the meeting in room 1 finishes. The third meeting starts in room 1 for the time period [5,10).
 * - At time 10, the meetings in both rooms finish. The fourth meeting starts in room 0 for the time period [10,11).
 * Both rooms 0 and 1 held 2 meetings, so we return 0.
 * Example 2:
 * <p>
 * Input: n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]
 * Output: 1
 * Explanation:
 * - At time 1, all three rooms are not being used. The first meeting starts in room 0.
 * - At time 2, rooms 1 and 2 are not being used. The second meeting starts in room 1.
 * - At time 3, only room 2 is not being used. The third meeting starts in room 2.
 * - At time 4, all three rooms are being used. The fourth meeting is delayed.
 * - At time 5, the meeting in room 2 finishes. The fourth meeting starts in room 2 for the time period [5,10).
 * - At time 6, all three rooms are being used. The fifth meeting is delayed.
 * - At time 10, the meetings in rooms 1 and 2 finish. The fifth meeting starts in room 1 for the time period [10,12).
 * Room 0 held 1 meeting while rooms 1 and 2 each held 2 meetings, so we return 1.
 */
public class MeetingRoomsIII {

  public int mostBooked(int n, int[][] meetings) {
    Arrays.sort(meetings, Comparator.comparing(meeting -> meeting[0]));
    Comparator<Meeting> meetingComparator = Comparator.comparing(Meeting::to).thenComparing(Meeting::room);
    PriorityQueue<Meeting> currentMeetings = new PriorityQueue<>(meetingComparator);
    PriorityQueue<Integer> availableRooms = rooms(n);
    Map<Integer, Integer> roomFrequency = new HashMap<>();
    int maxFrequencyRoom = 0;

    for (int[] nextMeeting : meetings) {
      int nextMeetingStart = nextMeeting[0], nextMeetingFinish = nextMeeting[1];
      while (!currentMeetings.isEmpty() && currentMeetings.peek().to() <= nextMeetingStart) {
        Meeting meeting = currentMeetings.poll();
        availableRooms.offer(meeting.room());
      }

      if (!availableRooms.isEmpty()) {
        int room = availableRooms.poll();
        currentMeetings.offer(new Meeting(nextMeetingFinish, room));
        maxFrequencyRoom = updateMaxFrequencyRoom(roomFrequency, room, maxFrequencyRoom);
      } else {
        Meeting previousMeeting = currentMeetings.poll();
        int room = previousMeeting.room();
        int duration = nextMeetingFinish - nextMeetingStart;
        currentMeetings.offer(new Meeting(previousMeeting.to() + duration, room));
        maxFrequencyRoom = updateMaxFrequencyRoom(roomFrequency, room, maxFrequencyRoom);
      }
    }

    return maxFrequencyRoom;
  }

  private int updateMaxFrequencyRoom(Map<Integer, Integer> roomFrequency, int room, int maxFrequencyRoom) {
    roomFrequency.merge(room, 1, Integer::sum);
    int currentFrequency = roomFrequency.get(room);
    int maxFrequency = roomFrequency.getOrDefault(maxFrequencyRoom, Integer.MIN_VALUE);

    if (currentFrequency > maxFrequency) {
      return room;
    } else if (currentFrequency == maxFrequency)
      return Math.min(room, maxFrequencyRoom);

    return maxFrequencyRoom;
  }
  private PriorityQueue<Integer> rooms(int n) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < n; ++i) {
      queue.offer(i);
    }
    return queue;
  }

  private record Meeting(long to, int room) {
  }

}

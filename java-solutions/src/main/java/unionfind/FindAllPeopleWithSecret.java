package unionfind;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @author FLIGHT
 * <p>
 * 2092. Find All People With Secret
 * <p>
 * You are given an integer n indicating there are n people numbered from 0 to n - 1.
 * You are also given a 0-indexed 2D integer array meetings
 * where meetings[i] = [xi, yi, timei] indicates that person xi and person yi have a meeting at timei.
 * A person may attend multiple meetings at the same time. Finally, you are given an integer firstPerson.
 * <p>
 * Person 0 has a secret and initially shares the secret with a person firstPerson at time 0.
 * This secret is then shared every time a meeting takes place with a person that has the secret.
 * More formally, for every meeting, if a person xi has the secret at timei, then they will share the secret with person yi, and vice versa.
 * <p>
 * The secrets are shared instantaneously.
 * That is, a person may receive the secret and share it with people in other meetings within the same time frame.
 * <p>
 * Return a list of all the people that have the secret after all the meetings have taken place.
 * You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
 * Output: [0,1,2,3,5]
 * Explanation:
 * At time 0, person 0 shares the secret with person 1.
 * At time 5, person 1 shares the secret with person 2.
 * At time 8, person 2 shares the secret with person 3.
 * At time 10, person 1 shares the secret with person 5
 * Thus, people 0, 1, 2, 3, and 5 know the secret after all the meetings.
 * Example 2:
 * <p>
 * Input: n = 4, meetings = [[3,1,3],[1,2,2],[0,3,3]], firstPerson = 3
 * Output: [0,1,3]
 * Explanation:
 * At time 0, person 0 shares the secret with person 3.
 * At time 2, neither person 1 nor person 2 know the secret.
 * At time 3, person 3 shares the secret with person 0 and person 1.
 * Thus, people 0, 1, and 3 know the secret after all the meetings.
 * Example 3:
 * <p>
 * Input: n = 5, meetings = [[3,4,2],[1,2,1],[2,3,1]], firstPerson = 1
 * Output: [0,1,2,3,4]
 * Explanation:
 * At time 0, person 0 shares the secret with person 1.
 * At time 1, person 1 shares the secret with person 2, and person 2 shares the secret with person 3.
 * Note that person 2 can share the secret at the same time as receiving it.
 * At time 2, person 3 shares the secret with person 4.
 * Thus, people 0, 1, 2, 3, and 4 know the secret after all the meetings.
 */
public class FindAllPeopleWithSecret {

  public List<Integer> findAllPeople(int n, int[][] rawMeetings, int firstPerson) {
    UnionFind disjointSet = new UnionFind(n);
    Map<Integer, List<Meeting>> meetings = groupByTimeAndSort(rawMeetings);

    disjointSet.union(0, firstPerson);
    for (List<Meeting> meetingsAtTime : meetings.values()) {
      for (Meeting meeting : meetingsAtTime) {
        disjointSet.union(meeting.first(), meeting.second());
      }
      for (Meeting meeting : meetingsAtTime) {
        if (!disjointSet.connected(meeting.first(), 0))
          disjointSet.reset(meeting.first(), meeting.second());
      }
    }

    Set<Integer> peopleWithSecret = new HashSet<>();
    for (int person = 0; person < n; ++person) {
      if (disjointSet.connected(person, 0))
        peopleWithSecret.add(person);
    }

    return new ArrayList<>(peopleWithSecret);
  }

  private Map<Integer, List<Meeting>> groupByTimeAndSort(int[][] rawMeetings) {
    BinaryOperator<List<Meeting>> mergeOperator = (m1, m2) -> m1;
    return Arrays.stream(rawMeetings)
      .map(meeting -> new Meeting(meeting[0], meeting[1], meeting[2]))
      .collect(Collectors.groupingBy(Meeting::time))
      .entrySet().stream()
      .sorted(Map.Entry.comparingByKey())
      .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, mergeOperator, LinkedHashMap::new));
  }

  public class UnionFind {

    private final int[] parent;

    public UnionFind(int n) {
      this.parent = new int[n];
      for (int person = 0; person < n; ++person) {
        parent[person] = person;
      }
    }

    public void union(int first, int second) {
      parent[find(first)] = find(second);
    }

    public int find(int person) {
      return parent[person] == person ? person : (parent[person] = find(parent[person]));
    }

    public void reset(int first, int second) {
      parent[first] = first;
      parent[second] = second;
    }

    public boolean connected(int first, int second) {
      return find(first) == find(second);
    }
  }

  private record Meeting(int first, int second, int time) {
  }
}

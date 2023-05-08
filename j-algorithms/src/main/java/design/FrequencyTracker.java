package design;

import java.util.*;

/**
 * 2671. Frequency Tracker
 * Design a data structure that keeps track of the values in it and answers some queries regarding their frequencies.
 * <p>
 * Implement the FrequencyTracker class.
 * <p>
 * FrequencyTracker(): Initializes the FrequencyTracker object with an empty array initially.
 * void add(int number): Adds number to the data structure.
 * void deleteOne(int number): Deletes one occurence of number from the data structure. The data structure may not contain number, and in this case nothing is deleted.
 * bool hasFrequency(int frequency): Returns true if there is a number in the data structure that occurs frequency number of times, otherwise, it returns false.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["FrequencyTracker", "add", "add", "hasFrequency"]
 * [[], [3], [3], [2]]
 * Output
 * [null, null, null, true]
 * <p>
 * Explanation
 * frequencyTracker.add(3); // The data structure now contains [3]
 * frequencyTracker.add(3); // The data structure now contains [3, 3]
 * frequencyTracker.hasFrequency(2); // Returns true, because 3 occurs twice
 * <p>
 * Example 2:
 * <p>
 * Input
 * ["FrequencyTracker", "add", "deleteOne", "hasFrequency"]
 * [[], [1], [1], [1]]
 * Output
 * [null, null, null, false]
 * <p>
 * Explanation
 * <p>
 * frequencyTracker.add(1); // The data structure now contains [1]
 * frequencyTracker.deleteOne(1); // The data structure becomes empty []
 * frequencyTracker.hasFrequency(1); // Returns false, because the data structure is empty
 * <p>
 * Example 3:
 * <p>
 * Input
 * ["FrequencyTracker", "hasFrequency", "add", "hasFrequency"]
 * [[], [2], [3], [1]]
 * Output
 * [null, false, null, true]
 * <p>
 * Explanation
 * <p>
 * frequencyTracker.hasFrequency(2); // Returns false, because the data structure is empty
 * frequencyTracker.add(3); // The data structure now contains [3]
 * frequencyTracker.hasFrequency(1); // Returns true, because 3 occurs once
 */
public class FrequencyTracker {

  private final Map<Integer, Integer> elementToFrequency;
  private final Map<Integer, Set<Integer>> frequencyToElements;

  public FrequencyTracker() {
    elementToFrequency = new HashMap<>();
    frequencyToElements = new HashMap<>();
  }

  public void add(int number) {
    elementToFrequency.put(number, elementToFrequency.getOrDefault(number, 0) + 1);
    recomputeFrequency(number, elementToFrequency.get(number) - 1);
  }

  public void deleteOne(int number) {
    if (elementToFrequency.containsKey(number)) {
      elementToFrequency.put(number, elementToFrequency.get(number) - 1);

      recomputeFrequency(number, elementToFrequency.get(number) + 1);

      if (elementToFrequency.get(number) == 0)
        elementToFrequency.remove(number);
    }
  }

  private void recomputeFrequency(int number, int previousFrequency) {
    int frequency = elementToFrequency.get(number);

    if (previousFrequency > 0) {
      frequencyToElements.get(previousFrequency).remove(number);
      if (frequencyToElements.get(previousFrequency).size() == 0)
        frequencyToElements.remove(previousFrequency);
    }

    frequencyToElements.computeIfAbsent(frequency, p -> new HashSet<>()).add(number);
  }

  public boolean hasFrequency(int frequency) {
    return frequencyToElements.containsKey(frequency);
  }
}

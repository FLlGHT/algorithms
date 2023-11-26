package design;

import java.util.HashSet;
import java.util.Set;


/**
 * 379. Design Phone Directory
 * <p>
 * Design a phone directory that initially has maxNumbers empty slots that can store numbers.
 * The directory should store numbers, check if a certain slot is empty or not, and empty a given slot.
 * <p>
 * Implement the PhoneDirectory class:
 * <p>
 * PhoneDirectory(int maxNumbers) Initializes the phone directory with the number of available slots maxNumbers.
 * int get() Provides a number that is not assigned to anyone. Returns -1 if no number is available.
 * bool check(int number) Returns true if the slot number is available and false otherwise.
 * void release(int number) Recycles or releases the slot number.
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["PhoneDirectory", "get", "get", "check", "get", "check", "release", "check"]
 * [[3], [], [], [2], [], [2], [2], [2]]
 * Output
 * [null, 0, 1, true, 2, false, null, true]
 * <p>
 * Explanation
 * PhoneDirectory phoneDirectory = new PhoneDirectory(3);
 * phoneDirectory.get();      // It can return any available phone number. Here we assume it returns 0.
 * phoneDirectory.get();      // Assume it returns 1.
 * phoneDirectory.check(2);   // The number 2 is available, so return true.
 * phoneDirectory.get();      // It returns 2, the only number that is left.
 * phoneDirectory.check(2);   // The number 2 is no longer available, so return false.
 * phoneDirectory.release(2); // Release number 2 back to the pool.
 * phoneDirectory.check(2);   // Number 2 is available again, return true.
 */
public class PhoneDirectory {

    private final Set<Integer> available;

    public PhoneDirectory(int maxNumbers) {
        available = new HashSet<>();
        for (int number = 0; number < maxNumbers; ++number) {
            available.add(number);
        }
    }

    public int get() {
        if (!available.isEmpty()) {
            int number = available.iterator().next();
            available.remove(number);
            return number;
        }
        else
            return -1;
    }

    public boolean check(int number) {
        return available.contains(number);
    }

    public void release(int number) {
        available.add(number);
    }
}

//
// Created by fedorenko on 26.09.2022.
//

#ifndef C_ALGORITMS_PHONEDIRECTORY_H
#define C_ALGORITMS_PHONEDIRECTORY_H
#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

/**
 * 379. Design Phone Directory
 *
 * Design a phone directory that initially has maxNumbers empty slots that can store numbers.
 * The directory should store numbers, check if a certain slot is empty or not, and empty a given slot.
 *
 * Implement the PhoneDirectory class:
 *
 * PhoneDirectory(int maxNumbers) Initializes the phone directory with the number of available slots maxNumbers.
 * int get() Provides a number that is not assigned to anyone. Returns -1 if no number is available.
 * bool check(int number) Returns true if the slot number is available and false otherwise.
 * void release(int number) Recycles or releases the slot number.
 *
 * Example 1:
 *
 * Input
 * ["PhoneDirectory", "get", "get", "check", "get", "check", "release", "check"]
 * [[3], [], [], [2], [], [2], [2], [2]]
 * Output
 * [null, 0, 1, true, 2, false, null, true]
 *
 * Explanation
 * PhoneDirectory phoneDirectory = new PhoneDirectory(3);
 * phoneDirectory.get();      // It can return any available phone number. Here we assume it returns 0.
 * phoneDirectory.get();      // Assume it returns 1.
 * phoneDirectory.check(2);   // The number 2 is available, so return true.
 * phoneDirectory.get();      // It returns 2, the only number that is left.
 * phoneDirectory.check(2);   // The number 2 is no longer available, so return false.
 * phoneDirectory.release(2); // Release number 2 back to the pool.
 * phoneDirectory.check(2);   // Number 2 is available again, return true.
 *
 */
class PhoneDirectory {

private: unordered_set<int> available;

public:
    PhoneDirectory(int maxNumbers) {
        for (int number = 0; number < maxNumbers; ++number) {
            available.insert(number);
        }
    }

private:
    int get() {
        if (!available.empty()) {
            int number = *available.begin();
            available.erase(number);
            return number;
        }

        else return -1;
    }

private:
    bool check(int number) {
        return available.find(number) != available.end();
    }

private:
    void release(int number) {
        available.insert(number);
    }


};


#endif //C_ALGORITMS_PHONEDIRECTORY_H

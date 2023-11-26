//
// Created by Michael Fedorenko on 30.10.2022.
//

#ifndef C_ALGORITMS_REORDEREDPOWEROFTWO_H
#define C_ALGORITMS_REORDEREDPOWEROFTWO_H

#include <string>

using namespace std;

/**
 * 869. Reordered Power of 2
 *
 * You are given an integer n. We reorder the digits in any order (including the original order)
 * such that the leading digit is not zero.
 * <p>
 * Return true if and only if we can do this so that the resulting number is a power of two.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: true
 * Example 2:
 * <p>
 * Input: n = 10
 * Output: false
 */
class ReorderedPowerOfTwo {


public:
    bool reorderedPowerOf2(int n) {
        string number = sortedDigits(n);

        for (int i = 0; i < 30; ++i) {
            string powerOfTwo = sortedDigits(1 << i);
            if (number == powerOfTwo)
                return true;
        }

        return false;
    }

private:
    string sortedDigits(int n) {
        string digits = to_string(n);
        sort(digits.begin(), digits.end());
        return digits;
    }
};


#endif //C_ALGORITMS_REORDEREDPOWEROFTWO_H

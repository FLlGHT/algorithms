//
// Created by Michael Fedorenko on 16.01.2024.
//

#ifndef CPP_ALGO_ANGLEBETWEENHANDSOFCLOCK_H
#define CPP_ALGO_ANGLEBETWEENHANDSOFCLOCK_H

using namespace std;

/**
 * 1344. Angle Between Hands of a Clock
 *
 * Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.

Answers within 10-5 of the actual value will be accepted as correct.



Example 1:


Input: hour = 12, minutes = 30
Output: 165
Example 2:


Input: hour = 3, minutes = 30
Output: 75
Example 3:


Input: hour = 3, minutes = 15
Output: 7.5
 */

class AngleBetweenHandsOfClock {

public:
    double angleClock(int hour, int minutes) {
        double hourPosition = 5 * (hour % 12) + ((minutes * 1.0 / 60) * 5);
        double minutePosition = minutes * 1.0;

        double bigger = max(minutePosition, hourPosition);
        double smaller = min(minutePosition, hourPosition);

        double difference = min(bigger - smaller, 60 - bigger + smaller);

        return (difference / 60) * 360;
    }
};


#endif //CPP_ALGO_ANGLEBETWEENHANDSOFCLOCK_H

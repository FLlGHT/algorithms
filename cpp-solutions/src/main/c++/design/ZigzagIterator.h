//
// Created by Michael Fedorenko on 02.01.2024.
//

#ifndef CPP_ALGO_ZIGZAGITERATOR_H
#define CPP_ALGO_ZIGZAGITERATOR_H

#include <vector>

using namespace std;

/**
 * 281. Zigzag Iterator

Given two vectors of integers v1 and v2, implement an iterator to return their elements alternately.

Implement the ZigzagIterator class:

ZigzagIterator(List<int> v1, List<int> v2) initializes the object with the two vectors v1 and v2.
boolean hasNext() returns true if the iterator still has elements, and false otherwise.
int next() returns the current element of the iterator and moves the iterator to the next element.


Example 1:

Input: v1 = [1,2], v2 = [3,4,5,6]
Output: [1,3,2,4,5,6]
Explanation: By calling next repeatedly until hasNext returns false,
 the order of elements returned by next should be: [1,3,2,4,5,6].
Example 2:

Input: v1 = [1], v2 = []
Output: [1]
Example 3:

Input: v1 = [], v2 = [1]
Output: [1]
 */
class ZigzagIterator {

private:
    vector<int> vector1;
    vector<int> vector2;
    int index1;
    int index2;

public:
    ZigzagIterator(vector<int> &v1, vector<int> &v2) {
        this->vector1 = v1;
        this->vector2 = v2;
        this->index1 = 0;
        this->index2 = 0;
    }

    int next() {
        if (index1 < vector1.size() && (index1 == index2 || index2 >= vector2.size()))
            return vector1[index1++];

        return vector2[index2++];
    }

    bool hasNext() {
        return index1 < vector1.size() || index2 < vector2.size();
    }
};


#endif //CPP_ALGO_ZIGZAGITERATOR_H

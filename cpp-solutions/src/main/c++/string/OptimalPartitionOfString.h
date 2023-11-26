//
// Created by fedorenko on 21.10.2022.
//

#ifndef C_ALGORITMS_OPTIMALPARTITIONOFSTRING_H
#define C_ALGORITMS_OPTIMALPARTITIONOFSTRING_H

#include <string>
#include <unordered_set>

using namespace std;

/**
 * 2405. Optimal Partition of String
 * <p>
 * Given a string s, partition the string into one or more substrings such that the characters in each substring are unique.
 * That is, no letter appears in a single substring more than once.
 * <p>
 * Return the minimum number of substrings in such a partition.
 * <p>
 * Note that each character should belong to exactly one substring in a partition.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abacaba"
 * Output: 4
 * Explanation:
 * Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
 * It can be shown that 4 is the minimum number of substrings needed.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "ssssss"
 * Output: 6
 * Explanation:
 * The only valid partition is ("s","s","s","s","s","s").
 */

class OptimalPartitionOfString {

public:
    int partitionString(string s) {
        int partCount = 1;

        unordered_set<char> currentWord;
        for (char letter : s) {
            if (currentWord.find(letter) != currentWord.end()) {
                currentWord.clear();
                partCount++;
            }
            currentWord.insert(letter);
        }
        return partCount;
    }


};


#endif //C_ALGORITMS_OPTIMALPARTITIONOFSTRING_H

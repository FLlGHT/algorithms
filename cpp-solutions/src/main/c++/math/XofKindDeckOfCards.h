//
// Created by fedorenko on 17.10.2022.
//

#ifndef C_ALGORITMS_XOFKINDDECKOFCARDS_H
#define C_ALGORITMS_XOFKINDDECKOFCARDS_H

#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 914. X of a Kind in a Deck of Cards
 *
 * You are given an integer array deck where deck[i] represents the number written on the ith card.

Partition the cards into one or more groups such that:

Each group has exactly x cards where x > 1, and
All the cards in one group have the same integer written on them.
Return true if such partition is possible, or false otherwise.



Example 1:

Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
Example 2:

Input: deck = [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition.
 */
class XofKindDeckOfCards {

public:
    bool hasGroupsSizeX(vector<int>& deck) {
        unordered_map<int, int> groups; int gcd = 0;

        for (int card : deck)
            groups[card]++;

        for (const auto &entry: groups)
            gcd = greatestCommonDivisor(gcd, entry.second);

        return gcd > 1;
    }

private:
    int greatestCommonDivisor(int first, int second) {
        return second == 0 ? first : greatestCommonDivisor(second, first % second);
    }
};


#endif //C_ALGORITMS_XOFKINDDECKOFCARDS_H

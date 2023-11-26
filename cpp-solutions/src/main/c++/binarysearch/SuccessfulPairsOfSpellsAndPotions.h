//
// Created by Michael Fedorenko on 02.04.2023.
//

#include <iostream>
#include <vector>

using namespace std;
#ifndef C_ALGORITMS_SUCCESSFULPAIRSOFSPELLSANDPOTIONS_H
#define C_ALGORITMS_SUCCESSFULPAIRSOFSPELLSANDPOTIONS_H


/**
2300. Successful Pairs of Spells and Potions

You are given two positive integer arrays spells and potions, of length n and m respectively,
 where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.

You are also given an integer success.
 A spell and potion pair is considered successful if the product of their strengths is at least success.

Return an integer array pairs of length n
 where pairs[i] is the number of potions that will form a successful pair with the ith spell.
 */
class SuccessfulPairsOfSpellsAndPotions {

public:
    vector<int> successfulPairs(vector<int> &spells, vector<int> &potions, long long success) {
        sort(potions.begin(), potions.end());
        vector<int> result = vector<int>(spells.size());

        for (int i = 0; i < spells.size(); ++i) {
            long successFactor = (success + spells[i] - 1) / spells[i];
            int startPosition = binarySearch(potions, successFactor);
            result[i] = potions.size() - startPosition;
        }

        return result;
    }

private:
    int binarySearch(vector<int> &potions, long successFactor) {
        int left = 0, right = potions.size();

        while (left < right) {
            int middle = left + (right - left) / 2;

            if (potions[middle] < successFactor)
                left = middle + 1;
            else
                right = middle;
        }

        return right;
    }
};


#endif //C_ALGORITMS_SUCCESSFULPAIRSOFSPELLSANDPOTIONS_H

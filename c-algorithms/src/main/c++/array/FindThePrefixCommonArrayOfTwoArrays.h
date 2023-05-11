//
// Created by Michael Fedorenko on 11.05.2023.
//

#ifndef C_ALGORITHMS_FINDTHEPREFIXCOMMONARRAYOFTWOARRAYS_H
#define C_ALGORITHMS_FINDTHEPREFIXCOMMONARRAYOFTWOARRAYS_H
#include "vector"

using namespace std;

/**
 * 2657. Find the Prefix Common Array of Two Arrays
 * You are given two 0-indexed integer permutations A and B of length n.
 * <p>
 * A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.
 * <p>
 * Return the prefix common array of A and B.
 * <p>
 * A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1,3,2,4], B = [3,1,2,4]
 * Output: [0,2,3,4]
 * Explanation: At i = 0: no number is common, so C[0] = 0.
 * At i = 1: 1 and 3 are common in A and B, so C[1] = 2.
 * At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
 * At i = 3: 1, 2, 3, and 4 are common in A and B, so C[3] = 4.
 * Example 2:
 * <p>
 * Input: A = [2,3,1], B = [3,1,2]
 * Output: [0,1,3]
 * Explanation: At i = 0: no number is common, so C[0] = 0.
 * At i = 1: only 3 is common in A and B, so C[1] = 1.
 * At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
 */
class FindThePrefixCommonArrayOfTwoArrays {
public:
    vector<int> findThePrefixCommonArray(vector<int>& first, vector<int>& second) {
        vector<int> seen(first.size() + 1);
        vector<int> result(first.size());
        int presentInBoth = 0;

        for (int i = 0; i < first.size(); ++i) {
            if (++seen[first[i]] == 2)
                presentInBoth++;
            if (++seen[second[i]] == 2)
                presentInBoth++;

            result[i] = presentInBoth;
        }

        return result;
    }
};


#endif //C_ALGORITHMS_FINDTHEPREFIXCOMMONARRAYOFTWOARRAYS_H

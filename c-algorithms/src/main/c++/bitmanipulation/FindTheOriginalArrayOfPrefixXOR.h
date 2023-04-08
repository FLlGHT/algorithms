//
// Created by Michael Fedorenko on 09.10.2022.
//

#ifndef C_ALGORITMS_FINDTHEORIGINALARRAYOFPREFIXXOR_H
#define C_ALGORITMS_FINDTHEORIGINALARRAYOFPREFIXXOR_H
using namespace std;
#include <vector>
/**
 * 2433. Find The Original Array of Prefix Xor
 * <p>
 * You are given an integer array pref of size n. Find and return the array arr of size n that satisfies:
 * <p>
 * pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
 * Note that ^ denotes the bitwise-xor operation.
 * <p>
 * It can be proven that the answer is unique.
 * <p>
 * Example 1:
 * <p>
 * Input: pref = [5,2,0,3,1]
 * Output: [5,7,2,3,2]
 * Explanation: From the array [5,7,2,3,2] we have the following:
 * - pref[0] = 5.
 * - pref[1] = 5 ^ 7 = 2.
 * - pref[2] = 5 ^ 7 ^ 2 = 0.
 * - pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3.
 * - pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1.
 * Example 2:
 * <p>
 * Input: pref = [13]
 * Output: [13]
 * Explanation: We have pref[0] = arr[0] = 13.
 */
class FindTheOriginalArrayOfPrefixXOR {
public:
    vector<int> findArray(vector<int>& pref) {
        vector<int> result(pref.size());
        result[0] = pref[0];
        for (int i = 1; i < pref.size(); ++i) {
            result[i] = pref[i] ^ pref[i - 1];
        }

        return result;
    }
};


#endif //C_ALGORITMS_FINDTHEORIGINALARRAYOFPREFIXXOR_H

//
// Created by fedorenko on 27.09.2022.
//

#ifndef C_ALGORITMS_LONGESTSUBSTRINGWITHATMOSTTWODISTINCTCHARACTERS_H
#define C_ALGORITMS_LONGESTSUBSTRINGWITHATMOSTTWODISTINCTCHARACTERS_H
#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;


class LongestSubstringWithAtMostTwoDistinctCharacters {
public:
    int lengthOfLongestSubstringTwoDistinct(string s) {
        int longest = 0;

        for (int left = 0, right = 0; left < s.size(); left++, right = left) {
            unordered_set<char> letters;

            while (right < s.size() && letters.size() <= 2) {
                letters.insert(s[right]);
                if (letters.size() <= 2) right++;
            }

            longest = max(longest, right - left);
        }

        return longest;
    }
};


#endif //C_ALGORITMS_LONGESTSUBSTRINGWITHATMOSTTWODISTINCTCHARACTERS_H

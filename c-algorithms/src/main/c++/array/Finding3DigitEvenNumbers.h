//
// Created by fedorenko on 13.10.2022.
//

#ifndef C_ALGORITMS_FINDING3DIGITEVENNUMBERS_H
#define C_ALGORITMS_FINDING3DIGITEVENNUMBERS_H

#include <vector>
#include <unordered_set>

using namespace std;

class Finding3DigitEvenNumbers {

public:
    vector<int> findEvenNumbers(vector<int>& digits) {
        unordered_set<int> evenNumbers;
        vector<int> result;
        for (int first = 0; first < digits.size(); ++first) {
            for (int second = 0; second < digits.size(); ++second) {
                for (int third = 0; third < digits.size(); ++third) {
                    if (first != second && second != third && first != third && digits[first] != 0 && digits[third] % 2 == 0) {
                        int number = digits[first] * 100 + digits[second] * 10 + digits[third];
                        if (evenNumbers.find(number) == evenNumbers.end()) {
                            result.push_back(number);
                            evenNumbers.insert(number);
                        }
                    }
                }
            }
        }

        sort(result.begin(), result.end());
        return result;
    }
};


#endif //C_ALGORITMS_FINDING3DIGITEVENNUMBERS_H

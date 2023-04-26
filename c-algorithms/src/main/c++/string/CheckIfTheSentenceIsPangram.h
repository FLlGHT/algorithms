//
// Created by fedorenko on 17.10.2022.
//

#ifndef C_ALGORITMS_CHECKIFTHESENTENCEISPANGRAM_H
#define C_ALGORITMS_CHECKIFTHESENTENCEISPANGRAM_H

#include <string>
#include <unordered_set>

using namespace std;

/**
 *
 */
class CheckIfTheSentenceIsPangram {
public:
    bool checkIfPangram(string sentence) {
        unordered_set<int> letters;
        for (const auto &letter: sentence)
            letters.insert(letter);

        return letters.size() == 26;
    }
};


#endif //C_ALGORITMS_CHECKIFTHESENTENCEISPANGRAM_H

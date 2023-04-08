//
// Created by fedorenko on 31.10.2022.
//

#ifndef C_ALGORITMS_WORDSWITHINTWOEDITSOFDICTIONARY_H
#define C_ALGORITMS_WORDSWITHINTWOEDITSOFDICTIONARY_H

#include <string>
#include <vector>

using namespace std;

class WordsWithinTwoEditsOfDictionary {
public:
    vector<string> twoEditWords(vector<string>& queries, vector<string>& dictionary) {
        vector<string> twoEditWords;

        for (const string& fromQuery : queries) {
            for (const string& fromDictionary : dictionary) {
                if (maximumTwoEdits(fromQuery, fromDictionary)) {
                    twoEditWords.push_back(fromQuery);
                    break;
                }
            }
        }
        return twoEditWords;
    }

private:
    bool maximumTwoEdits(string from, string to) {
        int edits = 0;

        for (int i = 0; i < from.length(); ++i) {
            if (from[i] != to[i])
                edits++;

            if (edits > 2)
                return false;
        }

        return true;
    }
};


#endif //C_ALGORITMS_WORDSWITHINTWOEDITSOFDICTIONARY_H

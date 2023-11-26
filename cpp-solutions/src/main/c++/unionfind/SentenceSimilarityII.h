//
// Created by fedorenko on 28.09.2022.
//

#ifndef C_ALGORITMS_SENTENCESIMILARITYII_H
#define C_ALGORITMS_SENTENCESIMILARITYII_H

#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

class SentenceSimilarityII {
public:
    bool
    areSentencesSimilarTwo(vector<string> &sentence1, vector<string> &sentence2, vector<vector<string>> &similarPairs) {
        if (sentence1.size() != sentence2.size())
            return false;

        vector<int> groups = createGroups(similarPairs.size());
        int index = 0;
        unordered_map<string, int> wordToIndex;

        for (const auto &similarPair: similarPairs) {
            string word1 = similarPair[0], word2 = similarPair[1];
            if (wordToIndex.find(word1) == wordToIndex.end())
                wordToIndex[word1] = index++;
            if (wordToIndex.find(word2) == wordToIndex.end())
                wordToIndex[word2] = index++;

            merge(groups, wordToIndex[word1], wordToIndex[word2]);
        }

        for (int i = 0; i < sentence1.size(); ++i) {
            string word1 = sentence1[i], word2 = sentence2[i];

            if (word1 != word2 && !isSimilar(groups, wordToIndex, word1, word2))
                return false;
        }

        return true;
    }

private:
    bool isSimilar(vector<int> &groups, unordered_map<string, int> wordToIndex, string word1, string word2) {
        if (wordToIndex.find(word1) == wordToIndex.end() || wordToIndex.find(word2) == wordToIndex.end())
            return false;

        return find(groups, wordToIndex[word1]) == find(groups, wordToIndex[word2]);
    }

private:
    vector<int> createGroups(int pairCount) {
        vector<int> groups(pairCount * 2);
        for (int i = 0; i < groups.size(); ++i) {
            groups[i] = i;
        }
        return groups;
    }

private:
    void merge(vector<int> &groups, int firstWordIndex, int secondWordIndex) {
        int firstWordGroup = find(groups, firstWordIndex);
        int secondWordGroup = find(groups, secondWordIndex);

        if (firstWordGroup != secondWordGroup)
            groups[firstWordGroup] = secondWordGroup;
    }

private:
    int find(vector<int> &groups, int wordIndex) {
        if (groups[wordIndex] == wordIndex)
            return wordIndex;

        return find(groups, groups[wordIndex]);
    }
};


#endif //C_ALGORITMS_SENTENCESIMILARITYII_H

//
// Created by fedorenko on 12.10.2022.
//

#ifndef C_ALGORITMS_MINIMUMGENETICMUTATION_H
#define C_ALGORITMS_MINIMUMGENETICMUTATION_H

#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

/**
 * 433. Minimum Genetic Mutation
 *
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string start to a gene string end
 where one mutation is defined as one single character changed in the gene string.

For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings start and end and the gene bank bank,
 return the minimum number of mutations needed to mutate from start to end. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.



Example 1:

Input: start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
Output: 1


Example 2:

Input: start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
Output: 2


Example 3:

Input: start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
Output: 3
 */
class MinimumGeneticMutation {
private:
    int minimum = INT_MAX;
public:
    int minMutation(string start, string end, vector<string>& bank) {
        unordered_set<string> valid(bank.begin(), bank.end());
        unordered_set<string> visited;
        dfs(start, end, 0, valid, visited);
        return minimum == INT_MAX ? -1 : minimum;
    }

private:
    void dfs(const string& current, const string& end, int changes, unordered_set<string>& valid, unordered_set<string> visited) {
        if (changes >= minimum || visited.find(current) != visited.end())
            return;

        visited.insert(current);
        if (current == end)
            minimum = changes;

        for (const string& validString : valid) {
            if (haveOneDifference(current, validString))
                dfs(validString, end, changes + 1, valid, visited);
        }
        visited.erase(current);
    }

private:
    bool haveOneDifference(string first, string second) {
        int differences = 0;
        for (int i = 0; differences <= 1 && i < first.length(); ++i) {
            if (first[i] != second[i])
                differences++;
        }

        return differences == 1;
    }
};


#endif //C_ALGORITMS_MINIMUMGENETICMUTATION_H

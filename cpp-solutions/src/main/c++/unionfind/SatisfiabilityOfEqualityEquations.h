//
// Created by fedorenko on 26.09.2022.
//

#ifndef C_ALGORITMS_SATISFIABILITYOFEQUALITYEQUATIONS_H
#define C_ALGORITMS_SATISFIABILITYOFEQUALITYEQUATIONS_H
#include <iostream>
#include <vector>
using namespace std;

/**
 *
 * 990. Satisfiability of Equality Equations
 *
 * <p>
 * You are given an array of strings equations that represent relationships between variables
 * where each string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".
 * Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.
 * <p>
 * Return true if it is possible to assign integers to variable names to satisfy all the given equations, or false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: equations = ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
 * There is no way to assign the variables to satisfy both equations.
 * <p>
 * Example 2:
 * <p>
 * Input: equations = ["b==a","a==b"]
 * Output: true
 * Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 * <p>
 *
 */


class SatisfiabilityOfEqualityEquations {
public:
    bool equationsPossible(vector<string>& equations) {
        vector<int> groups = createGraph();

        for (const auto &equation: equations) {
            int first = equation[0] - 'a', second = equation[3] - 'a';
            bool isEqual = equation[1] == '=';
            if (isEqual)
                merge(first, second, groups);
        }

        for (const auto &equation: equations) {
            int first = equation[0] - 'a', second = equation[3] - 'a';
            bool isEqual = equation[1] == '=';
            if (!isEqual && find(first, groups) == find(second, groups))
                return false;
        }

        return true;
    }
private:
    vector<int> createGraph() {
        vector<int> groups(26);

        for (int i = 0; i < 26; ++i) {
            groups[i] = i;
        }

        return groups;
    }

private:
    void merge(int firstVariable, int secondVariable, vector<int>& groups) {
        int firstGroup = find(firstVariable, groups);
        int secondGroup = find(secondVariable, groups);

        if (firstGroup != secondGroup)
            groups[firstGroup] = secondGroup;
    }

private:
    int find(int variable, vector<int>& groups) {
        if (groups[variable] == variable)
            return variable;

        return find(groups[variable], groups);
    }
};


#endif //C_ALGORITMS_SATISFIABILITYOFEQUALITYEQUATIONS_H

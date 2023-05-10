//
// Created by Michael Fedorenko on 10.05.2023.
//

#ifndef C_ALGORITHMS_HINDEX_H
#define C_ALGORITHMS_HINDEX_H

#include <vector>

using namespace std;

/**
 * 274. H-Index
 * <p>
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 * Example 2:
 * <p>
 * Input: citations = [1,3,1]
 * Output: 1
 */
class HIndex {

public:
    int hIndex(vector<int> &citations) {
        vector<int> buckets(citations.size() + 1);

        for (int citation: citations) {
            if (citation >= citations.size())
                buckets[citations.size()]++;
            else
                buckets[citation]++;
        }

        for (int i = citations.size(), sum = 0; i >= 0; --i) {
            sum += buckets[i];
            if (sum >= i)
                return i;
        }

        return 0;
    }
};


#endif //C_ALGORITHMS_HINDEX_H

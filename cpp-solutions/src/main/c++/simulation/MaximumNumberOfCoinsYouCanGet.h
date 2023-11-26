//
// Created by fedorenko on 21.10.2022.
//

#ifndef C_ALGORITMS_MAXIMUMNUMBEROFCOINSYOUCANGET_H
#define C_ALGORITMS_MAXIMUMNUMBEROFCOINSYOUCANGET_H

#include <vector>

using namespace std;

class MaximumNumberOfCoinsYouCanGet {


public:
    int maxCoins(vector<int> &piles) {
        sort(piles.begin(), piles.end());

        int points = 0, n = piles.size();

        for (int i = 0; i < n / 3; ++i)
            points += piles[n - 2 - (2 * i)];

        return points;
    }
};


#endif //C_ALGORITMS_MAXIMUMNUMBEROFCOINSYOUCANGET_H

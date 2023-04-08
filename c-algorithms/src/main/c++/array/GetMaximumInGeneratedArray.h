//
// Created by fedorenko on 14.10.2022.
//

#ifndef C_ALGORITMS_GETMAXIMUMINGENERATEDARRAY_H
#define C_ALGORITMS_GETMAXIMUMINGENERATEDARRAY_H

#include <vector>

using namespace std;

class GetMaximumInGeneratedArray {

public:
    int getMaximumGenerated(int n) {
        if (n <= 1) return n;

        vector<int> generated(n + 1);
        generated[0] = 0; generated[1] = 1;
        int maximum = 1;

        for (int i = 0; 2 * i + 1 <= n; ++i) {
            generated[2 * i] = generated[i];
            generated[2 * i + 1] = generated[i] + generated[i + 1];
            maximum = max(maximum, max(generated[2 * i], generated[2 * i + 1]));
        }

        return maximum;
    }
};


#endif //C_ALGORITMS_GETMAXIMUMINGENERATEDARRAY_H

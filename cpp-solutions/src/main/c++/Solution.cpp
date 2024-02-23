//
// Created by fedorenko on 26.09.2022.
//

#include "Solution.h"
#include "MaximumSumCircularSubarray.h"
using namespace std;

int main() {
    MaximumSumCircularSubarray maximumSumCircularSubarray;
    vector<int> nums = {5, -3, 5};
    cout << maximumSumCircularSubarray.maxSubarraySumCircular(nums);
}
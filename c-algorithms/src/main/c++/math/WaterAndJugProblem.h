//
// Created by fedorenko on 12.10.2022.
//

#ifndef C_ALGORITMS_WATERANDJUGPROBLEM_H
#define C_ALGORITMS_WATERANDJUGPROBLEM_H
using namespace std;

class WaterAndJugProblem {

public:
    bool canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        return jug1Capacity + jug2Capacity >= targetCapacity && targetCapacity % greatestCommonDivisor(jug1Capacity, jug2Capacity) == 0;
    }

private:
    int greatestCommonDivisor(int a, int b) {
        return b == 0 ? a : greatestCommonDivisor(b, a % b);
    }
};


#endif //C_ALGORITMS_WATERANDJUGPROBLEM_H

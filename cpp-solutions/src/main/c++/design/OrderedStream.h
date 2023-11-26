//
// Created by fedorenko on 05.10.2022.
//

#ifndef C_ALGORITMS_ORDEREDSTREAM_H
#define C_ALGORITMS_ORDEREDSTREAM_H

#include <string>
#include <utility>
#include <vector>

using namespace std;

/**
 * 1656. Design an Ordered Stream
 *
 * There is a stream of n (idKey, value) pairs arriving in an arbitrary order,
 * where idKey is an integer between 1 and n and value is a string. No two pairs have the same id.

Design a stream that returns the values in increasing order of their IDs by returning a chunk (list) of values after each insertion.
 The concatenation of all the chunks should result in a list of the sorted values.

Implement the OrderedStream class:

OrderedStream(int n) Constructs the stream to take n values.
String[] insert(int idKey, String value) Inserts the pair (idKey, value) into the stream,
 then returns the largest possible chunk of currently inserted values that appear next in the order.
 */
class OrderedStream {

private:
    int pointer = 0;
private:
    vector<string> result;

public:
    explicit OrderedStream(int n) {
        result = vector<string>(n);
    }

    vector<string> insert(int idKey, string value) {
        result[idKey - 1] = value;
        vector<string> answer;
        while (pointer < result.size() && !result[pointer].empty()) {
            answer.push_back(result[pointer++]);
        }

        return answer;
    }
};


#endif //C_ALGORITMS_ORDEREDSTREAM_H

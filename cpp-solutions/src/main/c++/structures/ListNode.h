//
// Created by fedorenko on 14.10.2022.
//

#ifndef C_ALGORITMS_LISTNODE_H
#define C_ALGORITMS_LISTNODE_H


struct ListNode {
    int val;
    ListNode *next;

    ListNode() : val(0), next(nullptr) {}

    ListNode(int x) : val(x), next(nullptr) {}

    ListNode(int x, ListNode *next) : val(x), next(next) {}
};


#endif //C_ALGORITMS_LISTNODE_H

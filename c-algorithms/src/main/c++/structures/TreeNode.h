//
// Created by fedorenko on 28.09.2022.
//

#ifndef C_ALGORITMS_TREENODE_H
#define C_ALGORITMS_TREENODE_H


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode() : val(0), left(nullptr), right(nullptr) {}

    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    *

    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


#endif //C_ALGORITMS_TREENODE_H

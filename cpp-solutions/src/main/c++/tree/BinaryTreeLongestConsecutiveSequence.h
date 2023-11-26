//
// Created by fedorenko on 28.09.2022.
//

#ifndef C_ALGORITMS_BINARYTREELONGESTCONSECUTIVESEQUENCE_H
#define C_ALGORITMS_BINARYTREELONGESTCONSECUTIVESEQUENCE_H


#include "../structures/TreeNode.h"
#include <iostream>

using namespace std;

class BinaryTreeLongestConsecutiveSequence {

private:
    int longest = 0;

public:
    int longestConsecutive(TreeNode *root) {
        dfs(root, nullptr, 0);
        return longest;
    }

private:
    void dfs(TreeNode *root, TreeNode *parent, int length) {
        if (root == nullptr)
            return;

        length = (parent != nullptr && root->val == parent->val + 1) ? length + 1 : 1;
        longest = max(longest, length);

        dfs(root->left, root, length);
        dfs(root->right, root, length);
    }
};


#endif //C_ALGORITMS_BINARYTREELONGESTCONSECUTIVESEQUENCE_H

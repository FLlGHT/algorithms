//
// Created by fedorenko on 28.09.2022.
//

#ifndef C_ALGORITMS_COUNTUNIVALUESUBTREES_H
#define C_ALGORITMS_COUNTUNIVALUESUBTREES_H


#include "../structures/TreeNode.h"

/**
 *
 * 250. Count Univalue Subtrees
 * <p>
 * Given the root of a binary tree, return the number of uni-value subtrees.
 * <p>
 * A uni-value subtree means all nodes of the subtree have the same value.
 * <p>
 * Example 1:
 * Input: root = [5,1,5,5,5,null,5]
 * Output: 4
 * <p>
 * Input: root = []
 * Output: 0
 * <p>
 * Input: root = [5,5,5,5,5,null,5]
 * Output: 6
 */
class CountUniValueSubtrees {
private:
    int uniValueSubtrees = 0;

public:
    int countUnivalSubtrees(TreeNode *root) {
        isUniValue(root, 0);
        return uniValueSubtrees;
    }

private:
    bool isUniValue(TreeNode *node, int value) {
        if (node == nullptr)
            return true;

        if (!isUniValue(node->left, node->val) | !isUniValue(node->right, node->val))
            return false;

        uniValueSubtrees++;

        return node->val == value;
    }
};


#endif //C_ALGORITMS_COUNTUNIVALUESUBTREES_H

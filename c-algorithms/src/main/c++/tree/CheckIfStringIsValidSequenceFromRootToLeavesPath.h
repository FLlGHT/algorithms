//
// Created by fedorenko on 29.09.2022.
//

#ifndef C_ALGORITMS_CHECKIFSTRINGISVALIDSEQUENCEFROMROOTTOLEAVESPATH_H
#define C_ALGORITMS_CHECKIFSTRINGISVALIDSEQUENCEFROMROOTTOLEAVESPATH_H


#include <vector>
#include "../structures/TreeNode.h"
using namespace std;

class CheckIfStringIsValidSequenceFromRootToLeavesPath {

public:
    bool isValidSequence(TreeNode* root, vector<int>& arr) {
        return dfs(root, arr, 0);
    }

private:
    bool dfs(TreeNode* node, vector<int>& arr, int index) {
        if (node == nullptr || index >= arr.size() || node->val != arr[index])
            return false;

        if (node->left == nullptr && node->right == nullptr && index == arr.size() - 1 && arr[index] == node->val)
            return true;

        return dfs(node->left, arr, index + 1) || dfs(node->right, arr, index + 1);
    }
};


#endif //C_ALGORITMS_CHECKIFSTRINGISVALIDSEQUENCEFROMROOTTOLEAVESPATH_H

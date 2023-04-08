package tree;

import structures.TreeNode;

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
public class CountUniValueSubtrees {

    private int uniValueSubTrees = 0;

    public int countUnivalSubtrees(TreeNode root) {
        isUniValue(root, 0);
        return uniValueSubTrees;
    }

    private boolean isUniValue(TreeNode node, int value) {
        if (node == null)
            return true;

        if (!isUniValue(node.left, node.val) | !isUniValue(node.right, node.val))
            return false;

        uniValueSubTrees++;

        return node.val == value;
    }
}

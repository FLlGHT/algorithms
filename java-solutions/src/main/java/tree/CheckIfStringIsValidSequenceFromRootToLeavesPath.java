package tree;

import structures.TreeNode;

/**
 * 1430. Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
 * <p>
 * Given a binary tree where each path going from the root to any leaf form a valid sequence,
 * check if a given string is a valid sequence in such binary tree.
 * <p>
 * We get the given string from the concatenation of an array of integers arr and the concatenation of
 * all values of the nodes along a path results in a sequence in the given binary tree.
 */
public class CheckIfStringIsValidSequenceFromRootToLeavesPath {

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, arr, 0);
    }

    private boolean dfs(TreeNode node, int[] arr, int index) {
        if (node == null || index >= arr.length || node.val != arr[index])
            return false;

        if (node.left == null && node.right == null && index == arr.length - 1 && arr[index] == node.val)
            return true;

        return dfs(node.left, arr, index + 1) || dfs(node.right, arr, index + 1);
    }

}

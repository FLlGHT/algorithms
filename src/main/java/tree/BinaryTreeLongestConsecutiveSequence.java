package tree;


import structures.TreeNode;

/**
 *
 * 298. Binary Tree Longest Consecutive Sequence
 * <p>
 * Given the root of a binary tree, return the length of the longest consecutive sequence path.
 * A consecutive sequence path is a path where the values increase by one along the path.
 * Note that the path can start at any node in the tree, and you cannot go from a node to its parent in the path.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,null,3,2,4,null,null,null,5]
 * Output: 3
 * Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
 * <p>
 * Example 2:
 * <p>
 * Input: root = [2,null,3,2,null,1]
 * Output: 2
 * Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
 */
public class BinaryTreeLongestConsecutiveSequence {

    private int longest = 0;

    public int longestConsecutive(TreeNode root) {
        dfs(root, null, 0);
        return longest;
    }

    private void dfs(TreeNode node, TreeNode parent, int length) {
        if (node == null)
            return;

        length = (parent != null && node.val == parent.val + 1) ? length + 1 : 1;
        longest = Math.max(length, longest);

        dfs(node.left, node, length);
        dfs(node.right, node, length);
    }
}

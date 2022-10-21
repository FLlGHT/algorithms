package dfs;


import structures.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. Find Duplicate Subtrees
 * <p>
 * Given the root of a binary tree, return all duplicate subtrees.
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 * Two trees are duplicate if they have the same structure with the same node values.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,2,3,4,null,2,4,null,null,4]
 * Output: [[2,4],[4]]
 * <p>
 * Example 2:
 * <p>
 * Input: root = [2,1,1]
 * Output: [[1]]
 * <p>
 * Example 3:
 * <p>
 * Input: root = [2,2,2,3,null,3,null]
 * Output: [[2,3],[3]]
 */
public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, List<TreeNode>> serialized = new HashMap<>();
        serialize(root, serialized);

        return serialized.values().stream().filter(group -> group.size() > 1).map(group -> group.get(0)).toList();
    }

    private String serialize(TreeNode node, Map<String, List<TreeNode>> serialized) {
        if (node == null)
            return "";

        String serialize =
                "(" + serialize(node.left, serialized) + " " + node.val + " " + serialize(node.right, serialized) + ")";
        serialized.computeIfAbsent(serialize, param -> new ArrayList<>()).add(node);
        return serialize;
    }
}

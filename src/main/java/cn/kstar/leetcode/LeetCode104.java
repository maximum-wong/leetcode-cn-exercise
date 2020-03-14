package cn.kstar.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import cn.kstar.leetcode.data_structure.TreeNode;

/**
 * <h6>二叉树的最大深度
 * <br/>Maximum Depth of Binary Tree</h6>
 *
 * <p>给定一个二叉树，找出其最大深度。
 * <br/>Given a binary tree, find its maximum depth.</p>
 * <p>二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <br/>The maximum depth is the number of nodes along the longest path 
 * from the root node down to the farthest leaf node.</p>
 * <p><b>说明:</b> 叶子节点是指没有子节点的节点。
 * <br/><b>Note: </b> A leaf is a node with no children.</p>
 * <p><b>示例：</b>
 * <br/><b>Example:</b></p>
 * <p>给定二叉树 <code>[3,9,20,null,null,15,7]</code>，
 * <br/>Given binary tree <code>[3,9,20,null,null,15,7]</code>,</p>
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 * <p>返回它的最大深度 3 。
 * <br/>return its depth = 3.</p>
 */
public class LeetCode104 {

    /**
     * <h6>DFS法</h6>
     *
     * @param root
     * @return int
     */
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }

    /**
     * <h6>递归法</h6>
     *
     * <p>使用递归法，自顶向下地遍历到最底层，再向上遍历到，记录深度最大的分支，再返回结果</p>
     * @param root
     * @return int
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth2(root.left);
        int rightDepth = maxDepth2(root.right);
        return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
    }
}

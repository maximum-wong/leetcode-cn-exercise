package cn.kstar.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import cn.kstar.leetcode.data_structure.TreeNode;

/**
 * <h6>二叉树的最大深度</h6>
 */
public class LeetCode104 {

    /**
     * <h6>DFS法</h6>
     * @param root
     * @return
     * int
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
     * @param root
     * @return
     * int
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

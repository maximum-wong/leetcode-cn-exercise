package kstar.leetcode;

import java.util.Stack;

import kstar.leetcode.data_structure.TreeNode;

/**
 * <h6>二叉树展开为链表
 * <br/>Flatten Binary Tree to Linked List</h6>
 *
 * <p>给定一个二叉树，原地将它展开为链表。
 * <br/>Given a binary tree, flatten it to a linked list in-place.</p>
 * <p>例如，给定二叉树
 * <br/>For example, given the following tree:</p>
 * <pre>
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * </pre>
 * <p>将其展开为：
 * <br/>The flattened tree should look like:</p>
 * <pre>
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * </pre>
 */
public class LeetCode114 {

    private TreeNode prev = null;

    /**
     * <h6>递归法</h6>
     * 
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 递归地获取右边节点
        flatten(root.right);
        // 递归地获取左边节点
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    /**
     * <h6>循环法</h6>
     *
     * @param root
     */
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // 弹出左边的节点
            TreeNode currentNode = stack.pop();
            // 分别存放左右子节点
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            // 将当前节点与右边节点相连
            if (!stack.isEmpty()) {
                currentNode.right = stack.peek();
            }
            currentNode.left = null;
        }
    }
}

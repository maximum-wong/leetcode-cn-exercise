package kstar.leetcode;

import kstar.leetcode.data_structure.TreeNode;

/**
 * <h6>平衡二叉树
 * <br/>Balanced Binary Tree</h6>
 *
 * <p>给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <br/>Given a binary tree, determine if it is height-balanced.</p>
 * <p>本题中，一棵高度平衡二叉树定义为：
 * <br/>For this problem, a height-balanced binary tree is defined as:</p>
 * <blockquote>
 * <p>一个二叉树<em>每个节点&nbsp;</em>的左右两个子树的高度差的绝对值不超过1。
 * <br/>a binary tree in which the left and right subtrees of <em>every</em> node differ in height by no more than 1.</p>
 * </blockquote>
 * <p><strong>示例 1:</strong>
 * <br/><strong>Example 1:</strong></p>
 * <p>给定二叉树 <code>[3,9,20,null,null,15,7]</code>
 * <br/>Given the following tree <code>[3,9,20,null,null,15,7]</code>:</p>
 * <pre>
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * </pre>
 * <p>返回 <code>true</code> 。
 * <br/>Return <code>true</code>.<br><br>
 * <strong>示例 2:</strong></p>
 * <p>给定二叉树 <code>[1,2,2,3,3,null,null,4,4]</code></p>
 * <pre>
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * </pre>
 * <p>返回&nbsp;<code>false</code> 。</p>
 * <p>&nbsp;</p>
 */
public class LeetCode110 {

    private boolean flag = true;

    /**
     * <h6>递归法</h6>
     * 
     * <p>递归地从底往上求左右子树的高度来判断是否符合要求</p>
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        treeLength(root);
        return flag;
    }

    private int treeLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeLength(root.left);
        int right = treeLength(root.right);
        if (left - right >= 2 || right - left >= 2) {
            flag = false;
        }
        return left > right ? (left + 1) : (right + 1);
    }
}

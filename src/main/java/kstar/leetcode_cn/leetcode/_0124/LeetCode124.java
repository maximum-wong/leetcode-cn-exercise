package kstar.leetcode_cn.leetcode._0124;

import kstar.leetcode_cn.leetcode.data_structure.TreeNode;

/**
 * <h6>二叉树中的最大路径和
 * <br/>Binary Tree Maximum Path Sum</h6>
 *
 * <p>给定一个<strong>非空</strong>二叉树，返回其最大路径和。
 * <br/>Given a <strong>non-empty</strong> binary tree, find the maximum path sum.</p>
 * <p>本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径<strong>至少包含一个</strong>节点，且不一定经过根节点。
 * <br/>For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
 * The path must contain <strong>at least one</strong> node and does not need to go through the root.</p>
 * <p><strong>示例 1:</strong>
 * <br/><strong>Example 1:</strong></p>
 * <pre>
 * 输入: [1,2,3]
 * Input: [1,2,3]
 * 
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * Output: 6
 * </pre>
 * <p><strong>示例 2:</strong>
 * <br/><strong>Example 2:</strong></p>
 *  <pre>
 *  输入: [-10,9,20,null,null,15,7]
 *  Input: [-10,9,20,null,null,15,7]
 *
 *   -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 * Output: 42
 * </pre>
 */
public class LeetCode124 {

    private int maxSum;

    /**
     * <h6>后续遍历法</h6>
     *
     * <p>使用后续遍历的方式，记录左右子树经过根节点的最大值，以便计算后面的父节点；
     * <br/>不经过根节点的只记录即可。</p>
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        maxSum = 0X80000000;
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 获取左子树的最大值
        int leftVal = helper(root.left);
        int leftSum = leftVal > 0 ? leftVal : 0;
        // 获取右子树的最大值
        int rightVal = helper(root.right);
        int rightSum = rightVal > 0 ? rightVal : 0;
        // 获取当前节点路径下的最大值
        int maxVal = leftSum + rightSum + root.val;
        maxSum = maxVal > maxSum ? maxVal : maxSum;
        // 返回当前分支的最大值
        return ((leftSum > rightSum) ? leftSum : rightSum) + root.val;
    }
}

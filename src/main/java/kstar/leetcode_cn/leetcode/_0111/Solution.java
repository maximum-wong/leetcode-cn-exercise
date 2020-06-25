package kstar.leetcode_cn.leetcode._0111;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * <h6>递归法</h6>
 * <p>时间复杂度：O(n)；空间复杂度；log(n)</p>
 * <p>自顶向下递归地记录每层深度从而求出最小深度</p>
 */
public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 如果是叶子节点，直接返回深度为1
        if (root.left == null && root.right == null) {
            return 1;
        }

        // 获取左子节点的最小深度
        int minDepth = 0X7FFFFFFF;
        if (root.left != null) {
            int leftDepth = minDepth(root.left);
            minDepth = leftDepth > minDepth ? minDepth : leftDepth;
        }
        // 获取右子节点的最小深度
        if (root.right != null) {
            int rightDepth = minDepth(root.right);
            minDepth = rightDepth > minDepth ? minDepth : rightDepth;
        }
        return minDepth + 1;
    }
}

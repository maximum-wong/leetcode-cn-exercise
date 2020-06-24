package kstar.leetcode._0112;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * <h6>递归法</h6>
 * <p>遍历整棵树，如果当前节点不是叶子节点，递归调用<code>hasPathSum</code>函数，其中sum值减去当前节点的值；
 * 如果当前节点是叶子节点，检查sum值是否为0。</p>
 */
public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        sum -= root.val;

        if (root.left == null && root.right == null) {
            return sum == 0;
        }

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

}

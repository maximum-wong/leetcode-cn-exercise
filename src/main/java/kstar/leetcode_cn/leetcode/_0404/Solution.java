package kstar.leetcode_cn.leetcode._0404;

/**
 * <h6>深度优先算法</h6>
 * <p>自定顶下递归求左叶子节点的值</p>
 */
public class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    private int dfs(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right!=null && !isLeafNode(node.right)) {
            ans+=dfs(node.right);
        }
        return ans;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

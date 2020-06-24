package kstar.leetcode._0112;

import java.util.LinkedList;

/**
 * <h6>循环法（层级遍历）</h6>
 */
public class Solution2 {

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<Integer> sumStack = new LinkedList<>();
        nodeStack.add(root);
        sumStack.add(sum - root.val);

        TreeNode node;
        int currentSum;
        while (!nodeStack.isEmpty()) {
            node = nodeStack.pollLast();
            currentSum = sumStack.pollLast();

            if (node.left == null && node.right == null && currentSum == 0) {
                return true;
            }

            if (node.right != null) {
                nodeStack.add(node.right);
                sumStack.add(currentSum - node.right.val);
            }

            if (node.left != null) {
                nodeStack.add(node.left);
                sumStack.add(currentSum - node.left.val);
            }
        }
        return false;
    }
}

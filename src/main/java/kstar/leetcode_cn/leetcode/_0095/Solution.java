package kstar.leetcode_cn.leetcode._0095;

import java.util.ArrayList;
import java.util.List;

/**
 * <h6>递归法</h6>
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = generate(start, i - 1);
            List<TreeNode> rightNodes = generate(i + 1, end);
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode current = new TreeNode(i);
                    current.left = left;
                    current.right = right;
                    trees.add(current);
                }
            }
        }
        return trees;
    }
}

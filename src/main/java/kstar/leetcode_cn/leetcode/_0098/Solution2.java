package kstar.leetcode_cn.leetcode._0098;

import java.util.Stack;

/**
 * <h6>中序遍历法</h6>
 */
public class Solution2 {

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long flag = Long.MIN_VALUE;

        // 中序遍历，并更新flag值
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= flag) {
                return false;
            }
            flag = root.val;
            root = root.right;
        }
        return true;
    }

}

package kstar.leetcode_cn.leetcode._0094;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 当前节点
        TreeNode node = root;
        while (node!=null || !stack.isEmpty()) {
            // 把左子树节点放入栈中
            while (node!=null) {
                stack.push(node);
                node = node.left;
            }
            // 取出栈顶元素，把它的val放入到结果集中
            node = stack.pop();
            res.add(node.val);
            // 当前节点位右子树节点
            node = node.right;
        }
        return res;
    }
}

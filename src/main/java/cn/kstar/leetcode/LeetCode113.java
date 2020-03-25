package cn.kstar.leetcode;

import java.util.LinkedList;
import java.util.List;

import cn.kstar.leetcode.data_structure.TreeNode;

/**
 * <h6>路径总和II
 * <br/>Path Sum II</h6>
 *
 * <p>给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <br/>Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.</p>
 * <p><b>说明:</b> 叶子节点是指没有子节点的节点。
 * <br/><b>Note:</b> A leaf is a node with no children.</p>
 * <p><b>示例:</b>
 * <br/><b>Example:</b>
 * <br/>给定如下二叉树，以及目标和 sum = 22，
 * <br/>Given the below binary tree and sum = 22,</p>
 * <pre>
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * </pre>
 * <p>返回:
 * <br/>Return:</p>
 * <pre>
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * </pre>
 */
public class LeetCode113 {

    /**
     * <h6>回溯法</h6>
     * 
     * <p>使用回溯法，分别向左右子树向下递归求值，把获得的值放在栈中，遇到符合要求结果的值，放在返回结果中</p>
     * @param  root
     * @param  sum
     * @return List<List<Integer>>
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        helper(root, sum, res, new LinkedList<>());
        return res;
    }

    /**
     * <h6>回溯地获取结果</h6>
     * 
     * @param root
     * @param sum
     * @param res
     * @param current
     */
    private void helper(TreeNode root, int sum, List<List<Integer>> res, LinkedList<Integer> current) {
        if (root == null) {
            return;
        }
        current.add(root.val);

        // 找到符合条件的叶子节点
        if ((root.left == null) && (root.right == null) && (sum == root.val)) {
            // 把栈中的结果放在结果集中
            res.add(new LinkedList<>(current));
            // 回溯重置状态
            current.remove(current.size() - 1);
            return;
        }

        // 左子树向下递归
        helper(root.left, sum - root.val, res, current);
        // 右子树向下递归
        helper(root.right, sum - root.val, res, current);

        // 回溯重置状态
        current.remove(current.size() - 1);
    }
}

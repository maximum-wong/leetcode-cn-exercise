package kstar.leetcode_cn.leetcode._0107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import kstar.leetcode_cn.leetcode.data_structure.TreeNode;

/**
 * <p>二叉树的层次遍历 II
 * <br/>Binary Tree Level Order Traversal II</p>
 *
 * <p>给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <br/>Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).</p>
 * <p>例如：
 * <br/>For example:
 * <br/>给定二叉树 <code>[3,9,20,null,null,15,7]</code>,
 * <br/>Given binary tree <code>[3,9,20,null,null,15,7]</code>,</p>
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 * <p>返回其自底向上的层次遍历为：
 * <br/>return its bottom-up level order traversal as:</p>
 * <pre>
 *   [
 *      [15,7],
 *      [9,20],
 *      [3]
 *   ]
 * </pre>
 */
public class LeetCode107 {

    /**
     * <h6>DFS法</h6>
     *
     * <p>使用DFS法，获取每层的元素，每次把每层元素都要放在结果集的头部才能返回自底向上的遍历结果</p>
     * @param  root
     * @return List<List<Integer>>
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            while (size > 0) {
                TreeNode head = queue.poll();
                list.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
                size--;
            }
            // 把每层元素的集合放在结果集的头部
            result.add(0, list);
        }
        return result;
    }

    /**
     * <h6>递归法</h6>
     *
     * <p>使用递归法，自底向上地接收每层元素返回结果集</p>
     * @param root
     * @return List<List<Integer>>
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>>res = new LinkedList<>();
        if (root ==null) {
            return res;
        }
        helper(root, res, 0);
        return res;
    }

    /**
     * <h6>递归地向结果集中添加每层元素</h6>
     * 
     * @param root
     * @param res
     * @param depth
     */
    public void helper(TreeNode root, List<List<Integer>> res, int depth) {
        if (root == null) {
            return;
        }

        // 向下递归时，如果结果集中的元素个数跟方法栈的深度相同时，就需要在结果集头部添加新的集合来接收当前层的元素
        if (depth == res.size()) {
            res.add(0, new LinkedList<>());
        }
        // 获取接收当前层的集合
        List<Integer> currentList = res.get(res.size() - depth - 1);
        // 左子树向下递归
        helper(root.left, res, depth + 1);
        // 右子树向下递归
        helper(root.right, res, depth + 1);
        // 添加当前节点的值
        currentList.add(root.val);
    }
}

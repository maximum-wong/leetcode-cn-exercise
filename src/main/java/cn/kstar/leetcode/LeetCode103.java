package cn.kstar.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import cn.kstar.leetcode.data_structure.TreeNode;

/**
 * <h6>二叉树的锯齿形层次遍历
 * <br/>Binary Tree Zigzag Level Order Traversal</h6>
 *
 * <p>给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <br/>Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).</p>
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
 * <p>返回锯齿形层次遍历如下：
 * <br/>return its zigzag level order traversal as:</p>
 * <pre>
 *   [
 *     [3],
 *     [20,9],
 *     [15,7]
 *   ]
 * </pre>
 */
public class LeetCode103 {

    /**
     * <h6>DFS法</h6>
     *
     * <p>使用DFS法，用一个变量来记录当前遍历的层数，偶数层正序放入元素，奇数层倒序放入元素。</p>
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        // 用树的深度作为每层遍历顺序的标记
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                int val = node.val;
                if ((depth & 1) == 1) {
                    list.add(0, val);
                } else {
                    list.add(val);
                }
                TreeNode leftNode = node.left;
                if (leftNode != null) {
                    queue.add(leftNode);
                }
                TreeNode rightNode = node.right;
                if (rightNode != null) {
                    queue.add(rightNode);
                }
                size--;
            }
            res.add(list);
            depth++;
        }

        return res;
    }

    /**
     * <h6>递归法</h6>
     *
     * <p>使用递归法，自顶向下地递归每一层元素，用一个变量来记录当前遍历的层数，偶数层正序放入元素，奇数层倒序放入元素。</p>
     * @param root
     * @return List<List<Integer>>
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        helper(res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        // 如果当前层数超过结果集中元素的个数，说明是首次递归到该层，需增加一个集合元素来存放该层的遍历结果
        if (res.size() <= depth) {
            res.add(new LinkedList<>());
        }

        if ((depth & 1) == 1) {
            res.get(depth).add(0, root.val);
        } else {
            res.get(depth).add(root.val);
        }

        // 继续向下遍历左右两边的子节点
        helper(res, root.left, depth + 1);
        helper(res, root.right, depth + 1);
    }

}

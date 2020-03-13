package cn.kstar.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import cn.kstar.leetcode.data_structure.TreeNode;

/**
 * <h6>二叉树的锯齿形层次遍历</h6>
 *
 * <p></p>
 */
public class LeetCode103 {

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

        if (res.size() <= depth) {
            res.add(new LinkedList<>());
        }

        if ((depth & 1) == 1) {
            res.get(depth).add(0, root.val);
        } else {
            res.get(depth).add(root.val);
        }

        helper(res, root.left, depth + 1);
        helper(res, root.right, depth + 1);
    }
    
}

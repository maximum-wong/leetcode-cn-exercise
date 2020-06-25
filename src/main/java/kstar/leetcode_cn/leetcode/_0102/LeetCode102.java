package kstar.leetcode_cn.leetcode._0102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import kstar.leetcode_cn.leetcode.data_structure.TreeNode;

/**
 * <h6>二叉树的层次遍历
 * <br/>Binary Tree Level Order Traversal</h6>
 *
 * <p>给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <br/>Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).</p>
 * <p>例如:
 * <br/>For example:
 * <br/>给定二叉树: [3,9,20,null,null,15,7],
 * <br/>Given binary tree [3,9,20,null,null,15,7],</p>
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 * <p>返回其层次遍历结果：
 * <br/>return its level order traversal as:</p>
 * <pre>
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 *   ]
 * </pre>
 */
public class LeetCode102 {

    /**
     * <h6>双队列法</h6>
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }

        List<List<Integer>> result = new ArrayList<>();
        // 保存节点的队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 保存当前层级的节点的队列
        Queue<TreeNode> currentLevelNodes = new LinkedList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            currentLevelNodes.offer(node);

            if (queue.isEmpty()) {
                List<Integer> list = new ArrayList<>(currentLevelNodes.size());
                while (!currentLevelNodes.isEmpty()) {
                    TreeNode currentNode = currentLevelNodes.poll();
                    list.add(currentNode.val);
                    if (currentNode.left != null) {
                        queue.offer(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.offer(currentNode.right);
                    }
                }
                result.add(list);
            }
        }

        return result;
    }
    
    /**
     * <h6>单队列法</h6>
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            result.add(list);
        }
        return result;
    }
}

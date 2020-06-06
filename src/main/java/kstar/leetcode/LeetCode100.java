package kstar.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import kstar.leetcode.data_structure.TreeNode;

/**
 * <h6>相同的树</h6>
 *
 * <p>给定两个二叉树，编写一个函数来检验它们是否相同。
 * <br/>Given two binary trees, write a function to check if they are the same or not.</p>
 * <p>如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <br/>Two binary trees are considered the same if they are structurally identical and the nodes have the same value.</p>
 * <p><b>Example 1: </b></p>
 * <pre>
 * <b>Input: </b>      1         1
 *             / \       / \
 *            2   3     2   3
 *
 *           [1,2,3],   [1,2,3]
 * <b>Output: </b>true
 * </pre>
 * <p><b>Example 2: </b></p>
 * <pre>
 * <b>Input: </b>      1         1
 *             /          \
 *            2             2
 *
 *           [1,2],    [1,null,2]
 * <b>Output: </b>false
 * </pre>
 * <p><b>Example 3: </b></p>
 * <pre>
 * <b>Input: </b>      1         1
 *             / \       / \
 *            2   1     1   2
 *
 *           [1,2,1],   [1,1,2]
 * <b>Output: </b>false
 * </pre>
 */
public class LeetCode100 {

    /**
     * <h6>递归法</h6>
     * 
     * <p> 使用递归法，自顶向下，比较相应位置左右子树节点的值</p>
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null) && (q == null)) {
            return true;
        } else if ((p == null) || (q == null)) {
            return false;
        }

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
    
    /**
     * <h6>BFS法</h6>
     * 
     * <p>使用BFS法，把两棵树的相应位置的节点放入队列，取出来进行比较</p>
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if ((p == null) && (q == null)) {
            return true;
        } else if ((p == null) || (q == null)) {
            return false;
        }

        // 创建一个队列，把左右根节点放入队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            // 取出左右节点进行比较
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            } else if (left == null || right == null) {
                return false;
            } else if (left.val != right.val) {
                return false;
            }
            // 左子树入队列
            queue.add(left.left);
            queue.add(right.left);
            // 右子树入队列
            queue.add(left.right);
            queue.add(right.right);
        }

        return true;
    }

    /**
     * <h6>DFS法</h6>
     *
     * <p>使用DFS法，把两棵树的相应位置的节点放栈中，取出来进行比较</p>
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree3(TreeNode p, TreeNode q) {
        if ((p == null) && (q == null)) {
            return true;
        } else if ((p == null) || (q == null)) {
            return false;
        }

        // 创建一个栈，把左右根节点放入队列
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);

        while (!stack.isEmpty()) {
            // 取出左右节点进行比较
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left == null && right == null) {
                continue;
            } else if (left == null || right == null) {
                return false;
            } else if (left.val != right.val) {
                return false;
            }
            // 左子树入栈
            stack.push(left.left);
            stack.push(right.left);
            // 右子树入栈
            stack.push(left.right);
            stack.push(right.right);
        }

        return true;
    }
}

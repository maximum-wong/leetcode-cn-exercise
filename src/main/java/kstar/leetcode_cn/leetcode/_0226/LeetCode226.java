package kstar.leetcode_cn.leetcode._0226;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import kstar.leetcode_cn.leetcode.data_structure.TreeNode;

/**
 * <h6>翻转二叉树
 * <br/>Invert Binary Tree</h6>
 *
 * <p>翻转一棵二叉树。
 * <br/>Invert a binary tree.</p>
 * <p><b>Example: </b></p>
 * <p>Input: </p>
 * <pre>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * </pre>
 * <p>Output: </p>
 * <pre>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * </pre>
 * <p><strong>备注:</strong>
 * <br/><strong>Trivia:</strong>
 * <br>这个问题是受到 <a href="https://twitter.com/mxcl">Max Howell </a>的 
 * <a href="https://twitter.com/mxcl/status/608682016205344768">原问题</a> 启发的 ：
 * <br/>This problem was inspired by <a href="https://twitter.com/mxcl/status/608682016205344768">this original tweet</a> 
 * by <a href="https://twitter.com/mxcl">Max Howell</a>:</p>
 * <blockquote>谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。</blockquote>
 * <blockquote>Google: 90% of our engineers use the software you wrote (Homebrew), 
 * but you can’t invert a binary tree on a whiteboard so f*** off.</blockquote>
 */
public class LeetCode226 {

    /**
     * <h6>递归法</h6>
     * 
     * <p>时间复杂度：O(n)；空间复杂度：O(n)</p>
     * <p>求解步骤：</p>
     * <ul>
     * <li>翻转根节点的左子树（递归调用当前函数）</li>
     * <li>翻转根节点的右子树（递归调用当前函数）</li>
     * <li>交换根节点的左子节点和右子节点</li>
     * </ul>
     * @param  root
     * @return TreeNode
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 翻转左子树
        invertTree(root.left);
        // 翻转右子树
        invertTree(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }

    /**
     * <h6>迭代法-队列</h6>
     *
     * @param  root
     * @return TreeNode
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 创建一个队列，把根节点放入到队列中
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 取出元素
            TreeNode currentNode = queue.poll();
            // 交换左右子树节点的位置
            TreeNode tmp = currentNode.right;
            currentNode.right = currentNode.left;
            currentNode.left = tmp;

            // 左右子树节点入队列
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }

        return root;
    }

    /**
     * <h6>迭代法-栈</h6>
     * 
     * @param  root
     * @return TreeNode
     */
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 创建一个栈，把根节点放入栈中
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            // 获取栈中最后一个元素
            TreeNode currentNode = stack.lastElement();
            // 弹出栈顶元素
            stack.pop();

            // 交换左右子树节点的位置
            TreeNode tmp = currentNode.right;
            currentNode.right = currentNode.left;
            currentNode.left = tmp;

            // 左右子树节点入栈
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
        }

        return root;
    }
}

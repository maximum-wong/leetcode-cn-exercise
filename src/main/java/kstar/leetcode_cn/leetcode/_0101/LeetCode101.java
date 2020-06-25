package kstar.leetcode_cn.leetcode._0101;

import java.util.LinkedList;
import java.util.Queue;

import kstar.leetcode_cn.leetcode.data_structure.TreeNode;

/**
 * <h6>对称二叉树
 * <br/>Symmetric Tree</h6>
 *
 * <p>给定一个二叉树，检查它是否是镜像对称的。
 * <br/>Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).</p>
 * <p>例如，二叉树 <code>[1,2,2,3,4,4,3]</code> 是对称的。
 * <br/>For example, this binary tree <code>[1,2,2,3,4,4,3]</code> is symmetric:</p>
 * <pre>
 *       1
 *      / \
 *     2   2
 *    / \ / \
 *   3  4 4  3
 * </pre>
 * <p>但是下面这个 <code>[1,2,2,null,3,null,3]</code> 则不是镜像对称的:
 * <br/>But the following <code>[1,2,2,null,3,null,3]</code> is not:</p>
 * <pre>
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * </pre>
 * <p><b>说明:</b>
 * <br/><p>Note:</p></p>
 * <p>如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * <br/>Bonus points if you could solve it both recursively and iteratively.</p>
 */
public class LeetCode101 {

    /**
     * <h6>递归法</h6>
     * 
     * <p>使用递归法，自顶向下地比较每层镜像对称位置的节点值是否相等</p>
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        if (left.val != right.val) {
            return false;
        }

        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    /**
     * <h6>BFS发</h6>
     * 
     * <p>使用BFS法，把每层镜像位置对称的节点放入队列，再取出一对镜像位置对称的节点检查它们的值是否相等。</p>
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 创建一个队列用来存放每层的节点
        Queue<TreeNode> queue = new LinkedList<>();
        // 分别存入左子树的根节点和右子树的根节点
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            // 取出每层镜像位置对称的节点
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            // 叶子节点
            if (left == null && right == null) {
                continue;
            }
            // 其中一个是null
            if (left == null || right == null) {
                return false;
            }
            // 两节点值不相等
            if (left.val != right.val) {
                return false;
            }

            // 分别添加下一层镜像位置对称的节点
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }
}

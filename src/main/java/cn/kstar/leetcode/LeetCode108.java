package cn.kstar.leetcode;

import cn.kstar.leetcode.data_structure.TreeNode;

/**
 * <h6>将有序数组转换为二叉搜索树</h6>
 *
 * <p>将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <br/>Given an array where elements are sorted in ascending order, convert it to a height balanced BST.</p>
 * <p>本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <br/>For this problem, a height-balanced binary tree is defined as a binary tree in 
 * which the depth of the two subtrees of every node never differ by more than 1.</p>
 * <p><b>示例:</b>
 * <b>Example:</b></p>
 * <pre>
 * 给定有序数组: [-10,-3,0,5,9],
 * Given the sorted array: [-10,-3,0,5,9],
 * 
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * </pre>
 */
public class LeetCode108 {

    /**
     * <h6>递归法</h6>
     * 
     * <p>使用递归法，自顶向下地构造树，先构造父节点，再分别构造左右子树</p>
     * @param nums
     * @return TreeNode
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    /**
     * 递归地构造二叉树
     * 
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private TreeNode helper(int[] nums, int left, int right) {
        
        // 遍历到空节点
        if (left > right) {
            return null;
        }

        // 遍历到子节点
        if (left == right) {
            return new TreeNode(nums[left]);
        }

        // 构造中间的父节点
        int mid = (left + right) / 2;
        TreeNode currentNode = new TreeNode(nums[mid]);
        // 递归地构造左子树
        currentNode.left = helper(nums, left, mid - 1);
        // 递归地构造右子树
        currentNode.right = helper(nums, mid + 1, right);
        return currentNode;
    }
}

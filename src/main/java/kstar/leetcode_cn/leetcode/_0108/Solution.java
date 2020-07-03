package kstar.leetcode_cn.leetcode._0108;

import kstar.leetcode_cn.leetcode.data_structure.TreeNode;

/**
 * <h6>递归法</h6>
 * 
 * <p>使用递归法，自顶向下地构造树，先构造父节点，再分别构造左右子树</p>
 */
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    /**
     * <h6>递归地构造二叉树</h6>
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

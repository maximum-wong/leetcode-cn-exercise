package cn.kstar.leetcode;

import cn.kstar.leetcode.data_structure.TreeNode;

public class LeetCode106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int postEnd, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        // 获取根节点的值
        int currentVal = postorder[postEnd];
        TreeNode currentNode = new TreeNode(currentVal);

        // 获取根节点的值在中序遍历结果中的位置
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == currentVal) {
                inIndex = i;
            }
        }

        // 递归地构建左子树
        TreeNode left = helper(inorder, postorder, postEnd - (inEnd - inIndex) - 1, inStart, inIndex - 1);
        // 递归地构建右子树
        TreeNode right = helper(inorder, postorder, postEnd - 1, inIndex + 1, inEnd);
        currentNode.left = left;
        currentNode.right = right;
        return currentNode;
    }
    
}

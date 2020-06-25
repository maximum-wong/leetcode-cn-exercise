package kstar.leetcode_cn.leetcode._0105;

import kstar.leetcode_cn.leetcode.data_structure.TreeNode;

/**
 * <h6>从前序与中序遍历序列构造二叉树
 * <br/>Construct Binary Tree from Preorder and Inorder Traversal</h6>
 *
 * <p>根据一棵树的前序遍历与中序遍历构造二叉树。
 * <br/>Given preorder and inorder traversal of a tree, construct the binary tree.</p>
 * <p><b>注意:</b>
 * <br/><b>Note:</b>
 * <br/>你可以假设树中没有重复的元素。
 * <br/>You may assume that duplicates do not exist in the tree.</p>
 * <p>例如，给出
 * <br/>For example, given</p>
 * <pre>
 * 前序遍历 preorder = [3,9,20,15,7]
 * preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * inorder = [9,3,15,20,7]
 * </pre>
 * <p>返回如下的二叉树：
 * <br/>Return the following binary tree:</p>
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 */
public class LeetCode105 {

    /**
     * <h6>递归法</h6>
     *
     * <p>通过前序遍历找到根节点的位置，获取根节点，再把中序遍历结果集一分为二，递归地获取左子树和右子树</p>
     * @param preorder
     * @param inorder
     * @return TreeNode
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length-1);
    }
    
    /**
     * <h6>递归地构建二叉树</h6>
     * 
     * @param preorder
     * @param inorder
     * @param preStart
     * @param inStart
     * @param inEnd
     * @return TreeNode
     */
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        // 获取根节点的值
        int currentVal = preorder[preStart];
        TreeNode current = new TreeNode(currentVal);

        // 获取根节点的值在中序遍历结果中的位置
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == currentVal) {
                inIndex = i;
            }
        }

        // 递归地构建左子树
        TreeNode left = helper(preorder, inorder, preStart + 1, inStart, inIndex - 1);
        // 递归地构建右子树
        TreeNode right = helper(preorder, inorder, preStart + inIndex - inStart + 1, inIndex + 1, inEnd);
        current.left = left;
        current.right = right;
        return current;
    }
}

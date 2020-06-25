package kstar.leetcode_cn.leetcode._0106;

import kstar.leetcode_cn.leetcode.data_structure.TreeNode;

/**
 * <h6>从中序与后序遍历序列构造二叉树
 * <br/>Construct Binary Tree from Inorder and Postorder Traversal</h6>
 *
 * <p>根据一棵树的中序遍历与后序遍历构造二叉树。
 * <br/>Given inorder and postorder traversal of a tree, construct the binary tree.</p>
 * <p><b>注意:</b>
 * <br/><b>Note:</b>
 * <br/>你可以假设树中没有重复的元素。
 * <br/>You may assume that duplicates do not exist in the tree.</p>
 * <p>例如，给出
 * <br/>For example, given</p>
 * <pre>
 * 中序遍历 inorder = [9,3,15,20,7]
 * inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * postorder = [9,15,7,20,3]
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
public class LeetCode106 {

    /**
     * <h6>递归法</h6>
     *
     * <p>通过后序遍历找到根节点的位置，获取根节点，再把中序遍历结果集一分为二，递归地获取左子树和右子树</p>
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * <h6>递归地构建二叉树</h6>
     * 
     * @param inorder
     * @param postorder
     * @param postEnd
     * @param inStart
     * @param inEnd
     * @return TreeNode
     */
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

package cn.kstar.leetcode;

import cn.kstar.leetcode.data_structure.ListNode;
import cn.kstar.leetcode.data_structure.TreeNode;

/**
 * <h6>有序链表转换二叉搜索树
 * <br/>Convert Sorted List to Binary Search Tree</h6>
 *
 * <p>给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <br/>Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.</p>
 * <p>本题中，一个高度平衡二叉树是指一个二叉树<em>每个节点</em> 的左右两个子树的高度差的绝对值不超过 1。
 * <br/>For this problem, a height-balanced binary tree is defined as a binary tree in which
 *  the depth of the two subtrees of every node never differ by more than 1.</p>
 * <p><b>示例:</b>
 * <br/><b>Example:</b></p>
 * <pre>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * </pre>
 */
public class LeetCode109 {

    /**
     * <h6>递归法</h6>
     * 
     * <p>使用递归法，自顶向下地构造树，通过快慢指针法找到中间节点，然后先构造父节点，再分别构造左右子树</p>
     * @param  head
     * @return TreeNode
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return helper(head, null);
    }

    /**
     * <h6>递归地构建树</h6>
     * 
     * @param head
     * @param tail
     * @return TreeNode
     */
    private TreeNode helper(ListNode head, ListNode tail) {
        // 遍历到空节点
        if (head == null || head == tail) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // 使用快慢指针获取中间节点
        while (fast.next != tail && fast.next.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 构造根节点
        TreeNode currentNode = new TreeNode(slow.val);
        // 递归地构造左子树
        currentNode.left = helper(head, slow);
        // 递归地构造右子树
        currentNode.right = helper(slow.next, tail);
        return currentNode;
    }

    /**
     * <h6>BST的中序遍历法</h6>
     *
     * <p> 利用BST中序遍历是升序的性质</p>
     * 
     * @param head
     * @return
     */
    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null) {
            return null;
        }

        int size = 0;
        node = head;
        ListNode runner = head;

        // 获取节点个数
        while (runner != null) {
            runner = runner.next;
            size++;
        }

        return inorderHelper(0, size - 1);
    }

    private ListNode node;

    /**
     * <h6>使用中序遍历构造树</h6>
     * 
     * @param start
     * @param end
     * @return
     */
    private TreeNode inorderHelper(int start, int end) {
        if (start > end)
            return null;

        // 划分左右子树
        int mid = start + (end - start) / 2;
        TreeNode left = inorderHelper(start, mid - 1);
        // 中序遍历
        TreeNode treeNode = new TreeNode(node.val);
        treeNode.left = left;
        node = node.next;
        TreeNode right = inorderHelper(mid + 1, end);
        treeNode.right = right;
        return treeNode;
    }

}

package kstar.leetcode;

import kstar.leetcode.data_structure.ListNode;

/**
 * <h6>两两交换链表中的节点</h6>
 *
 * <p>给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <br/>示例:给定 1->2->3->4, 你应该返回 2->1->4->3.说明:你的算法只能使用常数的额外空间。
 * <br/>你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class LeetCode24 {

    /**
     * <h6>递归法</h6>
     * 
     * <p>两两合并节点，头结点的两个节点合并后，剩下的又可以转化为两两合并的子问题，所以递归求解即可。</p>
     * @param head
     * @return ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // 处理边界条件
        if (head == null || head.next == null) {
            return head;
        }
        // 左指针
        ListNode left = head;
        // 右指针
        ListNode right = head.next;
        // 左指针对应的元素指向用递归法处理的下一节点的结果
        left.next = swapPairs(right.next);
        // 右指针对应的元素指向左指针对应的元素
        right.next = left;
        return right;

    }
}

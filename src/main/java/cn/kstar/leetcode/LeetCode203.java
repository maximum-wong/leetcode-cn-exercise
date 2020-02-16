package cn.kstar.leetcode;

import cn.kstar.leetcode.data_structure.ListNode;

/**
 * <h6>移除链表的元素
 * <br/>Remove Linked List Elements</h6>
 * 
 * <p>删除链表中等于给定值 val 的所有节点。
 * <br/>Remove all elements from a linked list of integers that have value val.</p>
 * <pre><b>Examples: </b>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * </pre>
 */
public class LeetCode203 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = head;
        ListNode prev = dummy;
        ListNode next = null;

        while (current != null) {
            if (current.val == val) {
                next = current.next;
                prev.next = next;
                current = next;
            } else {
                prev = current;
                current = current.next;
            }
        }

        return dummy.next;
    }
}

package kstar.leetcode_cn.leetcode._0203;

import kstar.leetcode_cn.leetcode.data_structure.ListNode;

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

        // 添加虚拟头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 当前指针
        ListNode current = head;
        // 前指针
        ListNode prev = dummy;
        // 后指针
        ListNode next = null;

        while (current != null) {
            // 删除等于目标值的节点
            if (current.val == val) {
                next = current.next;
                prev.next = next;
                current = next;
            } else {
                // 向后移动前指针和当前指针
                prev = current;
                current = current.next;
            }
        }

        return dummy.next;
    }
}

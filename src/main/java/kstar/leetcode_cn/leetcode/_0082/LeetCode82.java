package kstar.leetcode_cn.leetcode._0082;

import kstar.leetcode_cn.leetcode.data_structure.ListNode;

/**
 * <h6>删除排序链表中的重复元素 II</h6>
 *
 * <p>给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复出现的数字。</p>
 * <pre><b>Examples: </b>
 * Input: 1->2->3->3->4->4->5; Output: 1->2->5
 * 
 * Input: 1->1->1->2->3; Output: 2->3
 * </pre>
 */
public class LeetCode82 {

    /**
     * <h6>双指针法<h6>
     * 
     * <p>使用双指针法，当没有遇到重复节点时，前指针和当前指针都向前移动；
     * <br/>当遇到重复节点时，前指针不移动，当前指针继续移动，直到当前指针指向的下一个元素不是重复元素为止，
     * <br/>就进行删除链表重复节点的操作，即前指针指向当前指针指向的下一个节点。</p>
     * @param  head
     * @return ListNode
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        // 新增假头节点，供连接使用
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        // 前指针
        ListNode previous = fakeHead;
        // 当前指针
        ListNode current = head;

        while (current != null) {
            // 当前指针与下一个节点的值相同时，当前指针继续向前移动
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
            }
            // 前指针的next指向当前指针时，前指针继续向前移动
            if (previous.next == current) {
                previous = previous.next;
            } else { // 前指针的next不指向当前指针时，前指针的next指向当前指针的next，即删除中间重复的元素
                previous.next = current.next;
            }
            current = current.next;
        }

        return fakeHead.next;
    }
}

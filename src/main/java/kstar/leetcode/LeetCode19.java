package kstar.leetcode;

import kstar.leetcode.data_structure.ListNode;

/**
 * <h6>删除链表的倒数第N个节点</h6>
 * 
 * <p>给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <br/>示例：给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <br/>当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <br/>说明：给定的 n 保证是有效的。</p>
 *
 */
public class LeetCode19 {

    /**
     * <h6>快慢指针法</h6>
     * 
     * <p>链表的题目基本上都是优先考虑双指针（快慢指针）。
     * <br/>快指针先走N步，然后两个指针同步进行移动，直到快指针移到链表末尾，慢指针移除所指着的节点即可。</p>
     * 
     * @param  head
     * @param  n
     * @return ListNode
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        // 快指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 处理特殊情况，n大小恰好是与链表长度相同，直接移除头节点，返回结果
        if (fast == null) {
            head = head.next;
            return head;
        }
        // 快慢指针同时移动
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 移除慢指针所指的元素
        slow.next = slow.next.next;
        return head;
    }
}

package cn.kstar.leetcode;

import cn.kstar.leetcode.data_structure.ListNode;

/**
 * <h6>反转链表 II
 * <br/>Reverse Linked List II</h6>
 *
 * <p>反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <br/><b>说明：</b>1 ≤ m ≤ n ≤ 链表长度。</p>
 * <pre><b>Examples: </b>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4; Output: 1->4->3->2->5->NULL
 * </pre>
 */
public class LeetCode92 {

    /**
     * <p><b>解题思路：</b>
     * <br/>添加虚拟头节点，并找到带反转的区间，记录前驱节点、后驱节点、开始节点和结束节点；
     * <br/>然后在反转区间内进行反转操作，获取操作后的子链表，前驱节点与子链表的头节点相连，
     * <br/>子链表的尾节点与后驱节点相连；最后返回虚拟头节点指向的next的链表。</p>
     *
     * @param  head
     * @param  m
     * @param  n
     * @return ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        // 添加虚拟头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 前驱节点
        ListNode predecessor = dummy;
        // 后继节点
        ListNode successor;
        // 反转区间的开始节点
        ListNode start = head;
        // 反转区间的结束节点
        ListNode end = head;

        // 寻找开始节点和前驱节点
        for (int i = 1; i < m; i++) {
            predecessor = predecessor.next;
            start = start.next;
            end = end.next;
        }
        // 寻找结束节点
        for (int i = m; i < n; i++) {
            end = end.next;
        }
        // 获取后继节点
        successor = end.next;

        // 反转区间最后一个节点与原链断开连接
        end.next = null;
        // 前驱节点与反转后的链表头节点相连
        predecessor.next = reverseList(start);
        // 反转后开始节点变成尾节点与后继节点相连
        start.next = successor;

        return dummy.next;
    }

    /**
     * <h6>反转链表</h6>
     *
     * @param  head
     * @return ListNode
     */
    private ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode previous = null;
        ListNode current = head;
        ListNode nextTemp = null;
        while (current != null) {
            nextTemp = current.next;
            current.next = previous;
            previous = current;
            current = nextTemp;
        }
        return previous;
    }
}

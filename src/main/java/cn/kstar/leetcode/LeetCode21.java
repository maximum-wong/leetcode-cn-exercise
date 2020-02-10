package cn.kstar.leetcode;

import cn.kstar.leetcode.data_structure.ListNode;

/**
 * <h6>合并两个有序链表</h6>
 *
 * <p>将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。</p>
 * <pre><b>Examples: </b>
 * Input: 1->2->4, 1->3->4; Output: 1->1->2->3->4->4
 * </pre>
 */
public class LeetCode21 {

    /**
     * <h6>循环法</h6>
     *
     * @param  l1
     * @param  l2
     * @return ListNode
     */
    public ListNode mergeTwolists(ListNode l1, ListNode l2) {
        // 创建head节点和current指针
        ListNode head = new ListNode(-1);
        ListNode current = head;

        // 遍历两个链表，将较小值的节点连接到current节点之后
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // 判断哪个链表不为空，若不为空，则直接连接到current节点后
        current.next = (l1 != null) ? l1 : l2;

        return head.next;
    }

    /**
     * <h6>递归法</h6>
     *
     * @param  l1
     * @param  l2
     * @return ListNode
     */
    public ListNode mergeTwolists2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        
        if (l1 == null) {
            return l2;
        }
        
        if (l2 == null) {
            return l1;
        }
        
        // 链表标志指针
        ListNode result;
        // 合并较小元素，移动标志指针，递归进行
        if (l1.val <= l2.val) {
            result = l1;
            l1 = l1.next;
            result.next = mergeTwolists2(l1, l2);
        } else {
            result = l2;
            l2 = l2.next;
            result.next = mergeTwolists2(l1, l2);
        }
        return result;
    }
}

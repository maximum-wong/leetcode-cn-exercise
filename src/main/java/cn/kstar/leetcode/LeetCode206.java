package cn.kstar.leetcode;

import cn.kstar.leetcode.data_structure.ListNode;

/**
 * <h6>反转链表
 * <br/>Reverse Linked List</h6>
 *
 * <p>反转一个单链表。
 * <br/><b>进阶：</b>你可以迭代或递归地反转链表。你能否用两种方法解决这道题？</p>
 * <pre><b>Examples: </b>
 * Input: 1->2->3->4->5->NULL; Output: 5->4->3->2->1->NULL
 * </pre>
 */
public class LeetCode206 {

    /**
     * <h6>循环法</h6>
     *
     * <p>在翻转过程中，保存下一个节点的引用，让当前节点的next指向上一个节点，之后再让指向上一个节点的指针指向当前节点，
     * <br/>指向当前节点的指针指向下一个节点。如此循环下去，直至当前节点为空为止</p>
     * @param  head
     * @return ListNode
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        // 指向上一个节点的指针
        ListNode previous = null;
        // 指向当前节点的指针
        ListNode current = head;
        // 指向下一个节点的指针
        ListNode nextTemp = null;
        while (current != null) {
            // 获取下一个节点
            nextTemp = current.next;
            // 当前节点的next指向上一个节点
            current.next = previous;
            // 指向上一个节点的指针指向当前节点
            previous = current;
            // 指向当前节点的指针指向下一个节点
            current = nextTemp;
        }
        return previous;
    }

    /**
     * <h6>递归法</h6>
     *
     * <p>递归地翻转子链表，原先链表的尾节点就是翻转后的头节点，将翻转后的子链表的尾节点的next指向当前节点,
     * <br/>直至到原先链表的头节点为止。</p>
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        // 终止条件，最终返回被翻转后的链表的头节点
        if (head == null || head.next == null) {
            return head;
        }

        // 递归操作，翻转子链
        ListNode reversedPart = reverseList2(head.next);
        // 让被翻转后的子链的尾节点的next指向当前节点
        head.next.next = head;
        // 当前节点的next指向空，防止形成环形链表
        head.next = null;
        return reversedPart;
    }
}

package kstar.leetcode_cn.leetcode._0234;

/**
 * <p><b>解题思路：</b>
 * <br/>先获取链表长度，在获取链表中间节点，然后反转后半段链表，将反转后的结果与前半段链表逐个比较值，获取最终结果。</p>
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 获取链表长度
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // 获取链表的中间节点
        int halfLength = length / 2;
        temp = head;
        for (int i = 0; i < halfLength; i++) {
            temp = temp.next;
        }

        // 反转链表的后半段
        ListNode prev = reverseList(temp);

        // 对比链表前半段后半段每个节点的值
        for (int i = 0; i < halfLength; i++) {
            if (head.val != prev.val) {
                return false;
            }
            head = head.next;
            prev = prev.next;
        }

        return true;
    }

    /**
     * <h6>反转链表</h6>
     *
     * @param head
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

package kstar.leetcode_cn.leetcode._0002;

/**
 * <h6>链表法</h6>
 *
 * <p>时间复杂度：o(max(m, n))；空间复杂度：o(max(m, n))</p>
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 头指针
        ListNode head = new ListNode(0);
        // 当前指针
        ListNode current = head;
        // 进位
        int carry = 0;
        while ((l1 != null) || (l2 != null)) {
            int a = 0;
            int b = 0;

            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            int sum = carry + a + b;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        if (carry == 1) {
            current.next = new ListNode(carry);
        }
        return head.next;
    }

}

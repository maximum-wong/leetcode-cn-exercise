package kstar.leetcode._0002;

public class Solution {

    /**
     * <h6>链表法</h6>
     * 
     * <p>时间复杂度：o(max(m, n))；空间复杂度：o(max(m, n))</p>
     * @param  l1
     * @param  l2
     * @return ListNode
     */
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

    /**
     * <h6>递归解法</h6>
     * 
     * <p>时间复杂度：o(max(m, n))；空间复杂度：o(max(m,n))</p>
     * <p>两个节点相加，要进行两步，首先是节点相加，然后是相加的结果和余数相加</p>
     * @param  l1
     * @param  l2
     * @return ListNode
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return (l1 == null) ? l2 : l1;
        }
        int value = l1.val + l2.val;
        ListNode result = new ListNode(value % 10);
        // 节点相加
        result.next = addTwoNumbers2(l1.next, l2.next);
        // 节点相加的结果和余数相加
        if (value >= 10) {
            result.next = addTwoNumbers2(new ListNode(value / 10), result.next);
        }
        return result;
    }
}

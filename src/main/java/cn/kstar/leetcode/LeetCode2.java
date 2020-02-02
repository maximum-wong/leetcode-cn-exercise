package cn.kstar.leetcode;

import cn.kstar.leetcode.data_structure.ListNode;

/**
 * <h3>Add Two Numbers
 * </br>两数相加</h3>
 * 
 * <p>You are given two non-empty linked lists representing two non-negative integers.
 * <br/>The digits are stored in reverse order and each of their nodes contain a single digit.
 * <br/>Add the two numbers and return it as a linked list.
 * <br/>You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <br/>有两个链表，链表节点分别代表数字的位数，求两个链表的和。</p>
 * 
 * <pre><b>Example: </b>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.</pre>
 */
public class LeetCode2 {

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

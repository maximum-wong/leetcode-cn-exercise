package cn.kstar.leetcode;

/**
 * <h3>Add Two Numbers</h3>
 * <h3>两数相加</h3>
 * 
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * 有两个链表，链表节点分别代表数字的位数，求两个链表的和。
 * 
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class LeetCode2 {

    /**
         * 链表法
         * 时间复杂度：o(max(m, n))；空间复杂度：o(max(m, n))
     * 
     * @param l1
     * @param l2
     * @return ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null; // 指向链表的头指针
        ListNode tail = null; // 指向链表的尾指针
        // 余数
        int remainder = 0;
        while ((l1 != null) || (l2 != null) || (remainder > 0)) {
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
            // 记录余数
            int item = remainder + a + b;
            remainder = (item >= 10) ? 1 : 0;
            ListNode current = new ListNode(item % 10);
            if (tail == null) {
                tail = current;
                head = current;
            } else {
                tail.next = current;
                tail = tail.next;
            }
        }
        return head;
    }
    
    /**
     * @desc 递归解法
     * @desc 两个节点相加，要进行两步，首先是节点相加，然后是相加的结果和余数相加
     * @desc 时间复杂度：o(max(m, n))；空间复杂度：o(max(m,n))
     * 
     * @param l1
     * @param l2
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

class ListNode {
    
    public ListNode(int val) {
        this.val = val;
    }
    
    public int val;
    public ListNode next;
}
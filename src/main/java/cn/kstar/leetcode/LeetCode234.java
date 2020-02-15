package cn.kstar.leetcode;

import cn.kstar.leetcode.data_structure.ListNode;

/**
 * <h6>回文链表
 * <br/>Palindrome Linked List</h6>
 *
 * <p>请判断一个链表是否为回文链表。
 * <br/>Given a singly linked list, determine if it is a palindrome.</p>
 * <pre><b>Examples: </b>
 * <b>Example 1: </b>
 * Input: 1->2
 * Output: false
 * 
 * <b>Example 2: </b>
 * Input: 1->2->2->1
 * Output: true
 * </pre>
 * <p><b>进阶：
 * <br>Follow up:</b>
 * <br/>你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <br/>Could you do it in O(n) time and O(1) space?
 * <p>
 */
public class LeetCode234 {

    /**
     * <p><b>解题思路：</b>
     * <br/>先获取链表长度，在获取链表中间节点，然后反转后半段链表，将反转后的结果与前半段链表逐个比较值，获取最终结果。</p>
     * 
     * @param  head
     * @return boolean
     */
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
     * <h6>快慢指针法（反转后半段链表）</h6>
     * 
     * <p><b>解题思路：</b>
     * <br/>使用快慢指针法，快指针走两步，慢指针一步，待到快指针走到头时，慢指针就指向链表中点位置。
     * <br/>如果链表长度是奇数的话，即当前快指针所指节点不为空时，需要向后移动一下慢指针。然后再从慢指针开始反转链表后半段部分。
     * <br/>随后，分别移动头指针和prev指针，进行值比较，获得最终结果。</p>
     * @param  head
     * @return boolean
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        // 获取链表的中间节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 反转链表后半段
        if (fast != null) { // 链表节点是奇数个的情况
            slow = slow.next;
        }
        ListNode prev = reverseList(slow);

        // 对比链表前半段后半段每个节点的值
        while (prev != null) {
            if (head.val != prev.val) {
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        return true;
    }

    /**
     * <h6>快慢指针法（反转前半段链表）</h6>
     * 
     * <p><b>解题思路：</b>
     * <br/>使用快慢指针法，快指针走两步，慢指针一边走一步，一边反转链表，待到快指针走到头时，慢指针就指向链表中点位置。
     * <br/>如果链表长度是奇数的话，即当前快指针所指节点不为空时，需要向后移动一下慢指针。
     * <br/>随后，分别移动慢指针和prev指针，进行值比较，获得最终结果。</p>
     * @param  head
     * @return boolean
     */
    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        ListNode next = null;
        // 获取链表的中间节点并反转链表前半段
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // 链表节点是奇数个的情况
        if (fast != null) {
            slow = slow.next;
        }

        // 对比链表前半段后半段每个节点的值
        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        return true;
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

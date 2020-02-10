package cn.kstar.leetcode;

import cn.kstar.leetcode.data_structure.ListNode;

/**
 * <h6>环形链表</h6>
 *
 * <p>给定一个链表，判断链表中是否有环。
 * <br/>为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * <br/>如果 pos 是 -1，则在该链表中没有环。
 * <br/>你能用 O(1)（即，常量）内存解决此问题吗？</p>
 * <pre><b>Examples: </b>
 * Input: head = [3,2,0,-4], pos = 1; Output: true
 * Explanation: 链表中有一个环，其尾部连接到第二个节点。
 * 
 * Input: head = [1,2], pos = 0; Output: true
 * Explanation: 链表中有一个环，其尾部连接到第一个节点。
 * </pre>
 */
public class LeetCode141 {

    /**
     * <h6>快慢指针法</h6>
     * 
     * <p>遍历链表，如果链表有环，快指针和慢指针总会相遇；反之，则快指针指向null</p>
     * @param  head
     * @return boolean
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        // 慢指针
        ListNode slow = head;
        // 快指针
        ListNode fast = head.next;
        // 在快慢指针不相遇时，进行遍历操作
        while (slow != fast) {
            // 链表无环
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

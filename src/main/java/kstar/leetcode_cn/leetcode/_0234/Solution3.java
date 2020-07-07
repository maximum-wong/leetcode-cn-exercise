package kstar.leetcode_cn.leetcode._0234;

/**
 * <h6>快慢指针法（反转前半段链表）</h6>
 * 
 * <p><b>解题思路：</b>
 * <br/>使用快慢指针法，快指针走两步，慢指针一边走一步，一边反转链表，待到快指针走到头时，慢指针就指向链表中点位置。
 * <br/>如果链表长度是奇数的话，即当前快指针所指节点不为空时，需要向后移动一下慢指针。
 * <br/>随后，分别移动慢指针和prev指针，进行值比较，获得最终结果。</p>
 */
public class Solution3 {

    public boolean isPalindrome(ListNode head) {
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

}

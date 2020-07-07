package kstar.leetcode_cn.leetcode._0234;

/**
 * <h6>快慢指针法（反转后半段链表）</h6>
 * 
 * <p><b>解题思路：</b>
 * <br/>使用快慢指针法，快指针走两步，慢指针一步，待到快指针走到头时，慢指针就指向链表中点位置。
 * <br/>如果链表长度是奇数的话，即当前快指针所指节点不为空时，需要向后移动一下慢指针。然后再从慢指针开始反转链表后半段部分。
 * <br/>随后，分别移动头指针和prev指针，进行值比较，获得最终结果。</p>
 */
public class Solution2 {

    public boolean isPalindrome(ListNode head) {
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

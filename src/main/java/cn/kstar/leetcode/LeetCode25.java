package cn.kstar.leetcode;

import cn.kstar.leetcode.data_structure.ListNode;

/**
 * <h6>k个一组反转链表</h6>
 *
 * <p>给出一个链表，每 k 个节点一组进行反转，并返回反转后的链表。
 * <br/>k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * <br/><b>说明：</b>
 * <br/>你的算法只能使用常数的额外空间。你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。</p>
 * <pre><b>Examples: </b>
 * &nbsp;&nbsp;给定这个链表：1->2->3->4->5
 * &nbsp;&nbsp;当 k = 2 时，应当返回: 2->1->4->3->5
 * &nbsp;&nbsp;当 k = 3 时，应当返回: 3->2->1->4->5
 * </pre>
 */
public class LeetCode25 {

    /**
     * <h6>递归法分组法</h6>
     *
     * @param  head
     * @param  k
     * @return ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }

        // 头指针
        ListNode index = head;
        // 原链表按照k个一组进行分组
        ListNode[] temp = new ListNode[k];
        temp[0] = index;
        for (int i = 1; i < k; i++) {
            index = index.next;
            // 不足k个元素的分组，不进行反转操作
            if (index == null) {
                return head;
            } else {
                temp[i] = index;
            }
        }

        // 分组的第一个元素元素连接递归返回来的后续结果（子链表的尾节点）
        temp[0].next = reverseKGroup(temp[k - 1].next, k);

        // 反转分组元素
        for (int i = 1; i < k; i++) {
            temp[i].next = temp[i - 1];
        }
        // 返回分组最后一个元素（子链表的头节点）
        return temp[k - 1];
    }

    /**
     * <h6>循环法</h6>
     *
     * <p><b>解题思路：</b>
     * <br/>添加虚拟头节点，循环处理每个分组区间，记录前驱节点、后驱节点、开始节点和结束节点，
     * <br/>然后在反转区间内进行反转操作，获取操作后的子链表，前驱节点与子链表的头节点相连，
     * <br/>子链表的尾节点与后驱节点相连；如此循环下去，
     * <br/>直至原链表末尾，最后返回虚拟头节点指向的next的链表。</p>
     * </p>
     * @param  head
     * @param  k
     * @return ListNode
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }

        // 添加虚拟头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 前驱节点
        ListNode predecessor = dummy;
        // 后继节点
        ListNode successor = null;
        // 分组链表的开始节点
        ListNode start = head;
        // 分组链表的结束节点
        ListNode end = head;

        while (end != null) {
            // 确定分组的反转区间
            for (int i = 1; i < k && end != null; i++) {
                end = end.next;
            }

            // 反转节点不足k个
            if (end == null) {
                break;
            }

            // 获取后继节点
            successor = end.next;
            // 反转区间与原链表断开连接
            end.next = null;
            // 前驱节点与反转后的子链表进行相连
            predecessor.next = reverseList(start);
            // 开始节点在反转后变成尾节点，与后继节点相连
            start.next = successor;
            // 对下一轮变量进行赋值
            predecessor = start;
            start = successor;
            end = successor;
        }
        return dummy.next;
    }

    /**
     * <h6>反转链表</h6>
     *
     * @param  head
     * @return ListNode
     */
    private ListNode reverseList(ListNode head) {
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

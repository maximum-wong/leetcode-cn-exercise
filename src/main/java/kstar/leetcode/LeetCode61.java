package kstar.leetcode;

import kstar.leetcode.data_structure.ListNode;

/**
 * <h6>旋转链表</h6>
 *
 * <p>给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。</p>
 * <pre><b>Examples: </b>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * &nbsp;&nbsp;向右旋转 1 步: 5->1->2->3->4->NULL
 * &nbsp;&nbsp;向右旋转 2 步: 4->5->1->2->3->NULL
 * 
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * &nbsp;&nbsp;向右旋转 1 步: 2->0->1->NULL
 * &nbsp;&nbsp;向右旋转 2 步: 1->2->0->NULL
 * &nbsp;&nbsp;向右旋转 3 步: 0->1->2->NULL
 * &nbsp;&nbsp;向右旋转 4 步: 2->0->1->NULL
 * </pre>
 */
public class LeetCode61 {

    /**
     * <p><b>解题思路:</b>
     * <br/>先将链表连成一个环,然后移动合适的位置,再切开。</p>
     * <pre><b>长度为4，右移1的情况</b>
     * 1.获取链表长度
     * 1->2->5->6->NULL
     * 
     * 2.链表连成环
     * dummy->1->2->5->6
     *        ^________|
     *   
     * 3.从dummy开始右移3个（count-k）单位，找到断开处，断开链表
     *              |-->NULL
     * dummy->1->2->5  6
     *        ^________|
     *
     * 4.获得结果
     * 6->1->2->5->NULL
     * </pre>
     * 
     * @param  head
     * @param  k
     * @return ListNode
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        // 链表节点数
        int count = 1;
        // 当前指针
        ListNode current = head;
        // 统计链表节点的个数
        while (current.next != null) {
            count++;
            current = current.next;
        }

        // 对k取模
        k = k % count;
        // k是count的整数倍,不需要选择进行旋转操作
        if (k == 0) {
            return head;
        }

        // 将链表连成一个环
        current.next = head;
        // 虚拟节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 前节点指针
        ListNode previous = dummy;
        // 前节点指针需要走count-k个节点,才你到达新链表的末尾
        for (int i = 0; i < count - k; i++) {
            previous = previous.next;
        }
        // 链表断开的位置
        current = previous.next;
        // 断开链表,重新组成新的不循环链表
        previous.next = null;
        return current;
    }
}

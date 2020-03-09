package cn.kstar.leetcode;

import cn.kstar.leetcode.data_structure.ListNode;

/**
 * <h6>柱状图中最大的矩形
 * <br/>Partition List</h6>
 *
 * <p>给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <br/>Given a linked list and a value x, partition it such that 
 * all nodes less than x come before nodes greater than or equal to x.</p>
 * <p>你应当保留两个分区中每个节点的初始相对位置。
 * <br/>You should preserve the original relative order of the nodes in each of the two partitions.</p>
 * <p><b>Example: </b></p>
 * <pre>
 * <b>Input: </b>head = 1->4->3->2->5->2, x = 3
 * <b>Output: </b>1->2->2->4->3->5
 * </pre>
 */
public class LeetCode86 {

    /**
     * <p><h6>解题思路：</h6></p>
     * <ol>
     * <li>连接链表，把当前节点连接到需要的链表上</li>
     * <li>移动指针，该节点处理完了，原链表上需要后移一步</li>
     * <li>断开链表，当前链表不能与原链表相连</li>
     * <li>调整状态，调整当前各指针的记录状态</li>
     * </ol>
     * @param  head
     * @param  x
     * @return ListNode
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        // 较小值链表指针
        ListNode preDummy = new ListNode(-1);
        // 较大值链表指针
        ListNode dummy = new ListNode(-1);
        preDummy.next = dummy;
        // 返回结果指针
        ListNode result = preDummy;
        // 尾节点指针
        ListNode tail = dummy;

        // 当前指针
        ListNode current;
        while (head != null) {
            current = head;
            if (head.val < x) {
                // 连接前虚拟节点
                preDummy.next = current;
                // 主链表指针后移
                head = head.next;
                // 断开主链表
                current.next = dummy;
                preDummy = preDummy.next;
            } else {
                // 连接尾节点
                tail.next = current;
                // 主链表指针后移
                head = head.next;
                // 断开主链表
                current.next = null;
                tail = tail.next;
            }
        }
        preDummy.next = dummy.next;
        return result.next;
    }
}

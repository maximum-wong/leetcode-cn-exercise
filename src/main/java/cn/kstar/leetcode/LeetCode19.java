package cn.kstar.leetcode;

import cn.kstar.leetcode.data_structure.ListNode;

/**
 * <h6>删除链表的倒数第N个节点</h6>
 * 
 * <p>给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <br/>示例：给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <br/>当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <br/>说明：给定的 n 保证是有效的。</p>
 *
 */
public class LeetCode19 {

	/**
	 * <p>链表的题目基本上都是优先考虑双指针。
	 * <br/>一个指针先走N步，然后两个指针同步移动到链表末尾，移除前一个指针所指着的节点即可。</p>
	 * 
	 * @param  head
	 * @param  n
	 * @return ListNode
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode right = head;
		ListNode left = head;
		for (int i = 0; i < n; i++) {
			right = right.next;
		}
		// 边界条件处理
		if (right == null) {
			head = head.next;
			return head;
		}
		while (right.next != null) {
			left = left.next;
			right = right.next;
		}
		left.next = left.next.next;
		return head;
	}
}

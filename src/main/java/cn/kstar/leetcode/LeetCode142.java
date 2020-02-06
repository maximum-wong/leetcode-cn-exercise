package cn.kstar.leetcode;

import cn.kstar.leetcode.data_structure.ListNode;

/**
 * <h6>环形链表 II</h6>
 *
 * <p>给定一个链表，判断链表中是否有环。
 * <br/>为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * <br/>如果 pos 是 -1，则在该链表中没有环。有环则返回环的入口。
 * <br/>你能用 O(1)（即，常量）内存解决此问题吗？</p>
 * <pre><b>Examples: </b>
 * Input: head = [ 3, 2, 0, -4 ], pos = 1; Output: 1
 * Explanation: 链表中有一个环，其尾部连接到第二个节点。
 * 
 * Input: head = [ 1, 2 ], pos = 0; Output: 0
 * Explanation: 链表中有一个环，其尾部连接到第一个节点。
 * </pre>
 */
public class LeetCode142 {

	/**
	 * <h6>快慢指针法</h6>
	 * 
	 * <p>遍历链表，在快慢指针相遇的位置，继续遍历慢指针和辅助指针，直至相遇位置为环的入口位置</p>
	 * @param  head 链表头节点
	 * @return int 链表环入口位置
	 */
	public int detectCycle(ListNode head) {
		// 链表环入口位置
		int pos = -1;
		if (head == null || head.next == null) {
			return pos;
		}

		// 慢指针
		ListNode slow = head;
		// 快指针
		ListNode fast = head;
		// 辅助指针
		ListNode start = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			// 当快慢指针相遇时
			if (slow == fast) {
				pos++;
				// 继续遍历慢指针和辅助指针，直至相遇节点为链表环入口位置
				while (slow != start) {
					slow = slow.next;
					start = start.next;
					pos++;
				}
				return pos;
			}
		}
		return pos;
	}
}

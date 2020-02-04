package cn.kstar.leetcode;

import cn.kstar.leetcode.data_structure.ListNode;

/**
 * <h6>k个一组翻转链表</h6>
 *
 * <p>给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
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
	 * <h6>递归法</h6>
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
			// 不足k个元素的分组，不进行翻转操作
			if (index == null) {
				return head;
			} else {
				temp[i] = index;
			}
		}

		// 分组的第一个元素元素连接递归返回来的后续结果
		temp[0].next = reverseKGroup(temp[k - 1].next, k);

		// 翻转分组元素
		for (int i = 1; i < k; i++) {
			temp[i].next = temp[i - 1];
		}
		// 返回分组最后一个元素
		return temp[k - 1];
	}
}

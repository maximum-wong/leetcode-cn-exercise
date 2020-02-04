package cn.kstar.leetcode;

import cn.kstar.leetcode.data_structure.ListNode;

/**
 * <h6>两两交换链表中的节点</h6>
 *
 * <p>合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。</p>
 * <pre><b>Examples: </b>
 * Input: [ 1->4->5, 1->3->4, 2->6]; Output: 1->1->2->3->4->4->5->6
 * </pre>
 */
public class LeetCode23 {

	/**
	 * <h6>使用二分法递归合并多个链表</h6>
	 * 
	 * <p>时间复杂度：O(klogn)；空间复杂度：O(1)</p>
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		return mergeHelper(lists, 0, lists.length - 1);
	}

	/**
	 * 使用二分法递归地合并链表
	 * 
	 * @param lists
	 * @param low
	 * @param high
	 * @return ListNode
	 */
	private ListNode mergeHelper(ListNode[] lists, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			ListNode leftList = mergeHelper(lists, low, mid);
			ListNode rightList = mergeHelper(lists, mid + 1, high);
			return mergeTwoLists(leftList, rightList);
		}
		return lists[low];
	}

	/**
	 * 合并两个链表
	 *
	 * @param  l1
	 * @param  l2
	 * @return ListNode
	 */
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode merged = null;
		ListNode head = null;
		while (l1 != null && l2 != null) {
			if (head == null) {
				if (l1.val < l2.val) {
					merged = l1;
					l1 = l1.next;
				} else {
					merged = l2;
					l2 = l2.next;
				}
				head = merged;
				continue;
			}

			if (l1.val < l2.val) {
				merged.next = l1;
				l1 = l1.next;
			} else {
				merged.next = l2;
				l2 = l2.next;
			}
			merged = merged.next;
		}

		while (l1 != null) {
			merged.next = l1;
			l1 = l1.next;
			merged = merged.next;
		}

		while (l2 != null) {
			merged.next = l2;
			l2 = l2.next;
			merged = merged.next;
		}
		return head;
	}
}

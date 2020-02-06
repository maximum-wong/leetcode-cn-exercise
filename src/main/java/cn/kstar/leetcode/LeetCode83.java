package cn.kstar.leetcode;

import cn.kstar.leetcode.data_structure.ListNode;

/**
 * <h6>删除排序链表中的重复元素</h6>
 *
 * <p>给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。</p>
 * <pre><b>Examples: </b>
 * Input: 1->1->2; Output: 1->2
 * 
 * Input: 1->1->2->3->3; Output: 1->2->3
 * </pre>
 */
public class LeetCode83 {

	/**
	 * <h6>直接遍历进行操作<h6>
	 * 
	 * @param  head
	 * @return ListNode
	 */
	public ListNode deleteDuplicates(ListNode head) {
		ListNode list = head;
		while (list!=null) {
			// 当遍历到尾部时停止遍历
			if (list.next==null) {
				break;
			}
			// 当下一个节点的值等于当前节点的，当前节点指向下一个节点的下一个节点
			if (list.val==list.next.val) {
				list.next = list.next.next;
			} else {
				list = list.next;
			}
		}
		
		return head;
	}
}

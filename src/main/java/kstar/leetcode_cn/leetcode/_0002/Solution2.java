package kstar.leetcode_cn.leetcode._0002;

/**
 * <h6>递归解法</h6>
 *
 * <p>时间复杂度：o(max(m, n))；空间复杂度：o(max(m,n))</p>
 * <p>两个节点相加，要进行两步，首先是节点相加，然后是相加的结果和余数相加</p>
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return (l1 == null) ? l2 : l1;
        }
        int value = l1.val + l2.val;
        ListNode result = new ListNode(value % 10);
        // 节点相加
        result.next = addTwoNumbers(l1.next, l2.next);
        // 节点相加的结果和余数相加
        if (value >= 10) {
            result.next = addTwoNumbers(new ListNode(value / 10), result.next);
        }
        return result;
    }
}

package kstar.leetcode;

import java.util.HashMap;
import java.util.Map;

import kstar.leetcode.data_structure.ListNode;

/**
 * <h6>相交链表
 * <br/>Intersection of Two Linked Lists</h6>
 *
 * <p>编写一个程序，找到两个单链表相交的起始节点。</p>
 * <pre>
 * <p>如下面的两个链表：
 * <br/>For example, the following two linked lists:</p>
 * A:        a1 → a2
 *                 ↘
 *                  c1 → c2 → c3
 *                  ↗ 
 * B:   b1 → b2 → b3
 * <p>在节点 c1 开始相交。
 * <br/>begin to intersect at node c1.</p>
 * </pre>
 * <pre><b>Examples: </b>
 * <b>Example1: </b>
 * A:        4 → 1
 *                ↘
 *                 8 → 4 → 5
 *                 ↗ 
 * B:     5 → 0 → 1
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: 相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). 
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5].
 * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * 
 * <b>Example2: </b>
 * A:    0 →  9 → 1
 *                ↘
 *                 2 → 4
 *                 ↗ 
 * B:            3
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: 相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4].
 * There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 * 
 * <b>Example2: </b>
 * A:    2 →  6 → 4
 *
 *
 *
 * B:        1 → 5
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: 从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5].
 * Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: 这两个链表不相交，因此返回 null。
 * The two lists do not intersect, so return null.
 * </pre>
 * <b>Notes:</b><ul>
 * <li>如果两个链表没有交点，返回 null.</li>
 * <li>If the two linked lists have no intersection at all, return null.</li>
 * <li>在返回结果后，两个链表仍须保持原有的结构。</li>
 * <li>The linked lists must retain their original structure after the function returns.</li>
 * <li>可假定整个链表结构中没有循环。</li>
 * <li>You may assume there are no cycles anywhere in the entire linked structure.</li>
 * <li>程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。</li>
 * <li>Your code should preferably run in O(n) time and use only O(1) memory.</li></ul>
 */
public class LeetCode160 {

    /**
     * <h6>双指针法</h6>
     * 
     * <p>时间复杂度：O(m+n)；空间复杂度：O(1)</p>
     * <p>两个指针分别遍历两个链表，遍历完较短链表的指针，就去便利较长的链表，待到较长链表的指针遍历完较长链表时，
     * <br/>就去遍历较短的链表，直到两指针相遇为止。</p>
     * @param  headA
     * @param  headB
     * @return ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            tempA = (tempA == null) ? headB : tempA.next;
            tempB = (tempB == null) ? headA : tempB.next;
        }
        return tempA;
    }
    
    /**
     * <h6>查表法</h6>
     * 
     * <p>时间复杂度：O(m+n)；空间复杂度：O(m) 或 O(n)，取决于你把哪条链表的结点存储进HashMap</p>
     * <p>把一条链表储存进HashMap，遍历另一条链表，查询是否有第一个相同的节点。</p>
     * @param  headA
     * @param  headB
     * @return ListNode
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode ret = null;
        if (headA == null || headB == null) {
            return ret;
        }

        ListNode tempA = headA;
        ListNode tempB = headB;
        Map<ListNode, Boolean> mapA = new HashMap<>();
        while (tempA != null) {
            mapA.put(tempA, Boolean.TRUE);
            tempA = tempA.next;
        }
        while (tempB != null) {
            Boolean exist = mapA.get(tempB);
            if (exist != null) {
                ret = tempB;
                break;
            }
            tempB = tempB.next;
        }
        return ret;
    }
}

package cn.kstar.leetcode;

import cn.kstar.leetcode.data_structure.ListNode;

/**
 * <h6>删除链表中的节点
 * <br/>Delete Node in a Linked List</h6>
 *
 * <p>请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * <br/>现有一个链表 -- head = [4,5,1,9]，它可以表示为： 4 -> 5 -> 1 -> 9
 * <br/>Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * <br/>Given linked list -- head = [4,5,1,9], which looks like following: 4 -> 5 -> 1 -> 9
 * </p>
 * <pre><b>Examples: </b>
 * <b>Example1: </b>
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 * 
 * <b>Example2: </b>
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 * </pre>
 */
public class LeetCode237 {

    public void deleteNode(ListNode node) {
        // 下一个节点的值赋值给当前被删除的节点
        node.val = node.next.val;
        // 删除下一个节点
        node.next = node.next.next;
    }
}

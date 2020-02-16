package cn.kstar.leetcode.data_structure;

/**
 * <h6>双向链表的结点类</h6>
 */
public class DoublyListNode {

    public DoublyListNode(int val) {
        this.val = val;
    }

    public int val;
    public DoublyListNode prev;
    public DoublyListNode next;
}

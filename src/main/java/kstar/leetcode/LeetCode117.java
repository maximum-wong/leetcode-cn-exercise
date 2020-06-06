package kstar.leetcode;

import kstar.leetcode.data_structure.Node;

/**
 * <h6>填充每个节点的下一个右侧节点指针 II
 * <br/>Populating Next Right Pointers in Each Node II</h6>
 *
 * <p>给定一个二叉树
 * <br/>Given a binary tree</p>
 * <pre>
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * </pre>
 * <p>填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 <code>NULL</code>。
 * <br/>Populate each next pointer to point to its next right node. 
 * If there is no next right node, the next pointer should be set to  <code>NULL </code>.</p>
 * <p>初始状态下，所有 next 指针都被设置为 <code>NULL</code>。
 * <br/><Initially, all next pointers are set to  <code>NULL </code>./p>
 * <p>&nbsp;</p>
 * <p><b>进阶：</b>
 * <br/><b>Follow up:</b></p>
 * <ul>
 * <li>你只能使用常量级额外空间。</li>
 * <li>You may only use constant extra space.</li>
 * <li>使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。</li>
 * <li>Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.</li>
 * </ul>
 * <p><b>示例：</b>
 * <b>Example 1:</b></p>
 * <p><img style="height: 218px; width: 640px;" src="../../../pic/117_sample.png" alt=""></p>
 * <pre>
 * 输入：root = [1,2,3,4,5,null,7]
 * Input: root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * Output: [1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to 
 * its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, 
 * with '#' signifying the end of each level.
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>提示：</strong>
 * <b>Constraints:</b></p>
 * <ul>
 * <li>树中的节点数小于 <code>6000</code></li>
 * <li>The number of nodes in the given tree is less than <code>6000</code>.</li>
 * <li><code>-100&nbsp;&lt;= node.val &lt;= 100</code></li>
 * </ul>
 */
public class LeetCode117 {

    /**
     * <h6>递归法</h6>
     *
     * <p>使用递归法，自顶向下的，把每一层节点相连。</p>
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = findToLinkedNode(root.next);
            }
        }

        if (root.right != null) {
            root.right.next = findToLinkedNode(root.next);
        }

        connect(root.right);
        connect(root.left);
        return root;
    }

    /**
     * <h6>寻找相连的节点</h6>
     * 
     * @param node
     * @return
     */
    private Node findToLinkedNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            return node.left;
        }
        if (node.right != null) {
            return node.right;
        }
        return findToLinkedNode(node.next);
    }
}

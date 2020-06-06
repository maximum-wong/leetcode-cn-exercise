package kstar.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import kstar.leetcode.data_structure.Node;

/**
 * <h6>填充每个节点的下一个右侧节点指针
 * <br/>Populating Next Right Pointers in Each Node</h6>
 *
 * <p>给定一个<b>完美二叉树</b>，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <br/>You are given a <b>perfect binary tree</b> where all leaves are on the same level, 
 * and every parent has two children. The binary tree has the following definition:</p>
 * <pre>
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * </pre>
 * <p>填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 <code>NULL</code>。
 * <br/>Populate each next pointer to point to its next right node. If there is no next right node, 
 * the next pointer should be set to <code>NULL</code>.</p>
 * <p>初始状态下，所有 next 指针都被设置为 <code>NULL</code>。
 * <br/>Initially, all next pointers are set to <code>NULL</code>.</p>
 * <p><b>示例：</b></p>
 * <p><img style="height: 218px; width: 640px;" src="../../../pic/116_sample.png" alt=""></p>
 * <pre>
 * <b>输入：</b>{"$id":"1","left":{"$id":"2","left":
 * {"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":
 * {"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":
 * {"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":
 * {"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * </pre>
 * <pre>
 * <b>输出：</b>{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":
 * {"$id":"5","left":null,"next":
 * {"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":
 * {"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":
 * {"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 * 
 * <b>解释：</b>给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * </pre>
 * <p>&nbsp;</p>
 * <p><b>提示：</b></p>
 * <ul>
 * <li>你只能使用常量级额外空间。</li>
 * <li>使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。</li>
 * </ul>
 */
public class LeetCode116 {

    /**
     * <h6>层级遍历法（BFS法）</h6>
     * 
     * <p>使用BFS法，在队列中先放右边子节点再放左边子节点，取出时，就可以让让左边的节点指向右边的节点</p>
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 保存需要指向的当前节点
            Node current = null;
            while (size > 0) {
                Node node = queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // 左边节点指向右边节点
                node.next = current;
                current = node;
                size--;
            }
        }
        return root;
    }

    /**
     * <h6>递归法</h6>
     * 
     * <p>使用递归法，自顶向下将同层的左节点与右节点相连，直到最底层</p>
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }

        // 左子节点与右节点相连
        if (root.left != null) {
            root.left.next = root.right;
        }
        // 右子节点与右子树的左节点相连
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        // 递归地处理左子树
        connect2(root.left);
        // 递归地处理右子树
        connect2(root.right);
        return root;
    }

    /**
     * <h6>层级遍历法</h6>
     * 
     * <p>使用一个辅助的虚拟头节点，指向每层的最左边的元素，通过哨兵指针进行从左到右的连接的工作</p>
     * @param root
     * @return
     */
    public Node connect3(Node root) {
        // 虚拟头节点
        Node dummy = new Node(0);
        // 哨兵节点
        Node pre = dummy;
        // 当前根节点
        Node currentRoot = root;
        while (currentRoot != null) {
            // 处理左边子节点
            if (currentRoot.left != null) {
                pre.next = currentRoot.left;
                pre = pre.next;
            }
            // 处理右边子节点
            if (currentRoot.right != null) {
                pre.next = currentRoot.right;
                pre = pre.next;
            }
            // 当前根节点右移
            currentRoot = currentRoot.next;
            // 切换层，到下一层
            if (currentRoot == null) {
                pre = dummy;
                // 当前根节点指向当前虚拟头节点指向的下一个元素（该层最左边的元素）
                currentRoot = dummy.next;
                dummy.next = null;
            }
        }
        return root;
    }
}

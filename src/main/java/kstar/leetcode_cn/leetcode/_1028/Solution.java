package kstar.leetcode_cn.leetcode._1028;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public TreeNode recoverFromPreorder(String S) {
        // 用一个栈来保存树的结点
        Deque<TreeNode> path = new LinkedList<>();
        // 记录读取的指针位置
        int pos = 0;
        while (pos < S.length()) {
            // 解析当前深度
            int level = 0;
            while (S.charAt(pos) == '-') {
                ++level;
                ++pos;
            }

            // 解析一个节点
            int value = 0;
            while (pos < S.length() && (int) S.charAt(pos) >= 48 && (int) S.charAt(pos) <= 57) {
                value = value * 10 + (S.charAt(pos) - '0');
                ++pos;
            }
            TreeNode node = new TreeNode(value);

            // 当前深度与栈的深度相同，当前节点是栈顶节点的左子节点
            if (level == path.size()) {
                if (!path.isEmpty()) {
                    path.peek().left = node;
                }
            } else { // 当前深度与栈的深度不相同，当前节点是较浅深度节点的右子节点
                while (level != path.size()) { // 弹出栈中一些元素，使当前深度与栈深度相同
                    path.pop();
                }
                path.peek().right = node;
            }
            // 把当前节点放入栈中
            path.push(node);
        }
        // 从栈中弹出一些元素，保留根节点元素
        while (path.size() > 1) {
            path.pop();
        }
        // 返回栈顶的根节点元素
        return path.peek();
    }
}

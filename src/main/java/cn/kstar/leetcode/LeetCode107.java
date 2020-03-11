package cn.kstar.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import cn.kstar.leetcode.data_structure.TreeNode;

/**
 * <p>二叉树的层次遍历 II</p>
 */
public class LeetCode107 {

    /**
     * <h6>DFS法</h6>
     * 
     * <p>使用DFS法，获取每层的元素，每次把每层元素都要放在结果集的头部才能返回自底向上的遍历结果</p>
     * @param  root
     * @return List<List<Integer>>
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            while (size > 0) {
                TreeNode head = queue.poll();
                list.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
                size--;
            }
            // 把元素放在头部
            result.add(0, list);
        }
        return result;
    }
    
    /**
     * <h6>递归法</h6>
     *
     * @param root
     * @return List<List<Integer>>
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>>res = new LinkedList<>();
        if (root ==null) {
            return res;
        }
        helper(root, res, 0);
        return res;
    }
    
    public void helper(TreeNode root, List<List<Integer>> res, int depth) {
        if (root ==null) {
            return;
        }
        
        if (depth==res.size()) {
            res.add(0, new LinkedList<>());
        }
        List<Integer> currentList = res.get(res.size()-depth-1);
        helper(root.left, res, depth+1);
        helper(root.right, res, depth+1);
        currentList.add(root.val);
    }
}

package kstar.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h6>第k个排列</h6>
 *
 * <p>给出集合 <code>[1,2,3,…,<em>n</em>]<code>，其所有元素共有 <em>n</em>! 种排列。
 * <br/>The set <code>[1,2,3,...,<em>n</em>]<code> contains a total 
 * of <em>n</em>! unique permutations.</p>
 * <p>按大小顺序列出所有排列情况，并一一标记，当 <em>n</em> = 3 时, 所有排列如下：
 * <br/>By listing and labeling all of the permutations in order, 
 * we get the following sequence for <em>n</em> = 3:</p>
 * <ol>
 * <li><code>"123"</code></ul>
 * <li><code>"132"</code></ul>
 * <li><code>"213"</code></ul>
 * <li><code>"231"</code></ul>
 * <li><code>"312"</code></ul>
 * <li><code>"321"</code></ul>
 * </ol>
 * <p>给定 <em>n</em> 和 <em>k</em>，返回第 <em>k</em> 个排列。
 * <br/>Given <em>n</em> and <em>k</em>, return the <em>k</em><sup>th</sup> permutation sequence.</p>
 * <p><b>说明：</b>
 * <br/><b>Note:</b></p>
 * <ul>
 * <li>给定 <em>n</em> 的范围是 [1, 9]。
 * <br/>Given <em>n</em> will be between 1 and 9 inclusive.</li>
 * <li>给定<em>k</em> 的范围是[1,  <em>n<em>!]。
 * <br/>Given <em>k</em> will be between 1 and <em>n</em>! inclusive.</li>
 * </ul>
 * <p><b>Example 1:</b></p>
 * <pre>
 * <b>Input:</b> n = 3, k = 3
 * <b>Output:</b> "213"
 * </pre>
 * <p><b>Example 2:</b></p>
 * <pre>
 * <b>Input:</b> n = 4, k = 9
 * <b>Output:</b> "2314"
 * </pre>
 */
public class LeetCode60 {

    private int count = 0;
    
    /**
     * <h6>回溯搜索法</h6>
     * 
     * <p>性能较差</p>
     * @param n
     * @param k
     * @return String
     */
    @Deprecated
    public String getPermutation(int n, int k) {
        String ret = "";
        if (n < 1 || n > 9 || k < 1) {
            return ret;
        }

        char[] nums = new char[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (char) (i + 49);
        }
        List<Character> res = new ArrayList<>();
        backtrack(nums, k, new ArrayList<>(), new boolean[n], res);
        if (!res.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Character ch : res) {
                sb.append(ch);
            }
            ret = sb.toString();
        }
        return ret;
    }

    private void backtrack(char[] nums, int k, List<Character> path,
            boolean[] used, List<Character> res) {
        if (path.size() == nums.length) {
            count++;
        }

        if (path.size() == nums.length && count == k) {
            res.addAll(path);
            return;
        }
        for (int i = 0, len = nums.length; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, k, path, used, res);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
    
    /**
     * <p><b>解题思路：</b></p>
     * <ul>
     * <li>n个数有n!个全排列，每种数字开头的全排列有(n-1)!种</li>
     * <li>k/(n-1)!用来获取第k个全排列是以第几个数字开头的</li>
     * <li>k%(n-1)!用来获取第k个全排列是某个数字开头的全排列中的第几个</li>
     * </ul>
     * 
     * @param n
     * @param k
     * @return String
     */
    public String getPermutation2(int n, int k) {
        if (n < 1 || n > 9 || k < 1) {
            return "";
        }

        List<Character> nums = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nums.add((char) (i + 49));
        }

        int base = 1;
        for (int i = 2; i < n; i++) {
            base *= i;
        }

        int round = n - 1;
        k -= 1;
        int index;
        char[] ret = new char[n];
        while (round >= 0) {
            index = k / base;
            ret[n-1-round] =nums.get(index);
            nums.remove(index);
            k %= base;
            if (round > 0) {
                base /= round;
            }
            round--;
        }
        return new String(ret);
    }
    
}

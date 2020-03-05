package cn.kstar.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h6>第k个排列</h6>
 */
public class LeetCode60 {

    private int count=0;
    
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

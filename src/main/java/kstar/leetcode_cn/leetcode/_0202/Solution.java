package kstar.leetcode_cn.leetcode._0202;

import java.util.HashSet;
import java.util.Set;

/**
 * <h6>查表法</h6>
 * <p>把每次得到的数字放入查找表中，如果是非快乐数必定会生成重复的数字，也就是会生成环</p>
 */
public class Solution {

    public boolean isHappy(int n) {
        // 存储生成的数字
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) { // 检测是否变成1；是否生成环
            // 把生成的数字放在set中
            set.add(n);
            n = getNextNum(n);
        }
        return n == 1;
    }

    /**
     * <h6>生成系一个数字<h6/>
     *
     * @param n
     * @return
     */
    private int getNextNum(int n) {
        int totalSum = 0;
        int digit = 0;
        while (n > 0) {
            digit = n % 10;
            n /= 10;
            totalSum += digit * digit;
        }
        return totalSum;
    }
}

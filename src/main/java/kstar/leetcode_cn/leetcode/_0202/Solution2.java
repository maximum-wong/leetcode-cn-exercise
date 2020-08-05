package kstar.leetcode_cn.leetcode._0202;

/**
 * <h6>快慢指针法</h6>
 * <p>通过快慢指针检测是否生成环</p>
 */
public class Solution2 {

    public boolean isHappy(int n) {
        int slowPointer = n;
        int fastPointer = getNextNum(n);

        while (fastPointer != 1 && slowPointer != fastPointer) { // 检测快指针是否变成1；是否生成环
            slowPointer = getNextNum(slowPointer);
            fastPointer = getNextNum(getNextNum(fastPointer));
        }
        return fastPointer == 1;
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

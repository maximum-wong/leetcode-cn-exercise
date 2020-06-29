package kstar.leetcode_cn.leetcode._0069;

/**
 * <h6>二分法</h6>
 */
public class Solution {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int start = 0;
        int end = x;
        int mid = 0;
        long multi = 0L;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            multi = (long) mid * mid;
            if (multi <= x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return multi > x ? mid - 1 : mid;
    }

}

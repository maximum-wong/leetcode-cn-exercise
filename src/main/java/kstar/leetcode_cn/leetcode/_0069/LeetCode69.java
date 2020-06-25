package kstar.leetcode_cn.leetcode._0069;

/**
 * <h6>x 的平方根</h6>
 *
 * <p>实现 int sqrt(int x) 函数。计算并返回 x 的平方根，其中 x 是非负整数。
 * <br/>由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。</p>
 * <pre><b>Examples: </b>
 * Input: 4; Output: 2
 * Input: 8; Output: 2; Explanation: 8 的平方根是 2.82842...，由于返回类型是整数，小数部分将被舍去。
 * </pre>
 */
public class LeetCode69 {

    /**
     * <h6>二分法</h6>
     * 
     * @param  x
     * @return int
     */
    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int start = 1;
        int end = x;
        while (start < end) {
            int mid = start - (start - end) >> 1;
            if ((x / mid) >= mid && (mid + 1) > x / (mid + 1)) { // 防止溢出
                return mid;
            } else if (x / mid < mid) { // 防止溢出
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    
    public static void main(String[] args) {
        System.out.println(new LeetCode69().sqrt(99));
    }
}

package kstar.leetcode_cn.leetcode._0056;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <h6>排序+遍历法</h6>
 * <p>时间复杂度：O(n*logn+n)；空间复杂度：O(n*logn)</p>
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        // 对数组进行排序
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        LinkedList<int[]> tmp = new LinkedList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (tmp.isEmpty() || intervals[i][0] > tmp.getLast()[1]) {
                tmp.add(new int[] { intervals[i][0], intervals[i][1] });
            } else if (intervals[i][1] > tmp.getLast()[1]) {
                tmp.getLast()[1] = intervals[i][1];
            }
        }

        return tmp.toArray(new int[0][]);
    }

}
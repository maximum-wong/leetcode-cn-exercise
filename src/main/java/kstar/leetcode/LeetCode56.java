package kstar.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h6>合并区间</h6>
 *
 * <p>给出一个区间的集合，请合并所有重叠的区间。</p>
 * <pre><b>Examples: </b>
 * <b>Example 1: </b>
 * Input: [[1,3],[2,6],[8,10],[15,18]]; Output: [[1,6],[8,10],[15,18]]
 * Explanation: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * <b>Example 2: </b>
 * Input: [[1,4],[4,5]]; Output: [[1,5]]
 * Explanation: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * </pre>
 */
public class LeetCode56 {

    /**
     * <p><b>解题思路：</b>
     * <br/>在排好序的情况下，当第一个区间的end>=第二个区间的start时，两个区间可以合并。</p>
     * 
     * @param intervals
     * @return List<Interval>
     */
    public List<Interval> merge(List<Interval> intervals) {
        if ((intervals == null) || (intervals.isEmpty())) {
            return intervals;
        }

        int n = intervals.size();
        // 开始部分
        int[] starts = new int[n];
        // 结束部分
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        // 排序区间
        Arrays.sort(starts);
        Arrays.sort(ends);

        int i = 0;
        List<Interval> ret = new ArrayList<>();
        while (i < n) {
            int start = starts[i];
            // 合并区间
            while ((i < n - 1) && (starts[i + 1] <= ends[i])) {
                i++;
            }
            // 产生新区间
            int end = ends[i];
            ret.add(new Interval(start, end));
            i++;
        }
        return ret;
    }
}

class Interval {
    int start;
    int end;

    public Interval() {
        this.start = 0;
        this.end = 0;
    }

    public Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }
}

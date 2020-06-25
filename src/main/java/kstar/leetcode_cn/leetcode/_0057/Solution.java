package kstar.leetcode_cn.leetcode._0057;

import java.util.LinkedList;

public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int idx = 0;
        int n = intervals.length;
        LinkedList<int[]> output = new LinkedList<>();

        // 把插入区间之前的区间收集起来
        while (idx < n && newStart > intervals[idx][0]) {
            output.add(intervals[idx++]);
        }

        int[] interval = new int[2];
        // 如果没有之前的收集结果
        if (output.isEmpty() || output.getLast()[1] < newStart) {
            output.add(newInterval);
        } else { // 如果有之前的收集结果，合并插入区间
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            output.add(interval);
        }

        // 合并插入区间之后的区间
        while (idx < n) {
            interval = intervals[idx++];
            int start = interval[0];
            int end = interval[1];
            if (output.getLast()[1] < start) {
                output.add(interval);
            } else {
                interval = output.removeLast();
                interval[1] = Math.max(interval[1], end);
                output.add(interval);
            }
        }
        return output.toArray(new int[output.size()][]);
    }
}

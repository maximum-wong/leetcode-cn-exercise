package kstar.leetcode_cn.leetcode._0492;

public class Solution {

    public int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        while (area % sqrt != 0)
            sqrt--;
        return new int[] { area / sqrt, sqrt };
    }
}

package cn.kstar.leetcode;

/**
 * <h6>柱状图中最大的矩形
 * <br/>Largest Rectangle in Histogram</h6>
 *
 * <p>给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <br/>Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 * <pre>
 *               6
 *             +———+
 *           5 |   |
 *         +———+   |
 *         |   |   |
 *         |   |   |
 *         |   |   |     3
 *         |   |   |   +———+
 *   2     |   |   | 2 |   |
 * +———+   |   |   +———+   |
 * |   | 2 |   |   |   |   |
 * |   +———+   |   |   |   |
 * |   |   |   |   |   |   |
 * +———+———+———+———+———+———+
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 *               6
 *             +———+
 *           5 |   |
 *         +———+———+
 *         |///|///|
 *         |///|///|
 *         |///|///|     3
 *         |///|///|   +———+
 *   2     |///|///| 2 |   |
 * +———+   |///|///+———+   |
 * |   | 2 |///|///|   |   |
 * |   +———+///|///|   |   |
 * |   |   |///|///|   |   |
 * +———+———+———+———+———+———+
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * </pre>
 * <pre><b>Example: </b>
 * Input: [2,1,5,6,2,3]
 * Output: 10
 * </pre>
 */
public class LeetCode84 {

    /**
     * <p><b>解题思路：</b>
     * <br/>使用栈作为辅助工具，比当前栈栈顶元素大的入栈；小于当前栈顶元素则进行比较运算。
     * <br/>栈顶元素的左边界为栈顶上一个元素，右边界为小于当前栈顶的元素的值。</p>
     * 
     * @param  heights
     * @return int
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        if (heights == null || heights.length == 0) {
            return maxArea;
        }

        int len = heights.length;
        // 存储矩形数组索引值的栈
        int[] stack = new int[len + 1];
        stack[0] = -1;
        // 栈顶指针
        int top = 0;
        for (int i = 0; i < len; i++) {
            while (stack[top] != -1 && heights[stack[top]] > heights[i]) {
                int peek = stack[top--];
                int temp = heights[peek] * (i - 1 - stack[top]);
                maxArea = (maxArea > temp) ? maxArea : temp;
            }
            stack[++top] = i;
        }

        // 在最大右边界求面积的最大值
        while (stack[top] != -1) {
            int peek = stack[top--];
            int temp = heights[peek] * (len - 1 - stack[top]);
            maxArea = (maxArea > temp) ? maxArea : temp;
        }
        return maxArea;
    }

    /**
     * <h6>使用二分治法</h6>
     * 
     * @param  heights
     * @return int
     */
    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        return largestRecusion(heights, 0, heights.length - 1, heights[0]);
    }

    /**
     * <h6>递归地获取区间内面积的最大值</h6>
     *
     * @param heights
     * @param start
     * @param end
     * @param max
     * @return
     */
    private int largestRecusion(int[] heights, int start, int end, int max) {
        if (start >= end) {
            return max;
        }

        int minIndex = getMinIndex(heights, start, end);
        int currentArea = heights[minIndex] * (end - start + 1);
        max = (max > currentArea) ? max : currentArea;

        int leftMax = largestRecusion(heights, start, minIndex - 1, heights[start]);
        int rightMax = largestRecusion(heights, minIndex + 1, end, heights[end]);
        int tempMax = (leftMax > rightMax) ? leftMax : rightMax;
        return max > tempMax ? max : tempMax;
    }

    /**
     * <h6>寻找值最小的坐标</h6>
     * 
     * @param  heights
     * @param  start
     * @param  end
     * @return int
     */
    private int getMinIndex(int[] heights, int start, int end) {
        int min = 0X7FFFFFFF;
        int minIndex = start;
        for (int i = start; i <= end; i++) {
            if (min > heights[i]) {
                min = heights[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}

package kstar.leetcode_cn.leetcode._0011;

/**
 * <h6>盛最多水的容器</h6>
 *
 * <p>给定 n个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i,ai)。
 * <br/>在坐标内画 n条垂直线，垂直线 i的两个端点分别为 (i,ai)和 (i,0)。
 * <br/>找出其中的两条线，使得它们与 x轴共同构成的容器可以容纳最多的水。
 * <br/>说明：你不能倾斜容器，且 n的值至少为 2。</p>
 * <pre>
 *  ^
 *  |
 * 8|_    
 *  |     |              |
 * 7|_    |______________|______
 *  |     |              |     |
 * 6|_    |              |     |
 *  |     |  |           |     |
 * 5|_    |  |           |     |
 *  |     |  |     |     |     |
 * 4|_    |  |     |     |     |
 *  |     |  |     |  |  |     |
 * 3|_    |  |     |  |  |     |
 *  |     |  |     |  |  |  |  |
 * 2|_    |  |     |  |  |  |  |
 *  |     |  |  |  |  |  |  |  |
 * 1|_    |  |  |  |  |  |  |  |
 *  |  |  |  |  |  |  |  |  |  |
 * 0|__|__|__|__|__|__|__|__|__|__________>
 * 
 * <p>图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。</p>
 * Input: [1,8,6,2,5,4,8,3,7]; Output: 49
 * </pre>
 */
public class LeetCode11 {

    /**
     * <h6>双指针法</h6>
     * 
     * <p>使用双指针来解决此问题，左指针为数组起始位置，右指针为数组终止位置，然后计算此时左右指针包含的面积
     * <br/>（注意，计算面积时的高度为左右指针指向的数据取较小的那一个），然后移动指针，移动规则为移动指针指向数据较小的指针（左指针向右移动，右指针向左移动）。
     * <br/>当左右指针指向同一个数据时，则退出循环，最大的面积即为所求的值。</p>
     * @param  heights
     * @return int
     */
    public int maxArea(int[] heights) {
        // 面积
        int result = 0;
        // 左指针
        int left = 0;
        // 右指针
        int right = heights.length - 1;

        while (left < right) {
            // 选择两边较小的高度的为容器的高度
            int height = heights[left] > heights[right] ? heights[right] : heights[left];
            int area = height * (right - left);
            // 保留最大面积
            result = result > area ? result : area;
            // 移动较小数据的指针
            if (heights[left] < heights[right]) {
                // 左指针右移
                ++left;
            } else {
                // 右指针左移
                --right;
            }
        }
        return result;
    }
}

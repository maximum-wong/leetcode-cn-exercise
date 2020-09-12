package kstar.leetcode_cn.leetcode._0042;

/**
 * <h6>双指针法</h6>
 */
public class Solution {

    public int trap(int[] height) {
        if (height==null || height.length<3)
            return 0;

        int left = 0;
        int right = height.length-1;
        int res = 0;

        int lMax = height[left];
        int rMax = height[right];

        while (left<right) {
            if (height[left]<height[right]) {
                if (height[left]>lMax) {
                    lMax=height[left];
                } else if (height[left]<lMax) {
                    res+= lMax-height[left];
                }
                left++;
            } else {
                if (height[right]>rMax) {
                    rMax=height[right];
                } else if (height[right]<rMax) {
                    res+=rMax-height[right];
                }
                right--;
            }
        }
        return res;
    }
}

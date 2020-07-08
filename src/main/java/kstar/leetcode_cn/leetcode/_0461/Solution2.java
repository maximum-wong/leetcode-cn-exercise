package kstar.leetcode_cn.leetcode._0461;

/**
 * <h6>布莱恩·克尼根算法<h6/>
 * <p>通过n&(n-1)来消除n最右侧1的比特位，来减少移动次数，提高算法效率</p>
 */
public class Solution2 {

    public int hammingDistance(int x, int y) {
        int xXORy = x ^ y; // 异或获取不同的bit位
        int distance = 0;
        while (xXORy != 0) {
            distance += 1;
            xXORy = xXORy & (xXORy - 1);
        }
        return distance;
    }
}

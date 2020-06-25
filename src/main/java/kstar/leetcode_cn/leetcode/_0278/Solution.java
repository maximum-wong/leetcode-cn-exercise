package kstar.leetcode_cn.leetcode._0278;

/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */
class VersionControl {

    private boolean[] versions = new boolean[1024];

    boolean isBadVersion(int version) {
        return versions[version - 1];
    }
}

/**
 * <h6>二分法</h6>
 */
public class Solution extends VersionControl {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // 是坏的版本，坏的一定在mid及mid左边
            if (isBadVersion(mid)) {
                right = mid;
            } else { // 不是坏的版本，坏的在mid的右边
                left = mid + 1;
            }
        }
        // 返回left，一定是第一个错误版本
        return left;
    }
}

package kstar.leetcode_cn.leetcode._0165;

/**
 * <h6>分别同时取出两个version的每段相同的版本号进行比较</h6>
 */
public class Solution2 {

    public int compareVersion(String version1, String version2) {
        int idx1 = 0;
        int idx2 = 0;
        int len1 = version1.length();
        int len2 = version2.length();

        int value1 = 0;
        int value2 = 0;
        int[] res = null;
        while (idx1 < len1 || idx2 < len2) {
            res = getNextChunk(version1, idx1, len1);
            idx1 = res[0];
            value1 = res[1];

            res = getNextChunk(version2, idx2, len2);
            idx2 = res[0];
            value2 = res[1];

            if (value1 != value2) {
                return value1 > value2 ? 1 : -1;
            }
        }

        return 0;
    }

    private int[] getNextChunk(String version, int idx, int len) {
        if (idx > len - 1) {
            return new int[]{idx, 0};
        }

        int value;
        int pEnd = idx;
        while (pEnd < len && version.charAt(pEnd) != '.') {
            ++pEnd;
        }

        if (pEnd != len - 1) {
            value = Integer.parseInt(version.substring(idx, pEnd));
        } else {
            value = Integer.parseInt(version.substring(idx, len));
        }

        idx = pEnd + 1;

        return new int[]{idx, value};
    }

}

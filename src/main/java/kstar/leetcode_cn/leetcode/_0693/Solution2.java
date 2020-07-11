package kstar.leetcode_cn.leetcode._0693;

/**
 * <p>交替位二进制数有个性质： n^(n>>>1)得到一个bit位上全为1的二进制数m，所以m&(m+1)==0</p>
 */
public class Solution2 {

    public boolean hasAlternatingBits(int n) {
        n = (n ^ (n >>> 1));
        return (n & ((long) n + 1)) == 0;
    }
}

package kstar.leetcode_cn.leetcode._0136;

public class Solution {

    /**
     * <h6>使用异或</h6>
     * 
     * <p>A^A=0, A^0=A, A^B^B=A</p>
     * 
     * @param array
     * @return
     */
    public int singleNumber(int[] array) {
        int ret = array[0];
        for (int i = 1, length = array.length; i < length; i++) {
            ret ^= array[i];
        }
        return ret;
    }
}

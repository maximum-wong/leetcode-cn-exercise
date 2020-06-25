package kstar.leetcode_cn.leetcode._0035;

public class Solution2 {

    /**
     * <h6>遍历搜索法</h6>
     * 
     * @param  array
     * @param  target
     * @return int
     */
    public int searchInsertPostion(int[] array, int target) {
        if (array == null) {
            return 0;
        }
        int i = 0;
        for (int length = array.length; i < length; i++) {
            if (array[i] >= target) {
                return i;
            }
        }
        return i;
    }
    
}

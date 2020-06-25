package kstar.leetcode_cn.leetcode._0367;

/**
 * <h6>奇数累加法</h6>
 * <p>1=1<br/>
 * 4=1+3<br/>
 * 9=1+3+5<br/>
 * 16=1+3+5+7</p>
 * 
 */
public class Solution {

    public boolean isPerfectSquare(int num) {
        if (num <= 0) {
            return false;
        }

        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}

package kstar.leetcode._0172;

/**
 * <h6>数学方法求解</h6>
 * <p>因为一对2和5能产生一个0，则5!=5**4*3*2*1，就有一个0<br/>
 * 当n=25时，25!=就有25/5=5个0，又因为5*5=25，则就有6个<br/>
 * 以此类推，0的个数为：n/5+n/25+n/125+...</p>
 */
public class Solution {

    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }

        return count;
    }
}

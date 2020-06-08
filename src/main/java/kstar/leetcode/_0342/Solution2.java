package kstar.leetcode._0342;

/**
 * <h6>位操作+数学运算法</h6>
 * <p>4的n次幂(n>0)的数一定是2的k次幂(k>0)的数，则4^n=2^k=2^(2n)。<br/>
 * 4^n = (3+1)^n = (3+1)*(3+1)^(n-1)= 3*(3+1)^(n-1)+(3+1)^(n-1);<br/>
 * ∵3*(3+1)^(n-1) mod 3 =0，则3*(3+1)^(n-2) mod = 0,<br/>
 * 以此类推，n->n-1->n-2->...->1，最终得到：(3+1)^1 mod 3 = 1<br/>
 * ∴4^n mod 3 =1</p>
 */
public class Solution2 {

    public boolean isPowerOfFour(int num) {

        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }
}

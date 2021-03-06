package kstar.leetcode_cn.leetcode._0191;

/**
 * <h6>位 1 的个数</h6>
 *
 * <p>编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。</p>
 * <pre><b>Examples: </b>
 * <b>Example 1: </b>
 * Input：00000000000000000000000000001011; Output: 3
 * Explanation: 输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 
 * <b>Example 2: </b>
 * Input：00000000000000000000000010000000; Output: 1
 * Explanation: 输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 
 * <b>Example 3: </b>
 * Input：11111111111111111111111111111101; Output: 31
 * Explanation: 输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 * </pre>
 * <b>提示：</b>
 * <ul>
 * <li>请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，
 * <br/>并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。</li>
 * <li>在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。</li>
 * </ul>
 * <b>进阶：</b>
 * <p>如果多次调用这个函数，你将如何优化你的算法？</p>
 */
public class LeetCode191 {

    /**
     * <h6>位操作法</h6>
     *
     * @param  n
     * @return int
     */
    public int hammingWeight(int n) {
        int cnt = 0;
        // 位操作法，统计被消除的末尾的'1'的个数
        while (n != 0) {
            cnt++;
            // 消除末尾的1
            n = n & (n - 1);
        }
        return cnt;
    }

    /**
     * <h6>位移法<h6>
     *
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int cnt = 0;
        // 无符号右移，统计末尾'1'的个数
        while (n != 0) {
            cnt += n & 1;
            n = n >>> 1;
        }
        return cnt;
    }
}

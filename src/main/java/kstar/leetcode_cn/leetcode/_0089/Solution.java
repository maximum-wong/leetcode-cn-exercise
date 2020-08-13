package kstar.leetcode_cn.leetcode._0089;

import java.util.ArrayList;
import java.util.List;

/**
 * <h6>公式法：G(n) = B(n+1) XOR B(n)，G：格雷码 B：二进制码 n：正在计算的位</h6>
 */
public class Solution {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<(1<<n); i++) {
            res.add(i^(i>>1));
        }
        return res;
    }
}

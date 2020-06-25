package kstar.leetcode_cn.leetcode._0119;

import java.util.ArrayList;
import java.util.List;

/**
 * <h6>排列组合公式法</h6>
 * <p>杨辉三角每一行数字都可以表示为：C<sup>0</sup><sub>n</sub>, 
 * C<sup>1</sup><sub>n</sub>, C<sup>2</sup><sub>n</sub>, ..., C<sup>n</sup><sub>n</sub><br/>
 * C<sup>k</sup><sub>n</sub> = n!/(k!(n-k)!)=(n*(n-1)*(n-2)*...(n-k+1))/k!<br/>
 * C<sup>k</sup><sub>n</sub> = C<sup>k-1</sup><sub>n</sub> × (n - k + 1)/k
 * </p>
 */
public class Solution2 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        int n = rowIndex;
        long pre = 1;
        res.add(1);
        for (int k = 0; k <= n; k++) {
            long cur = pre * (n - k + 1) / k;
            res.add((int) cur);
            pre = cur;
        }
        return res;
    }
}

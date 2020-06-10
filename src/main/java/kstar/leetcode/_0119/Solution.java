package kstar.leetcode._0119;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        res.add(1); // 添加第0行
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 1; j--) {
                res.set(j - 1, res.get(j - 2) + res.get(j - 1));
            }
            res.add(1); // 行末尾设置为1
        }
        return res;
    }
    
}

package kstar.leetcode._0118;

import java.util.ArrayList;
import java.util.List;

/**
 * <h6>杨辉三角</h6>
 *
 * <p>给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <br/>在杨辉三角中，每个数是它左上方和右上方的数的和。</p>
 * <pre><b>Examples: </b>
 * Input: 5
 * Output:
 * [
 *     [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * </pre>
 */
public class LeetCode118 {

    /**
     * <p><b>解题思路：</b>
     * <br/>每次添加层数时复制上一层的元素，且在头部添加元素1；
     * <br/>按照规律做加法：a[j]= a[j]+[j+1]</p>
     * <pre>
     *            1)   1     2)   1
     * 1 ->  1  ->    1 1  ->    1 1  
     *      1 1      1 1 1      1 2 1
     *
     *   1)    1      2)    1      3)   1
     * ->     1 1   ->     1 1   ->    1 1
     *       1 2 1        1 2 1       1 2 1
     *      1 1 2 1      1 3 2 1     1 3 3 1
     * </pre>
     * 
     * @param  numRows
     * @return List<List<Integer>>
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allRows = new ArrayList<>();
        if (numRows <= 0) {
            return allRows;
        }

        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            // 按照规律处理这一层元素
            for (int j = 1, position = row.size() - 1; j < position; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            // 复制这一层的元素
            allRows.add(new ArrayList<>(row));
        }
        return allRows;
    }

}

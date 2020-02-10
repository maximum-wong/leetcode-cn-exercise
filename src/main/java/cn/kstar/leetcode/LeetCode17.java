package cn.kstar.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h6>电话号码的字母组合</h6>
 *
 * <p>给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <br/>给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *   ________________________________________
 *   |   ________    ________    ________   |
 *   |   |1 o_o |    |2 abc |    |3 def |   |
 *   |   |______|    |______|    |______|   |
 *   |   ________    ________    ________   |
 *   |   |4 ghi |    |5 jkl |    |6 mno |   |
 *   |   |______|    |______|    |______|   |
 *   |   ________    ________    ________   |
 *   |   |7 pqrs|    |8 tuv |    |9 wxyz|   |
 *   |   |______|    |______|    |______|   |
 *   |   ________    ________    ________   |
 *   |   |* +   |    |0 i_i |    |^ #   |   |
 *   |   |______|    |______|    |______|   |
 *   |______________________________________|
 *
 * <pre><b>Examples: </b>
 * Input: "23"; Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Explanation: 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * </pre>   
 * </p>
 */
public class LeetCode17 {

    // 保存映射关系
    private static final String[][] numberList = new String[][] { 
        { "a", "b", "c" },
        { "d", "e", "f" },
        { "g", "h", "i" },
        { "j", "k", "l" },
        { "m", "n", "o" },
        { "p", "q", "r", "s" },
        { "t", "u", "v" },
        { "w", "x", "y", "z" },
    };

    /**
     * <h6>递归法</h6>
     * 
     * @param  digits
     * @return List<String>
     */
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // 获取第一个数字映射的字母序列
        int first = digits.charAt(0) - 48 - 2;
        String[] current = numberList[first];

        if (digits.length() == 1) {
            result.addAll(Arrays.asList(current));
            return result;
        }

        // 递归地处理第一个数字以后的字符串
        List<String> leftList = letterCombinations(digits.substring(1));

        // 拼接递归返回的结果
        for (String aCurrent : current) {
            for (String str : leftList) {
                result.add(aCurrent + str);
            }
        }
        return result;
    }
}

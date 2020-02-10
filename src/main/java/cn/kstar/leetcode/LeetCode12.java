package cn.kstar.leetcode;

/**
 * <h6>反转罗马数字</h6>
 *
 * <p>罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。</p>
 * <pre>
 * <b>字符</b> <b>数值</b>
 *    I           1
 *    V           5
 *    X           10
 *    L           50
 *    C           100
 *    D           500
 *    M           1000
 * </pre>
 * <p>例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。</p>
 * <p>通常情况下，罗马数字中小的数字在大的数字的右边。
 * <br/>但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * <br/>同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <li>I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。</li>
 * <li>X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 </li>
 * <li>C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。</li>
 * </p>
 * <p>给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。</p>
 * <pre><b>Examples:</b>
 * Input: 3，Output: "III"
 * Input: 4，Output: "IV"
 * Input: 9，Output: "IX"
 * Input: 58，Output: "LVIII"，解释: C = 100, L = 50, XXX = 30, III = 3
 * Input: 1994，Output: "MCMXCIV"，解释: M = 1000, CM = 900, XC = 90, IV = 4
 * </pre>
 */
public class LeetCode12 {

    public String arabicNumeralsConverToRomanNumeral(int number) {
        if ((number < 1) && (number > 3999)) {
            return "";
        }
        // 建立映射关系
        int[] numbers = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] flags = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder ret = new StringBuilder(26);
        for (int i = 0; (i < 13 && number > 0); i++) {
            if (number < numbers[i]) { // 当前数小于标记数
                continue;
            }
            while (number >= numbers[i]) { // 当前数大于标记数
                number -= numbers[i];
                ret.append(flags[i]);
            }
        }
        return ret.toString();
    }
}

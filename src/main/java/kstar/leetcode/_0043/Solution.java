package kstar.leetcode._0043;

/**
 * 时间复杂度：O(m*n)；空间复杂度：O(m+n)
 */
public class Solution {

    public String multiply(String num1, String num2) {

        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()
                || "0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        // 用来保存计算过程中的结果（m位乘以n位最多为m+n位结果）
        int[] tmp = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                // 计算某位上的值
                int calculate = tmp[i + j + 1] + n1 * n2;
                // 某位上取模
                tmp[i + j + 1] = calculate % 10;
                // 进位处理
                tmp[i + j] += calculate / 10;
            }
        }

        // 拼接结果
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmp.length; i++) {
            if (i == 0 && tmp[i] == 0) {
                continue;
            }
            sb.append(tmp[i]);
        }

        return sb.toString();
    }
}

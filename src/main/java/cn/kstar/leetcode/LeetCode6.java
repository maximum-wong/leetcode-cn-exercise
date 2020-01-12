package cn.kstar.leetcode;

/**
 * <h3>Zig Zag</h3>
 * Z字型变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。比如输入字符串为 "LEETCODEISHIRING"行数为3时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如： "LCIRETOESIIGEDHN"
 * 
 * 请你实现这个将字符串进行指定行数变换的函数：string convert(string s, int numRows);
 * Example 1:
 * Input: s = "LEETCODEISHIRING", numRows = 3
 * Output: "LCIRETOESIIGEDHN"
 * Example 2:
 * Input: s = "LEETCODEISHIRING", numRows = 4
 * Output: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class LeetCode6 {

    public String convert(String input, int numRows) {
        char[] array = input.toCharArray();
        int length = input.length();
        char[][] zigzagCharArray = new char[numRows][length/(numRows-1)];
        return null;
    }
}

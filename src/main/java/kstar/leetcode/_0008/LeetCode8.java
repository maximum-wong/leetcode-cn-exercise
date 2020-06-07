package kstar.leetcode._0008;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>字符串转换整数</h3>
 * 
 * <p>请你来实现一个 atoi函数，使其能将字符串转换成整数。
 * <br/>首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <br/>当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * <br/>假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <br/>该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <br/>注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <br/>在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <br/>说明： 假设我们的环境只能存储32位大小的有符号整数，那么其数值范围为 [−2^31,2^31−1]。
 * <br/>如果数值超过这个范围，请返回 INT_MAX(2^31−1)或 INT_MIN(−2^31) 。</p>
 * <pre><b>Examples: </b>
 * Example1: Input: "42"; Output: 42
 * 
 * Example2: Input: "   -42"; Output: -42
 * Explanation: 第一个非空白字符为 '-', 它是一个负号。我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42。
 * 
 * Example3: Input: "4193 with words"; Output: 4193
 * Explanation: 转换截止于数字 '3'，因为它的下一个字符不为数字。
 * 
 * Example4: Input: "-91283472332"; Output: -2147483648
 * Explanation: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * </pre>
 */
public class LeetCode8 {

    public int myAtoi(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int index = 0;
        // 标志该数是整数还是负数
        int sign = 1;
        // 接收转换结果
        long sum = 0;

        // 去掉开头空格部分
        while ((index < length) && (charArray[index] == ' '))
            index++;

        // 判断是否为符号位，当为+时，sign=1；当为-时，sign=-1
        if ((index < length) && ((charArray[index] == '+') || (charArray[index] == '-'))) {
            sign = (charArray[index] == '+') ? 1 : -1;
            index++;
        }

        // 遍历字符数组
        while (index < length) {
            // 判断是否为数字
            if ((charArray[index] >= '0') && (charArray[index] <= '9')) {
                sum = sum * 10 + charArray[index] - '0';
                // 判断结果是否溢出
                if ((sign == 1) && (sum > 0X7FFFFFFF)) {
                    return 0X7FFFFFFF;
                } else if ((sign == -1) && ((-1 * sum) < 0X80000000)) {
                    return 0X80000000;
                }
            } else {
                break;
            }
        }
        return (int) (sign * sum);
    }
    
    /**
     * <h6>DFA法</h6>
     * <table border="1px">
     * <tr><td></td><td>''</td><td>+/-</td><td>NUMBER</td><td>OTHER</td></tr>
     * <tr><td>START</td><td>START</td><td>SIGNED</td><td>NUMBER</td><td>END</td></tr>
     * <tr><td>SIGNED</td><td>END</td><td>END</td><td>NUMBER</td><td>END</td></tr>
     * <tr><td>NUMBER</td><td>END</td><td>END</td><td>NUMBER</td><td>END</td></tr>
     * <tr><td>END</td><td>END</td><td>END</td><td>END</td><td>END</td></tr>
     * </table>
     */
    public int myAtoi2(String str) {
        Automation automation = new Automation();
        char[] c = str.toCharArray();
        for (char ch : c) {
            automation.get(ch);
        }
        return automation.getResult();
    }
    
    private class Automation {

        private static final String START = "start";
        private static final String SIGNED = "signed";
        private static final String NUMBER = "number";
        private static final String END = "end";

        private String status = START;
        private int sign = 1;
        private long ans = 0;
        private Map<String, String[]> map;

        public Automation() {
            map = new HashMap<>();
            map.put(START, new String[] { START, SIGNED, NUMBER, END });
            map.put(SIGNED, new String[] { END, END, NUMBER, END });
            map.put(NUMBER, new String[] { END, END, NUMBER, END });
            map.put(END, new String[] { END, END, END, END });
        }

        private int getCol(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (c >= '0' && c <= '9') {
                return 2;
            }
            return 3;
        }

        public void get(char c) {
            status = map.get(status)[getCol(c)];
            if (NUMBER.equals(status)) {
                ans = ans * 10 + c - '0';
                if (sign == 1) {
                    ans = ans < 0X7FFFFFFF ? ans : 0X7FFFFFFF;
                } else {
                    ans = ans < -1 * ((long) 0X80000000) ? ans : -1*(long)0X80000000;
                }
            } else if (SIGNED.equals(status)) {
                sign = (c == '+') ? 1 : -1;
            }
        }

        public int getResult() {
            return (int)(sign * ans);
        }
    }
    
    private enum DFA {
        START,
        SIGNED,
        NUMBER,
        END
    }
    
    private static class Automation2 {

        // 自动机初始状态
        private DFA state = DFA.START;

        // 符号位
        private char sign = '+';

        // 记录结果
        private int result = 0;

        // 终止条件
        private boolean flag = true;

        // 状态流转表
        private static Map<DFA, DFA[]> map;

        static {
            map = new HashMap<>(4);
            map.put(DFA.START, new DFA[] { DFA.START, DFA.SIGNED, DFA.NUMBER, DFA.END });
            map.put(DFA.SIGNED, new DFA[] { DFA.END, DFA.END, DFA.NUMBER, DFA.END });
            map.put(DFA.NUMBER, new DFA[] { DFA.END, DFA.END, DFA.NUMBER, DFA.END });
            map.put(DFA.END, new DFA[] { DFA.END, DFA.END, DFA.END, DFA.END });
        }

        public int getResult() {
            return result;
        }

        public boolean getFlag() {
            return flag;
        }

        private int getIndex(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (c >= '0' && c <= '9') {
                return 2;
            }
            return 3;
        }

        public void getInteger(char c) {
            // 获取当前状态
            state = map.get(state)[getIndex(c)];

            switch (state) {
            case NUMBER:
                if ((sign == '+') && (result > 0X7FFFFFFF / 10 || (result == 0X7FFFFFFF / 10 && c - '0' > 7))) {
                    result = 0X7FFFFFFF;
                    flag = false;
                    break;
                } else if ((sign == '-') && (result < 0X80000000 / 10 || (result == 0X80000000 / 10 && c - '0' > 8))) {
                    result = 0X80000000;
                    flag = false;
                    break;
                }
                result = (sign == '+') ? (result * 10 + c - '0') : (result * 10 - (c - '0'));
                break;
            case SIGNED:
                sign = c;
                break;
            case END:
                flag = false;
                break;
            default:
                break;
            }
        }
    }
    
    public int myAtoi3(String str) {
        if (str==null || str.length()==0) {
            return 0;
        }
        
        Automation2 automation = new Automation2();
        
        for (int i = 0, len = str.length(); i < len; i++) {
            if (automation.getFlag()) {
                automation.getInteger(str.charAt(i));
            } else {
                break;
            }
        }
        
        return automation.getResult();
    }
    
}

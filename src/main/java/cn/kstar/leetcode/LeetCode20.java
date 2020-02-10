package cn.kstar.leetcode;

/**
 * <h6>有效的括号</h6>
 * 
 * <p>给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <br/>有效字符串需满足：
 * <li>左括号必须用相同类型的右括号闭合。</li>
 * <li>左括号必须以正确的顺序闭合。</li>
 * <li>注意空字符串可被认为是有效字符串。</li></p>
 * <p><b>Examples:<b>
 * <br/>输入: "()"；输出: true
 * <br/>输入: "()[]{}"；输出: true
 * <br/>输入: "(]"；输出: false
 * <br/>输入: "([)]"；输出: false、
 * <br/>输入: "{[]}"；输出: true
 * </p>
 */
public class LeetCode20 {

    public boolean isValid(String s) {
        int length = s.length();
        // 存放左括号的栈
        char[] stack = new char[length];
        // 栈顶指针
        int top = -1;
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            // 如果是左括号，进栈操作
            if (ch == '[' || ch == '(' || ch == '{') {
                stack[++top] = ch;
            }
            // 如果是右括号，判断当前括号是否与栈顶的括号配对，若符合，出栈操作
            if (ch == ']' || ch == ')' || ch == '}') {
                if (top == -1 || stack[top--] != getTheLeft(ch)) {
                    return false;
                }
            }
        }
        return top == -1;
    }

    private char getTheLeft(char ch) {
        char ret;
        switch (ch) {
        case ']':
            ret = '[';
            break;
        case ')':
            ret = '(';
            break;
        case '}':
            ret = '{';
            break;
        default:
            ret = '\u0000';
        }
        return ret;
    }
}

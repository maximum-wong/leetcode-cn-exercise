package kstar.leetcode_cn.leetcode._0020;

/**
 * <h6>有效的括号
 * <br/>Valid Parentheses</h6>
 * 
 * <p>给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <br/>Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.</p>
 * <p>有效字符串需满足：
 * <br/>An input string is valid if: <ol>
 * <li>左括号必须用相同类型的右括号闭合。
 * <br/>Open brackets must be closed by the same type of brackets.</li>
 * <li>左括号必须以正确的顺序闭合。
 * <br/>Open brackets must be closed in the correct order.</li></ol>
 * 注意空字符串可被认为是有效字符串。
 * <br/>Note that an empty string is also considered valid.</p>
 * <pre><b>Examples: </b>
 * <b>Example1: </b>
 * Input: "()"
 * Output: true
 *
 * <b>Example2: </b>
 * Input: "()[]{}"
 * Output: true
 *
 * <b>Example3: </b>
 * Input: "(]"
 * Output: false
 *
 * <b>Example4: </b>
 * Input: "([)]"
 * Output: false
 *
 * <b>Example5: </b>
 * Input: "{[]}"
 * Output: true
 * <pre>
 */
public class LeetCode20 {

    public boolean isValid(String s) {
        // 优化：字符串长度为奇数，不能优化
        if ((s == null) || (s.length() ==0)|| (s.length() & 1) == 1) {
            return false;
        }

        // 存放左括号的栈
        int length = s.length();
        char[] stack = new char[length];
        // 栈顶指针
        int top = -1;
        char ch;
        for (int i = 0; i < length; i++) {
            ch = s.charAt(i);
            // 如果是左括号，进栈操作
            if ((ch == '[') || (ch == '(') || (ch == '{')) {
                stack[++top] = ch;
                // 优化：如果栈中的元素超过一半，表明左括号过多，不能匹配
                if ((top + 1) > (length / 2)) {
                    return false;
                }
            }
            // 如果是右括号，判断当前括号是否与栈顶的括号配对，若符合，出栈操作
            if ((ch == ']') || (ch == ')') || (ch == '}')) {
//                if (top == -1 || stack[top--] != getTheLeft(ch)) {
//                    return false;
//                }
                // 优化：修改左右括号配对条件，左括号的ASCII码值与左括号的相差1或2
                if ((top == -1) || (ch - stack[top] > 2) || (ch - stack[top] < 1)) {
                    return false;
                }
                top--;
            }
        }
        return top == -1;
    }

//    private char getTheLeft(char ch) {
//        char ret;
//        switch (ch) {
//        case ']':
//            ret = '[';
//            break;
//        case ')':
//            ret = '(';
//            break;
//        case '}':
//            ret = '{';
//            break;
//        default:
//            ret = '\u0000';
//        }
//        return ret;
//    }
}

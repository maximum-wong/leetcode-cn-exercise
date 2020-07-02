package kstar.leetcode_cn.leetcode._0071;

import java.util.LinkedList;

public class Solution {

    public String simplifyPath(String path) {
        
        // 用"/"分割字符串得到目录数组
        String[] dirs = path.split("/");
        
        // 把符合规范的dir放在栈中
        LinkedList<String> stack = new LinkedList<String>();
        for (String dir : dirs) {
            // 处理".."的特殊规则，弹出栈顶元素
            if (!stack.isEmpty() && "..".equals(dir)) {
                stack.removeLast();
            // 添加符合规范的元素到栈中
            } else if (!"".equals(dir) && !".".equals(dir) && !"..".equals(dir)) {
                stack.add(dir);
            }
        }
        
        if (stack.isEmpty()) {
            return "/";
        }
        
        StringBuilder sb = new StringBuilder(stack.size());
        for (String dir : stack) {
            sb.append("/").append(dir);
        }
        
        return sb.toString();
    }
}

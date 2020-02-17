package cn.kstar.leetcode;

import java.util.Stack;

/**
 * <h6>最小栈
 * <br/>Min Stack</h6>
 *
 * <p>设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <br/>Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <li>push(x) -- 将元素 x 推入栈中。<br/>push(x) -- Push element x onto stack.</li>
 * <li>pop() -- 删除栈顶的元素。<br/>pop() -- Removes the element on top of the stack.</li>
 * <li>top() -- 获取栈顶元素。<br/>top() -- Get the top element.</li>
 * <li>getMin() -- 检索栈中的最小元素。<br/>getMin() -- Retrieve the minimum element in the stack.</li></ul></p>
 * <pre><b>Example: </b>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * </pre>
 */
public class LeetCode155 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        System.out.println("min=" + min);
        minStack.pop();
        int top = minStack.top();
        System.out.println("top=" + top);
        int min2 = minStack.getMin();
        System.out.println("min2=" + min2);
    }
}

class MinStack {

    // 初始化栈
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> assistStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
        // 先加入int最大值在栈底，避免判断辅助栈为空
        assistStack.push(0X7FFFFFFF);
    }

    /**
     * <h6>向栈中添加元素</h6>
     * 
     * @param x
     */
    public void push(int x) {
        mainStack.push(x);
        // 不大于辅助栈栈顶的元素，加入到辅助栈中
        if (assistStack.peek() >= x) {
            assistStack.push(x);
        }
    }

    /**
     * <h6>弹出栈顶元素</h6>
     */
    public void pop() {
        int top = mainStack.pop();
        // 如果弹出的栈顶元素与辅助栈的栈顶元素相同，就把辅助栈的栈顶元素弹出来
        if (top == assistStack.peek()) {
            assistStack.pop();
        }
    }

    /**
     * <h6>获取栈顶元素</h6>
     * 
     * @return int
     */
    public int top() {
        return mainStack.peek();
    }

    /**
     * <h6>获取栈中最小元素</h6>
     * 
     * @return int
     */
    public int getMin() {
        return assistStack.peek();
    }
}
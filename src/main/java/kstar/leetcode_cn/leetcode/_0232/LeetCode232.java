package kstar.leetcode_cn.leetcode._0232;

import java.util.Stack;

/**
 * <h6>用栈实现队列</h6>
 *
 * <p>使用栈实现队列的下列操作：
 * <br/>Implement the following operations of a queue using stacks.</p>
 * <ul>
 * <li>push(x) -- 将一个元素放入队列的尾部。
 * <br/>push(x) -- Push element x to the back of queue.</li>
 * <li>pop() -- 从队列首部移除元素。
 * <br/>pop() -- Removes the element from in front of queue.</li>
 * <li>peek() -- 返回队列首部的元素。
 * <br/>peek() -- Get the front element.</li>
 * <li>empty() -- 返回队列是否为空。
 * <br/>empty() -- Return whether the queue is empty.</li>
 * </ul>
 * <p><b>Example: </b></p>
 * <pre>
 * MyQueue queue = new MyQueue();
 * 
 * queue.push(1);
 * queue.push(2);  
 * queue.peek();  // 返回 1     returns 1
 * queue.pop();   // 返回 1     returns 1
 * queue.empty(); // 返回 false returns false
 * </pre>
 * <p><b>说明：</b></p>
 * <ul><li>你只能使用标准的栈操作 -- 也就是只有<code>push to top</code>, <code>peek/pop from top</code>, 
 * <code>size</code>, 和 <code>is empty</code> 操作是合法的。
 * <br/>You must use only standard operations of a stack -- which means only <code>push to top</code>, 
 * <code>peek/pop from top</code>, <code>size</code>, and <code>is empty</code> operations are valid.</li>
 * <li>你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * <br/>Depending on your language, stack may not be supported natively. 
 * You may simulate a stack by using a list or deque (double-ended queue), 
 * as long as you use only standard operations of a stack.</li>
 * <li>假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * <br/>You may assume that all operations are valid (for example, 
 * no pop or peek operations will be called on an empty queue).</li>
 * </ul>
 */
public class LeetCode232 {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.peek();
        queue.pop();
        queue.empty();
    }
}

class MyQueue {

    // 进栈
    private Stack<Integer> in = new Stack<>();

    // 出栈
    private Stack<Integer> out = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        this.transfer();
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        this.transfer();
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.empty() && out.empty();
    }

    /**
     * <h6>当out栈为空时，进行转换操作</h6>
     */
    private void transfer() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
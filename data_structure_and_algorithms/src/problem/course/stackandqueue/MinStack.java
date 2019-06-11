package problem.course.stackandqueue;

import java.util.Stack;

/**
 * 实现能够返回最小值的特殊的栈
 */
public class MinStack {
    Stack<Integer> data;
    Stack<Integer> min;
    MinStack(){
        data = new Stack<>();
        min = new Stack<>();
    }

    public void insert(int val){
        data.push(val);
        min.push((!min.isEmpty()) && min.peek()<val ? min.peek(): val);
    }

    public int pop(){
        min.pop();
        return data.pop();
    }
}

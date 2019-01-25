package problem;

import java.util.Stack;

public class TwoStackQueue{
    Stack<Integer> stackPush;
    Stack<Integer> stackPop;
    TwoStackQueue(){
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void push(int val){
        stackPush.push(val);
    }

    public int poll(){
        if (stackPush.isEmpty() && stackPop.isEmpty()) throw new RuntimeException("Queue is empty!");
        else if(stackPop.isEmpty()){
            while (!stackPush.isEmpty()) stackPop.push(stackPush.pop());
        }
        return stackPop.peek();
    }

    public int peek(){
        if (stackPush.isEmpty() && stackPop.isEmpty()) throw new RuntimeException("Queue is empty!");
        else if(stackPop.isEmpty()){
            while (!stackPush.isEmpty()) stackPop.push(stackPush.pop());
        }
        return stackPop.pop();
    }
}

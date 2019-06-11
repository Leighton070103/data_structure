package problem.course.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueStack {
    Queue<Integer> pushQue;
    Queue<Integer> popQue;

    public TwoQueueStack(){
        pushQue = new LinkedList<>();
        popQue = new LinkedList<>();
    }

    public void insert(int val){
        pushQue.add(val);
    }

    public int peek() throws Exception {
        while (pushQue.size()>1){
            popQue.add(pushQue.poll());
        }
        if(!pushQue.isEmpty()) {
            int val = pushQue.poll();
            popQue.add(val);
            swap();
            return val;
        }
        throw new Exception();
    }

    public int pop() throws Exception {
        while (pushQue.size()>1){
            popQue.add(pushQue.poll());
        }
        if(!pushQue.isEmpty()) {
            int val = pushQue.poll();
            swap();
            return val ;
        }
        throw new Exception();
    }

    private void swap(){
        Queue<Integer> tmp = pushQue;
        pushQue = popQue;
        popQue = tmp;
    }
}

package problem.dynamicprograming;

import problem.Problem;

import java.util.LinkedList;
import java.util.List;


/**
 * n阶台阶，每次可以上一个台阶，也可以上两个台阶，爬上这样一个楼梯，一共有多少种方法
 */
public class BasicClimbingStairs extends Problem {
    public static void main(String[] args){
//        int n = randomNum();
        int n = 10;
        BasicClimbingStairs b = new BasicClimbingStairs(n);
        System.out.print("到达第" + n + "台阶共有");
        b.solve();

    }

    BasicClimbingStairs(int n){
        this.n = n;
    }
    int n;

    @Override
    public void solve() {
        int twoStep = 1;
        int oneStep = 2;
        int current = 3;
        for (int i=4; i<=n; i++){
            oneStep = current;
            twoStep = oneStep;
            current = twoStep + oneStep;

        }
        System.out.println(current + "种走法");
    }

//    int count(int i){
//        if (i == 1) return 1;
//        if (i == 2) return 2;
//        return count(i-1) + count(i-2);
//    }
}

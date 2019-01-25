import problem.NetherlandFlag;
import problem.Problem;
import problem.SmallSum;
import problem.SmallSum2;

import java.util.Scanner;

import static util.NumUtil.*;

public class Test {

    public static void main(String[] args) {
//        int[] arr = randomArr(100, 20);
//        printArr(arr);
//        System.out.print("Enter number: ");
//        Scanner scanner = new Scanner(System.in);
//        test("Netherland Flag", new NetherlandFlag(copyArray(arr), scanner.nextInt()));
//        test("Small sum", new SmallSum(copyArray(arr)));
//        test("Improved Small sum", new SmallSum2(copyArray(arr)));
    }

    public static void test(String name, Problem p) {
        long start = System.currentTimeMillis();
        System.out.print("[Name: "+ name + "; " );
        p.solve();
        long end = System.currentTimeMillis();
        System.out.println("; Time: " + (end - start) + "]");

    }
}

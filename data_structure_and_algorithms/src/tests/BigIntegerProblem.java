package tests;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerProblem {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        BigInteger num = new BigInteger(scanner.nextLine()) ;
        BigInteger pow = BigInteger.valueOf(2);
        int count = 0;
        while (!num.equals(BigInteger.ZERO)){
           BigInteger[] results =  num.divideAndRemainder(pow);
            count = results[1].equals(BigInteger.ZERO)? count: count + 1;
            num = results[0];
        }
        System.out.println(count+"");
    }
}

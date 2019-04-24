package problem;

import util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.*;


public class TwoArray {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s= s.split("\\[")[1];
        s = s.substring(0, s.length()-1);
        s.replace(",", "");
        int[] arr = new int[s.length()];
        int sum = 0;
        for (int i = 0; i<s.length(); i++){
            arr[i] = Integer.parseInt(s.charAt(i)+"");
            sum += arr[i];
        }

        if (sum%2!=0) return;
        solve(arr, sum/2);



    }

    static void solve(int[] arr, int sum){
        Arrays.sort(arr);
        int[] arr1 = new int[arr.length-1];
        int[] arr2 = new int[arr.length-1];
        int i = arr.length-1;
        int ptr1 = 0;
        int ptr2 = 0;
        int sum1 =0;
        int sum2 =0;
        while (i>=0){
            if ( sum1 < sum2 ) {
                arr1[ptr1++] = arr[i];
                sum1 += arr[i];
            }
            else {
                arr2[ptr2++] = arr[i];
                sum2+=arr[i];
            }
            i--;
        }
        if (sum1!= sum2){
            System.out.println("No result");
        }
        else {
            System.out.print("arr2: [" + arr1[ptr1-1]);
            for (int m = ptr1-2; m>=0; m--) System.out.print(", "+ arr1[m]);
            System.out.print("], arr3: [" + arr2[ptr2-1]);
            for (int n = ptr2-2; n>=0; n--) System.out.print(", "+ arr1[n]);
            System.out.println("], sum="+sum1);
        }

    }



}

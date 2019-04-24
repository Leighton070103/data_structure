package tests.toutiao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = getInt(scanner.nextLine());
        int[] h = new int[n+1];
        h[0]=0;
        String[] s = scanner.nextLine().split(" ");
        for (int i=0; i<n; i++){
            h[i+1] = getInt(s[i]);
        }
        solve(h);
    }

    static void solve(int[] h){
        int[] costs = new int[h.length];
        costs[0] = 0;
        int e = 0;
        costs[h.length-1]=h[h.length-1]-(h[h.length-1]%2==0?h[h.length-1]/2:h[h.length-1]/2+1);
        for (int i=h.length-2; i>=0; i--){
            e+=costs[i+1];
            e = (h[i]+e)%2==0?(h[i]+e)/2:(h[i]+e)/2+1;
            costs[i]=h[i]-e;
        }
        System.out.println(e);
    }

    static boolean isEnough(int e, int h){
        return 2*e-h>=0;
    }

    static int getRes(int e, int h){
        return 2*e-h;
    }

    public static int getInt(String s){
        return Integer.parseInt(s);
    }
}

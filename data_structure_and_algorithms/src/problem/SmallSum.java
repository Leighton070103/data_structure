package problem;

public class SmallSum extends Problem {
    int[] arr;
    public SmallSum(int[] arr){
        this.arr = arr;
        System.out.println("Array length: " + arr.length);
    }


    @Override
    public void solve() {
        //O(N^2)
        int sum = 0;
        for (int nPtr = 1; nPtr < arr.length; nPtr++){
            for (int i = 0; i < nPtr; i++){
                if (arr[nPtr] > arr[i]) sum += arr[i];
            }
        }
        System.out.print("Small sum is " + sum);
    }
}

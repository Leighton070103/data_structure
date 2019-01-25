package problem;

public class SmallSum2 extends Problem {
    int[] arr;
    int sum;
    public SmallSum2(int[] arr){
        this.arr = arr;
        sum = 0;
        System.out.println("Array length: " + arr.length);
    }


    @Override
    public void solve() {
        //O(N^2)
        solve(0, arr.length-1);
        System.out.print("Small sum is " + sum);
    }

    void solve(int left, int right){
        if (left == right) return;
        int mid = (left + right)/2;
        solve(left, mid);
        solve(mid + 1, right);
        compare(left, mid, mid+1, right);
    }

    void compare(int lStart, int lEnd, int rStart, int rEnd){
        int[] tmp = new int[rEnd - lStart+1];
        int lPtr = lStart;
        int rPtr = rStart;
        int nPtr = 0;
        while (lPtr <= lEnd && rPtr <= rEnd){
            if (arr[lPtr] < arr[rPtr]){
                sum += arr[lPtr]*(rEnd-rPtr+1);
                tmp[nPtr++] = arr[lPtr++];
            }
            else {
                tmp[nPtr++] = arr[rPtr++];
            }
        }
        int currentPtr = lPtr <= lEnd ? lPtr : rPtr;
        while ( nPtr < tmp.length){
            tmp[nPtr++] = arr[currentPtr++];
        }

        int i=0;
        while ( i < tmp.length ){
            arr[lStart + i] = tmp[i++];
        }
    }
}

package problem.dynamicprograming;

/**
 * LeetCode 61 —— UniquePath：不同路径
 * 一个机器人位于一个 m x n 网格的左上角
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
 * 问总共有多少条不同的路径？
 */
public class UniquePath {

    public static void main(String[] args){
        UniquePath uniquePath = new UniquePath();
        System.out.println(uniquePath.uniquePaths(10,10));
    }

    /**
     * 机器人一共会走m+n-1步，且向下走n-1步，向右走m-1步，下右共用一步，所以挑出m+n-2中挑出n-1步即可
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if(m==1||n==1) return 1;
        int N=m+n-2;
        int M=m<n?m-1:n-1;
        //计算 C(N,M)
        //根据：C(N,M)=C(N,M-1)*M/(N-M+1);
        long ans=1;
        for(int i=1;i<=M;i++)
            ans=ans*(N-i+1)/i;
        return (int)ans;
    }

}

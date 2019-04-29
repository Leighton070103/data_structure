package problem.dynamicprograming;

/**
 * LeetCode 91 —— 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 */
public class NumDecoding {
    public static void main(String[] args){
        NumDecoding numDecoding = new NumDecoding();
        System.out.println(numDecoding.numDecodings("226"));

    }

    /**
     * 考虑极端情况： 1. 开头第一个字母为0； 2.包含连续两个0的数； 3.string length为0。
     * 采用深度遍历的办法。
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0' || s.contains("00")) return 0;
        if (s.length() == 1) return 1;
        int[] counts = new int[3];
        counts[0] = 1;
        counts[1] = 1;
        for (int i = 1; i<s.length(); i++){
            //针对从i-1位置跨向i位置。
            counts[2] = s.charAt(i) == '0' ? 0 : counts[1];
            //针对从i-2位置向i跨越
            if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) <= '6') counts[2] += counts[0];

            counts[0] = counts[1];
            counts[1] = counts[2];
        }
        return counts[2];
    }
}

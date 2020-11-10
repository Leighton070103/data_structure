package problem.sort;


import java.util.*;

/**
 * Leetcode 1451 重新排列句子中的单词
 * 「句子」是一个用空格分隔单词的字符串。给你一个满足下述格式的句子 text :
 * 句子的首字母大写
 * text 中的每个单词都用单个空格分隔。
 * 请你重新排列 text 中的单词，使所有单词按其长度的升序排列。
 * 如果两个单词的长度相同，则保留其在原句子中的相对顺序。
 * 请同样按上述格式返回新的句子
 */
public class ArrangeWords {
    public String arrangeWords(String text) {
        String[] strings = text.split(" ");
        if (strings.length == 1) return text;
        strings[0] = Character.toLowerCase( strings[0].charAt(0)) + strings[0].substring(1);
        Arrays.sort(strings, (o1, o2) -> {
            if (o1.length() < o2.length()) return -1;
            if (o1.length() > o2.length()) return 1;
            return 0;
        });

        String res = strings[0];
        res = Character.toUpperCase( res.charAt(0)) + res.substring(1);
        for (int i=1; i<strings.length; i++) res += " " + strings[i];
        return res;
    }

//    public String[] sort(String[] words){
//        return words;
//    }
//
//    public String[] merge(int i1, int i2, int j1, int j2, String[] words){
//        int p1 = i1;
//        int p2 = i2;
//        while (p1 <= i1 && p2<= i2){
//            if (compare(words[p1], words[p2]))
//        }
//    }
//
//    public void swap(String[] words, int a, int b){
//        String tmp = words[a];
//        words[a] = words[b];
//        words[b] = tmp;
//    }
//
//    public boolean compare(String s1, String s2){
//        return s1.length() <= s2.length();
//    }
}

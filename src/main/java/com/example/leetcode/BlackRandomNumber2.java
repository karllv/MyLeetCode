package com.example.leetcode;








import java.util.*;

/**
 * Created by karl on 2019/8/1.（240ms）
 */
public class BlackRandomNumber2 {
    /*  给定一个包含 [0，n ) 中独特的整数的黑名单 B，
    写一个函数从 [ 0，n ) 中返回一个不在 B 中的随机整数。*/
    Map<Integer, Integer> m;
    Random r;
    int wlen;

    private static Integer INTEGER_ONE = new Integer(1);

    public BlackRandomNumber2(int n, int[] b) {
        m = new HashMap<>();
        r = new Random();
        wlen = n - b.length;
        Set<Integer> w = new HashSet<>();
        for (int i = wlen; i < n; i++) w.add(i);
        for (int x : b) w.remove(x);
        Iterator<Integer> wi = w.iterator();
        for (int x : b)
            if (x < wlen)
                m.put(x, wi.next());


    }

    public int pick() {

        int k = r.nextInt(wlen);
        return m.getOrDefault(k, k);


    }




    public static void main(String[] args) {
        int N = 12;
        int[] blacklist = new int[]{2,4,5,6,9};
        int pick = new BlackRandomNumber2(N, blacklist).pick();
        System.out.println("pick:" + pick);
    }
}

package com.example.leetcode;








import java.util.*;

/**
 * Created by karl on 2019/8/1.
 */
public class BlackRandomNumber3 {
    /*  给定一个包含 [0，n ) 中独特的整数的黑名单 B，
    写一个函数从 [ 0，n ) 中返回一个不在 B 中的随机整数。*/
    Map<Integer, Integer> m;
    Random r;
    int[] b;
    int N;

    private static Integer INTEGER_ONE = new Integer(1);

    public BlackRandomNumber3(int n, int[] b) {
        m = new HashMap<>();
        r = new Random();
        N = n;
        this.b = b;
        if (n > 0) {
            if (null == b || 0 == b.length) {

            } else {
                Map removeMap = new HashMap<>();
                for (Integer x : b) {
                    removeMap.put(x, x);
                }
                int j = 0;
                for (Integer i = 0; i < n; i++) {
                    if (!removeMap.containsKey(i)) {
                        m.put(j, i);
                        j++;
                    }
                }
            }
        } else {
            m.put(0, null);
        }


    }

    public Integer pick() {
        if (N == 0) {
            return null;
        }

        if (null == b || 0 == b.length) {
            return r.nextInt(N);
        }
        int k = r.nextInt(m.size());
        return m.get(k);


    }




    public static void main(String[] args) {
        int N = 12;
        int[] blacklist = new int[]{1,3,6,9};
        Integer pick = new BlackRandomNumber3(N, blacklist).pick();
        System.out.println("pick:" + pick);
    }
}

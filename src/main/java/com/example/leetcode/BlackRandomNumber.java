package com.example.leetcode;








import java.util.*;

/**
 * Created by karl on 2019/8/1.
 */
public class BlackRandomNumber {
    /*  给定一个包含 [0，n ) 中独特的整数的黑名单 B，
    写一个函数从 [ 0，n ) 中返回一个不在 B 中的随机整数。*/
    private int N;
    private int[] blacklist;

    private static Integer INTEGER_ONE = new Integer(1);

    public BlackRandomNumber(int N, int[] blacklist) {
        this.N=N;
        this.blacklist=blacklist;
    }

    public int pick() {

        List<Integer> allList = new ArrayList<>();
        List<Integer> blackList = new ArrayList<>();
        for (int i = 0; i< N; i++) {
            allList.add(i);
        }
        for (int i = 0; i< blacklist.length; i++) {
            blackList.add(blacklist[i]);
        }

        allList = disjunction(allList, blackList);

        return allList.get(new Random().nextInt(allList.size()));


    }


    public static List disjunction(Collection a, Collection b) {
        ArrayList list = new ArrayList();
        Map mapa = getCardinalityMap(a);
        Map mapb = getCardinalityMap(b);
        Set elts = new HashSet(a);
        elts.addAll(b);
        Iterator it = elts.iterator();

        while(it.hasNext()) {
            Object obj = it.next();
            int i = 0;

            for(int m = Math.max(getFreq(obj, mapa), getFreq(obj, mapb)) - Math.min(getFreq(obj, mapa), getFreq(obj, mapb)); i < m; ++i) {
                list.add(obj);
            }
        }

        return list;
    }

    public static Map getCardinalityMap(Collection coll) {
        Map count = new HashMap();
        Iterator it = coll.iterator();

        while(it.hasNext()) {
            Object obj = it.next();
            Integer c = (Integer)count.get(obj);
            if(c == null) {
                count.put(obj, INTEGER_ONE);
            } else {
                count.put(obj, new Integer(c.intValue() + 1));
            }
        }

        return count;
    }

    private static final int getFreq(Object obj, Map freqMap) {
        Integer count = (Integer)freqMap.get(obj);
        return count != null?count.intValue():0;
    }

    public static void main(String[] args) {
        int N = 6;
        int[] blacklist = new int[]{1,2,3,4};
        int pick = new BlackRandomNumber(N, blacklist).pick();
        System.out.println("pick:" + pick);
    }
}

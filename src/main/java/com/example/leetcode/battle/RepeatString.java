// Copyright 2016-2101 Pica.
package com.example.leetcode.battle;

/**
 * @ClassName RepeatString
 * @Description 1044. 最长重复子串
 * @Author karl Kang
 * @Date 2019/8/1 10:23
 * @ModifyDate 2019/8/1 10:23
 * @Version 1.0
 */
public class RepeatString {
    /*给出一个字符串 S，考虑其所有重复子串（S 的连续子串，出现两次或多次，可能会有重叠）。

       返回任何具有最长可能长度的重复子串。（如果 S 不含重复子串，那么答案为 ""。）

    */

    public String longestDupSubstring(String S) {
        String[] split = S.split("");
        if (null != split) {
            for (int i = 0; i < split.length; i++) {

            }
        }
        return "";
    }

    public void isContain(String a, String b) {
        if (a.contains(b)) {
            return;
        }
    }

    static int indexOf(char[] source, int sourceOffset, int sourceCount,
                       char[] target, int targetOffset, int targetCount,
                       int fromIndex) {
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[] source = new char[] {'a','b','c','d','e'};
        char[] target = new char[] {'c','d'};
        RepeatString.indexOf(source, 0, source.length, target, 0, target.length, 0);

    }
}

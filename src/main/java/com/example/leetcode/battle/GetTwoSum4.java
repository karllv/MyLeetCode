// Copyright 2016-2101 Pica.
package com.example.leetcode.battle;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName getTwoSum
 * @Description 两数之和(1ms)
 * @Author karl Kang
 * @Date 2019/8/1 10:23
 * @ModifyDate 2019/8/1 10:23
 * @Version 1.0
 */
public class GetTwoSum4 {
    /*给定一个整数数组 nums 和一个目标值 target，
    请你在该数组中找出和为目标值的那 两个 整数，
    并返回他们的数组下标。*/

    public static int[] twoSum(int[] nums, int target) {
        int indexArrayMax = 2047;
        int[] indexArrays = new int[indexArrayMax + 1];
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            if (indexArrays[diff & indexArrayMax] != 0) {
                return new int[] { indexArrays[diff & indexArrayMax] - 1, i };
            }
            indexArrays[nums[i] & indexArrayMax] = i + 1;
        }
        throw new IllegalArgumentException("No two sum value");




    }



    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = GetTwoSum4.twoSum(nums, 9);
        System.out.printf("ints:" + JSON.toJSONString(ints));
    }
}

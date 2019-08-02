// Copyright 2016-2101 Pica.
package com.example.leetcode.battle;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName getTwoSum
 * @Description 两数之和(9ms)
 * @Author karl Kang
 * @Date 2019/8/1 10:23
 * @ModifyDate 2019/8/1 10:23
 * @Version 1.0
 */
public class GetTwoSum2 {
    /*给定一个整数数组 nums 和一个目标值 target，
    请你在该数组中找出和为目标值的那 两个 整数，
    并返回他们的数组下标。*/

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        if (null != nums && nums.length > 0) {
            for (int i=0; i< nums.length; i++) {
                if (map.containsKey(target-nums[i])) {
                    return new int[]{i, map.get(target-nums[i])};
                }
                map.put(nums[i], i);
            }
        }

        return null;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = GetTwoSum2.twoSum(nums, 9);
        System.out.printf("ints:" + JSON.toJSONString(ints));
    }
}

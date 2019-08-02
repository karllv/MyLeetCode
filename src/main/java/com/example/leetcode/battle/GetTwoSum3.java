// Copyright 2016-2101 Pica.
package com.example.leetcode.battle;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName getTwoSum
 * @Description 两数之和(8ms)
 * @Author karl Kang
 * @Date 2019/8/1 10:23
 * @ModifyDate 2019/8/1 10:23
 * @Version 1.0
 */
public class GetTwoSum3 {
    /*给定一个整数数组 nums 和一个目标值 target，
    请你在该数组中找出和为目标值的那 两个 整数，
    并返回他们的数组下标。*/

    public static int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        //遍历查找
        for(int i = 0; i < nums.length; i++){
            int a = nums[i];
            if(map.containsKey(target - a)){
                temp[0] = map.get(target - a);
                temp[1] = i;
                return temp;
            }else {//如果找不到则存进去
                map.put(nums[i], i);
            }
        }
        return null;


    }



    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = GetTwoSum3.twoSum(nums, 9);
        System.out.printf("ints:" + JSON.toJSONString(ints));
    }
}

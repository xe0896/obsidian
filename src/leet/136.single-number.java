
import java.util.ArrayList;
import java.util.HashSet;

/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        /*
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
        */

        /*
        List<Integer> set = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                set.remove(Integer.valueOf(nums[i]));
            } else {
                set.add(nums[i]);
            }
        }
        return set.get(0);
        */

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return set.iterator().next();


    }
}
// @lc code=endI


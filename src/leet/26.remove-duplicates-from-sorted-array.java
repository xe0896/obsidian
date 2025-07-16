/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start

class Solution {
    /*
    public int removeDuplicates(int[] nums) {
        int k = 1;
        for(int i = 1; i < nums.length; i++) {
            if(duplicatesIterator(nums, k, nums[i])) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public boolean duplicatesIterator(int[] nums, int k, int value) {
        for(int i = 0; i < k; i++) {
            if (nums[i] == value) {
                return false;
            }
        }
        return true;
    }
    */
    public int removeDuplicates(int[] nums) {
        int k = 1;

        for(int i = 1; i < nums.length; i++) {
            
            if (nums[i] != nums[i-1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

}
// @lc code=end


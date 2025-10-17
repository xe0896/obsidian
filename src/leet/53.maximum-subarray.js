/*
 * @lc app=leetcode id=53 lang=javascript
 *
 * [53] Maximum Subarray
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function (nums) {
  let max = nums[0];
  let current = nums[0];
  for (let i = 1; i < nums.length; i++) {
    if (current > 0) {
      current += nums[i];
    } else {
      current = nums[i];
    }
    max = Math.max(max, current);
  }

  return max;
};
// @lc code=end

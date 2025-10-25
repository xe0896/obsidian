/*
 * @lc app=leetcode id=213 lang=javascript
 *
 * [213] House Robber II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
  if (nums.length == 1) {
    return nums[0];
  }
  return Math.max(
    helper(nums, Array(nums.length).fill(undefined), 1, nums.length),
    helper(nums, Array(nums.length).fill(undefined), 0, nums.length - 1)
  );
};

var helper = function (nums, dp, index, bound) {
  if (index >= bound) {
    return 0;
  }

  if (dp[index] != undefined) {
    return dp[index];
  }

  dp[index] = Math.max(
    nums[index] + helper(nums, dp, index + 2, bound),
    helper(nums, dp, index + 1, bound)
  );

  return dp[index];
};
// @lc code=end

/*
 * @lc app=leetcode id=198 lang=javascript
 *
 * [198] House Robber
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
  const dp = Array(nums.length).fill(undefined);
  return helper(nums, dp, 0);
};

var helper = function (nums, dp, index) {
  if (index >= nums.length) {
    return 0;
  }

  if (dp[index] != undefined) {
    return dp[index];
  }

  dp[index] = Math.max(
    nums[index] + helper(nums, dp, index + 2),
    helper(nums, dp, index + 1)
  );

  return dp[index];
};

// @lc code=end

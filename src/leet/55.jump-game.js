/*
 * @lc app=leetcode id=55 lang=javascript
 *
 * [55] Jump Game
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function (nums) {
  const dp = Array(nums.length).fill(undefined);
  return helper(0, dp, nums);
};

var helper = function (index, dp, nums) {
  if (index >= nums.length - 1) {
    return true;
  }

  if (dp[index] !== undefined) {
    return dp[index];
  }

  for (let i = index; i < index + nums[index]; i++) {
    if (helper(i + 1, dp, nums)) {
      dp[index] = true;
      return true;
    }
  }

  dp[index] = false;
  return false;
};
// @lc code=end

/*
 * @lc app=leetcode id=42 lang=javascript
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function (height) {
  let R = height.length - 1;
  let L = 0;

  const maxLeft = Array.from({ length: R + 1 });
  const maxRight = Array.from({ length: R + 1 });

  maxLeft[L] = height[L];
  maxRight[R] = height[R];

  for (let i = 1; i < height.length; i++) {
    maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
  }

  for (let i = R - 1; i >= 0; i--) {
    maxRight[i] = Math.max(maxRight[i + 1], height[i]);
  }

  let sum = 0;
  for (let i = 0; i < R + 1; i++) {
    sum += Math.min(maxLeft[i], maxRight[i]) - height[i];
  }

  return sum;
};
// @lc code=end

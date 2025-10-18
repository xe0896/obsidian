/*
 * @lc app=leetcode id=11 lang=javascript
 *
 * [11] Container With Most Water
 */

// @lc code=start
/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function (height) {
  // Two pointers L, R area: Math.min(L,R) * (R - L)
  let R = height.length - 1;
  let L = 0;

  let max = 0;

  while (L <= R) {
    const area = Math.min(height[L], height[R]) * (R - L);
    max = Math.max(area, max);
    if (height[L] < height[R]) {
      L++;
    } else {
      R--;
    }
  }

  return max;
};

// @lc code=end

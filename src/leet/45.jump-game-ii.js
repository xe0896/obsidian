/*
 * @lc app=leetcode id=45 lang=javascript
 *
 * [45] Jump Game II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function (nums) {
	let jump = 0;
	let maxReach = 0;
	let end = 0;

	for (let i = 0; i < nums.length - 1; i++) {
		maxReach = Math.max(maxReach, i + nums[i]); // Index

		if (i == end) {
			jump++;
			end = maxReach;
		}
	}

	return jump;
};
// @lc code=end

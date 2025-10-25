/*
 * @lc app=leetcode id=3550 lang=javascript
 *
 * [3550] Smallest Index With Digit Sum Equal to Index
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var smallestIndex = function (nums) {
	for (let i = 0; i < nums.length; i++) {
		let str = String(nums[i]);
		let acc = 0;
		for (let j = 0; j < str.length; j++) {
			let int = Number(str[j]);
			acc += int;
		}
		if (acc === i) {
			return i;
		}
	}
	return -1;
};
// @lc code=end

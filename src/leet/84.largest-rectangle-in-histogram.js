/*
 * @lc app=leetcode id=84 lang=javascript
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function (heights) {
	let maxArea = 0;
	const stack = [];

	for (let i = 0; i < heights.length; i++) {
		let current = heights[i];
		while (stack.length && current < heights[stack[stack.length - 1]]) {
			let popped = stack.pop();
			let height = heights[popped];
			let left;
			if (stack.length) {
				left = stack[stack.length - 1];
			} else {
				left = -1;
			}

			maxArea = Math.max(maxArea, height * (i - left - 1));
		}
		stack.push(i);
	}
	while (stack.length) {
		let popped = stack.pop();
		let height = heights[popped];
		let left;
		if (stack.length) {
			left = stack[stack.length - 1];
		} else {
			left = -1;
		}

		maxArea = Math.max(maxArea, height * (heights.length - left - 1));
	}

	return maxArea;
};
// @lc code=end

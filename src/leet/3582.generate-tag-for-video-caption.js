/*
 * @lc app=leetcode id=3582 lang=javascript
 *
 * [3582] Generate Tag for Video Caption
 */

// @lc code=start
/**
 * @param {string} caption
 * @return {string}
 */
var generateTag = function (caption) {
	const arr = caption.split(" ");
	for (let i = 0; i < arr.length; i++) {
		const change = String(arr[i][0]);
		if (i == 0) {
			arr[i] = change.toLowerCase() + arr[i].slice(1);
		} else {
			arr[i] = change.toUpperCase() + arr[i].slice(1);
		}
	}
	let str = "#" + arr.join("");
	return str.slice(0, 99);
};
// @lc code=end

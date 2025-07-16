/*
 * @lc app=leetcode id=171 lang=javascript
 *
 * [171] Excel Sheet Column Number
 */

// @lc code=start
/**
 * @param {string} columnTitle
 * @return {number}
 */
var titleToNumber = function(columnTitle) {
    let result = 0;
    for(let i = 0; i < columnTitle.length; i++) {
        let a = columnTitle.charAt(i);
        value = a.charCodeAt(0) - 'A'.charCodeAt(0) + 1;
        result = result * 26 + value;
    }
    return result;
};
// @lc code=end


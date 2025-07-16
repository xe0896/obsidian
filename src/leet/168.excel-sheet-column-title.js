/*
 * @lc app=leetcode id=168 lang=javascript
 *
 * [168] Excel Sheet Column Title
 */

// @lc code=start
/**
 * @param {number} columnNumber
 * @return {string}
 */
var convertToTitle = function(columnNumber) {
    let result = 0;
    for(let i = 0; i < columnNumber.length; i++) {
        a = columnNumber.charAt(i);
        value = a - 'A' + 1;
        result = result * 26 + value;
    }
    return 
};
// @lc code=end


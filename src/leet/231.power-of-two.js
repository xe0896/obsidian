/*
 * @lc app=leetcode id=231 lang=javascript
 *
 * [231] Power of Two
 */

// @lc code=start
/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    /*
    if(n == 0) { return false }
    while(n != 1) {
        if(Number.isInteger(n)) {
            console.log(n);
            n = n / 2;
        } else {
            return false;
        }
    }
    return true;
    */

    if(n == 0) {
        return false;
    }
   
    return (n & (n - 1)) == 0;
};
// @lc code=end


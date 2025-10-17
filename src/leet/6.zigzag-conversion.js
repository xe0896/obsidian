/*
 * @lc app=leetcode id=6 lang=javascript
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function (s, numRows) {
  if (numRows === 1) {
    return s;
  }
  const rows = new Array(numRows).fill("");
  let down = false;
  let current = 0;

  for (let i = 0; i < s.length; i++) {
    rows[current] += s[i];
    if (current == 0 || current == numRows - 1) {
      down = !down;
    }
    if (down) {
      current++;
    } else {
      current--;
    }
  }
  let ans = "";
  for (const row of rows) {
    ans += row;
  }

  return ans;
};
// @lc code=end

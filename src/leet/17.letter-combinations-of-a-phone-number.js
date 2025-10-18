/*
 * @lc app=leetcode id=17 lang=javascript
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function (digits) {
  const lookup = {
    2: "abc",
    3: "def",
    4: "ghi",
    5: "jkl",
    6: "mno",
    7: "pqrs",
    8: "tuv",
    9: "wxyz",
  };

  const iter = digits.toString();
  let arr = [""];

  // 23: "abc" x "def" = {ad, ae, af, bd, be, bf, cd, ce, cf}
  // 234: "abc" x "def" x "ghi" = {adg, }

  for (let c = 0; c < iter.length; c++) {
    const letters = lookup[Number(iter[c])];
    const temp = [];

    for (let i = 0; i < arr.length; i++) {
      for (let j = 0; j < letters.length; j++) {
        temp.push(arr[i] + letters[j]);
      }
    }
    arr = temp;
  }

  console.log(arr);
  return arr;
};

// @lc code=end

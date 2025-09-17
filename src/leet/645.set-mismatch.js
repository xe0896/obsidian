/*
 * @lc app=leetcode id=645 lang=javascript
 *
 * [645] Set Mismatch
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findErrorNums = function(nums) {
    let newArr = [];
    let sum = (nums.length * (nums.length + 1))/2
    let mySet = new Set();
    let actualSum = 0;

    for(let i = 0; i < nums.length; i++) {
        actualSum += nums[i];
        if(mySet.has(nums[i])) {
            newArr.push(nums[i]);
        } else {
            mySet.add(nums[i])
        }
    }    

    newArr.push(newArr[0] - (actualSum - sum));
    return newArr;
};
// @lc code=end


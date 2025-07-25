

/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 *
 * https://leetcode.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (47.56%)
 * Likes:    10437
 * Dislikes: 5503
 * Total Accepted:    3M
 * Total Submissions: 6.3M
 * Testcase Example:  '[1,2,3]'
 *
 * You are given a large integer represented as an integer array digits, where
 * each digits[i] is the i^th digit of the integer. The digits are ordered from
 * most significant to least significant in left-to-right order. The large
 * integer does not contain any leading 0's.
 * 
 * Increment the large integer by one and return the resulting array of
 * digits.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int count = 0;
        if(digits[digits.length-1] == 9) {
            while(digits.length-count > 0 && digits[digits.length-1-count] == 9) {
                if(digits[digits.length-1-count] != 9) {
                    break;
                } else {
                    count++;
                }
            }
            if(count == digits.length) {
                int[] di = new int[count+1];
                for(int i = 1; i < di.length; i++) {
                    di[i] = 0;
                }
                di[0] = 1;
                return di;
            }
            digits[digits.length-1-count] = digits[digits.length-1-count] + 1;
            for(int i = digits.length-count; i < digits.length; i++) {
                digits[i] = 0;
            }
            return digits;
        } else {
            digits[digits.length-1] = digits[digits.length-1]+1;
            return digits;
        }
    }
}
// @lc code=end


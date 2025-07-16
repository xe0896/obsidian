/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (50.97%)
 * Likes:    10516
 * Dislikes: 8560
 * Total Accepted:    4.4M
 * Total Submissions: 8.6M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers.
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric
 * characters.
 * Since an empty string reads the same forward and backward, it is a
 * palindrome.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 2 * 10^5
 * s consists only of printable ASCII characters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        int L = 0;
        int R = s.length() - 1;
        while(L <= R) {    
            while (L <= R && !Character.isLetterOrDigit(s.charAt(L))) {
                L++;
            }
            while (L <= R && !Character.isLetterOrDigit(s.charAt(R))) {
                R--;
            }

            if(L > R) {
                break;
            }

            if(Character.toLowerCase(s.charAt(L)) != Character.toLowerCase(s.charAt(R))) {
                return false;
            }
            R--;
            L++;
        }
        return true;
    }
}
// @lc code=end

    
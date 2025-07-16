

/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 *
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (56.33%)
 * Likes:    5809
 * Dislikes: 329
 * Total Accepted:    2.8M
 * Total Submissions: 5M
 * Testcase Example:  '"Hello World"'
 *
 * Given a string s consisting of words and spaces, return the length of the
 * last word in the string.
 * 
 * A word is a maximal substring consisting of non-space characters only.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int k = 0;
        boolean enter = false;
        if(s.length() == 1 && !Character.isWhitespace(s.charAt(0))) {return 1;}
        for(int i = s.length()-1; i >= 0; i--) {
            boolean c = Character.isWhitespace(s.charAt(i));
            if(enter) {
                if(c) {
                    return k;
                } else {
                    k++;
                }
            } else if(!c) {
                enter = true;
                k++;
            }
        }

        return k;
    }
}
// @lc code=end


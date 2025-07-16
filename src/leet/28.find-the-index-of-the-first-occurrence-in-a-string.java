

/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Find the Index of the First Occurrence in a String
 *
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 *
 * algorithms
 * Easy (44.98%)
 * Likes:    6790
 * Dislikes: 508
 * Total Accepted:    3.4M
 * Total Submissions: 7.5M
 * Testcase Example:  '"sadbutsad"\n"sad"'
 *
 * Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack, or -1 if needle is not part of
 * haystack.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= haystack.length, needle.length <= 10^4
 * haystack and needle consist of only lowercase English characters.
 * 
 * 
 */

// @lc code=start
class Solution {

    /*
    public int strStr(String haystack, String needle) {
        boolean flag = false;
        int start = -1;
        int j = 0;
        if(haystack.length() < needle.length()) {return -1;}
        for(int i = 0; i < haystack.length(); i++) {
            System.out.println(start);
            if(j == needle.length()) {
                return start;
            } else if (flag) {
                if(haystack.charAt(i) == needle.charAt(j)) {
                    j++;
                } else {
                    j = 0;
                    flag = false;
                    start = -1;
                }
            } else {
                if(haystack.charAt(i) == needle.charAt(0)) {
                    j++;
                    flag = true;
                    start = i;
                }
            }
        }

        return start;
    }
    */

    /*
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    */

    /*
    public int strStr(String haystack, String needle) {
        int left = 0;
        char start = needle.charAt(0);

        for(int right = 0; right < haystack.length(); right++) {
            if(haystack.substring(left, right + 1).equals(needle)) {
                return left;
            } else if (needle.length() < right - left + 2) {
                left++;
            } else if (haystack.charAt(left) != start) {
                left++;
            }
        }
        return -1;
    }
    */

    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for(int i = 0; i <= n - m; i++) {
            if(haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end





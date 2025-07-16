/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start


class Solution {
    public String longestCommonPrefix(String[] strs) {
        String sub = "";
        int minLength = 200;
        for(int i = 0; i < strs.length; i++) {
            minLength = Math.min(strs[i].length(), minLength);
        }
        outer:
        for (int j = 0; j < minLength; j++) {
            String a = String.valueOf(strs[0].charAt(j));
            sub = sub + a;
            for(int i = 0; i < strs.length; i++) {
                if (strs[i].charAt(j) != sub.charAt(j)) {
                    sub = sub.substring(0, sub.length() - 1);
                    break outer;
                    
                }
            }   
        }

        return sub;
    }
}
// @lc code=end


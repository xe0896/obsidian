/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean flag = i+1 < s.length();

            if (s.charAt(i) == 'I') {
                if (flag) {
                    if (s.charAt(i+1) == 'V') {
                        ans = ans + 4;
                        i++;
                        continue;
                    } else if (s.charAt(i+1) == 'X') {
                        ans = ans + 9;
                        i++;
                        continue;
                    }
                }
                ans = ans + 1;
            }

            if (s.charAt(i) == 'X') {
                if (flag) {
                    if (s.charAt(i+1) == 'L') {
                        ans = ans + 40;
                        i++;
                        continue;
                    } else if (s.charAt(i+1) == 'C') {
                        ans = ans + 90;
                        i++;
                        continue;
                    }
                }

                ans = ans + 10;
            }
            if (s.charAt(i) == 'C') {
                if (flag) {
                    if (s.charAt(i+1) == 'D') {
                        ans = ans + 400;
                        i++;
                        continue;
                    } else if (s.charAt(i+1) == 'M') {
                        ans = ans + 900;
                        i++;
                        continue;
                    }
                }
                
                ans = ans + 100;
            }

            char letter = s.charAt(i);
            switch(letter) {
                case 'V':
                    ans = ans + 5;
                    break;
                case 'L':
                    ans = ans + 50;
                    break;
                case 'D': 
                    ans = ans + 500;
                    break;
                case 'M': 
                    ans = ans + 1000;
                    break;
            }
        }
        return ans;
    }
}
// @lc code=end


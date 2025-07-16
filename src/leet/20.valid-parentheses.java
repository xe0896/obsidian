
import java.util.ArrayList;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start

// Stack implementation
class Solution {
    
    public boolean isValid(String s) {
        ArrayList<String> stack = new ArrayList<>();
        int head = 0;

        for(int i = 0; i < s.length(); i++) {
            String current = "" + s.charAt(i);
            
            if (current.equals("(") || current.equals("[") || current.equals("{")) {
                
                stack.add(current);
                head++;
                
            } else if (current.equals(")")) {
                    head--;
                    if (head < 0 || !stack.get(head).equals("(")) {
                        return false;
                    }
                    stack.remove(head);
                    
                
            } else if (current.equals("]")) {
                    head--;
                    if (head < 0 || !stack.get(head).equals("[")) {
                        return false;
                    }
                    stack.remove(head);
                    
                
            } else if (current.equals("}")) {
                    head--;
                    if (head < 0 || !stack.get(head).equals("{")) {
                        return false;
                    }
                    stack.remove(head);
                    
                
            }
        }

        return stack.isEmpty();
    }

}

/*
No stack attempt
class Solution {
    public boolean isValid(String s) {
        int brac = 0;
        int curl = 0;
        int squi = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Math.min(Math.min(brac,curl), squi) < 0) {
                return false;
            }
            
            switch(s.charAt(i)) {
                case '(':
                    brac++;
                    break;
                case '[':
                    curl++;
                    break;
                case '{':
                    squi++;
                    break;
                case ')':
                    if (!check(')', s, i)) {
                        return false;
                    }
                    brac--;
                    break;
                case ']':
                    if (!check(']', s, i)) {
                        return false;
                    }
                    curl--;
                    break;
                case '}':
                    if (!check('}', s, i)) {
                        return false;
                    }
                    squi--;
                    break;
            }
        }
        return (brac == 0 && curl == 0 && squi == 0);
    }
    public boolean check(char a, String s, int i) {
        char x,y,z,k,b;
        int check = 0;
        if (a == ')') {
            x = ']';
            y = '}';
            z = '[';
            k = '{';
            b = '(';
        } else if (a == ']') {
            x = ')';
            y = '}';
            z = '(';
            k = '{';
            b = '[';
        } else {
            x = ')';
            y = ']';
            z = '(';
            k = '[';
            b = '{';
        }
        for (int j = i; j >= 0; j--) {
            if (s.charAt(j) == x || s.charAt(j) == y) {
                check--;
            } else if (s.charAt(j) == z || s.charAt(j) == k) {
                check++;
            } 
            
        }
        System.out.println(check);
        System.out.println(a);
        return check == 0;
    }
    
}
*/


// @lc code=end


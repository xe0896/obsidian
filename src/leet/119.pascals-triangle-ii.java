
import java.util.ArrayList;

/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 *
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (65.95%)
 * Likes:    5078
 * Dislikes: 360
 * Total Accepted:    1.1M
 * Total Submissions: 1.6M
 * Testcase Example:  '3'
 *
 * Given an integer rowIndex, return the rowIndex^th (0-indexed) row of the
 * Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 * 
 * 
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 * Input: rowIndex = 1
 * Output: [1,1]
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= rowIndex <= 33
 * 
 * 
 * 
 * Follow up: Could you optimize your algorithm to use only O(rowIndex) extra
 * space?
 * 
 */

// @lc code=start
class Solution {
    /*
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        long numerator = factorial(rowIndex);
        for(int i = 0; i <= rowIndex; i++) {
            long denominator = factorial(i)*factorial(rowIndex-i);
            list.add((int) (numerator / denominator));
        }
        return list;
    }
    */

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        long value = 1;
        list.add(1);

        for(int i = 1; i <= rowIndex; i++) {
            value = value*(rowIndex-i+1)/i;
            list.add((int) value);
        }
        return list;
    }

    /*
    public int factorial(int n) {
        if(n == 1) {
            return 1;
        }
        return factorial(n-1) * n;
    }
    public long factorial(int n) {
        long result = 1;
        for(int i = 2; i <= n; i++) {
            result*=i;
        }
        return result;
    }
    */
    

}
// @lc code=end



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 *
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (77.03%)
 * Likes:    13907
 * Dislikes: 518
 * Total Accepted:    2.2M
 * Total Submissions: 2.8M
 * Testcase Example:  '5'
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 * 
 * 
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= numRows <= 30
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>(List.of(1));
        ans.add(firstRow);

        if(numRows == 1) {
            return ans;
        }
        List<Integer> secondRow = new ArrayList<>(List.of(1,1));

        ans.add(secondRow);
        
        for(int i = 2; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(Collections.nCopies(i + 1, 0));
            list.set(0, 1); 
            list.set(i, 1);

            for(int j = 1; j < i; j++) {
                List<Integer> prev = ans.get(i-1);
                list.set(j, prev.get(j-1) + prev.get(j));
            }
            ans.add(list);
        }
        return ans;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 *
 * https://leetcode.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (59.29%)
 * Likes:    16196
 * Dislikes: 420
 * Total Accepted:    2.5M
 * Total Submissions: 4.2M
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * Given the root of a binary tree, check whether it is a mirror of itself
 * (i.e., symmetric around its center).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * Follow up: Could you solve it both recursively and iteratively?
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;https://assets.leetcode.com/uploads/2021/02/19/symtree1.jpg
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        if(!check(p.left, q.right)) {
            return false;
        }
        return check(p.right, q.left);
    }
}
// @lc code=end


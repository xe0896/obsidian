/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (77.14%)
 * Likes:    13638
 * Dislikes: 269
 * Total Accepted:    4.1M
 * Total Submissions: 5.3M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given the root of a binary tree, return its maximum depth.
 * 
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,null,2]
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 10^4].
 * -100 <= Node.val <= 100
 * 
 * 
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
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    /*
    private int h;
    public int maxDepth(TreeNode root) {
        int depth = 1;

        inOrder(root, depth);
        return h;
    }

    public void inOrder(TreeNode root, int depth) {
        if(root != null) {
            h = Math.max(h, depth);
            inOrder(root.left, depth + 1);
            inOrder(root.right, depth + 1);

        }
    }
    */
    public int maxDepth(TreeNode root) {
        return height(root, 0);
    }

    public int height(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
	    return Math.max(height(root.left, depth + 1), height(root.right, depth + 1)); 
    }
}
// @lc code=end


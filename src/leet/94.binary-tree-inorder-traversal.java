
import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Easy (78.59%)
 * Likes:    14225
 * Dislikes: 847
 * Total Accepted:    3.2M
 * Total Submissions: 4M
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes'
 * values.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,3]
 * 
 * Output: [1,3,2]
 * 
 * Explanation:
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
 * 
 * Output: [4,2,6,5,7,1,3,9,8]
 * 
 * Explanation:
 * 
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = []
 * 
 * Output: []
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: root = [1]
 * 
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(list, root);
        return list;
        
    }

    public void inOrder(List<Integer> list, TreeNode root) {
        if(root != null) {
            inOrder(list, root.left);
            list.add(root.val);
            inOrder(list, root.right);
        }
    }
    */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
    }

}
// @lc code=end


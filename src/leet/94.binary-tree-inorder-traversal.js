/*
 * @lc app=leetcode id=94 lang=javascript
 *
 * [94] Binary Tree Inorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function (root) {
  const list = [];
  inOrder(root, list);
  return list;
};

var inOrder = function (root, list) {
  if (root == null) {
    return;
  }
  inOrder(root.left, list);
  list.push(root.val);
  inOrder(root.right, list);
};
// @lc code=end

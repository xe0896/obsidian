/*
 * @lc app=leetcode id=19 lang=javascript
 *
 * [19] Remove Nth Node From End of List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function (head, n) {
  if (n == 1) {
    return head.next;
  }
  let current = head;
  for (let i = 0; i < n; i++) {
    current = current.next;
  }
  if (current && current.next) {
    current.next = current.next.next;
  }

  return head;
};
// @lc code=end

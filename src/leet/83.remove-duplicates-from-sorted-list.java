/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (54.88%)
 * Likes:    9306
 * Dislikes: 342
 * Total Accepted:    2M
 * Total Submissions: 3.6M
 * Testcase Example:  '[1,1,2]'
 *
 * Given the head of a sorted linked list, delete all duplicates such that each
 * element appears only once. Return the linked list sorted as well.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,1,2]
 * Output: [1,2]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pointer = head;

        while(pointer != null && pointer.next != null) {
            ListNode neighbour = pointer.next;
            if(pointer.val == neighbour.val) {
                pointer.next = neighbour.next;
            } else {
                pointer = pointer.next;
            }
        }
        return head;
    }
}
// @lc code=end


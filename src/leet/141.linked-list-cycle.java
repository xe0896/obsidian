/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode tort = head;
        ListNode hare = head;
        while(hare != null && hare.next != null)  {
            
            hare = hare.next.next;
            tort = tort.next;
            if(hare == tort) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end


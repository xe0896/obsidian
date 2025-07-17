Given `head`, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to. **Note that `pos` is not passed as a parameter**.

Return `true` _if there is a cycle in the linked list_. Otherwise, return `false`.
***
### Follow up question
Our implementation above has a time complexity of `O(n)` and space complexity of `O(n)`, we can't do much about the time complexity as we must traverse the list regardless, we can reduce the space complexity if we do a simple way of thinking.

We will have two pointers `tort` and `hare`, where `tort` will traverse the list by `1` and `hare` will traverse the list by `2`. These two pointers will traverse the list based on these conditions and we can detect a cycle if they ever become equal, this is because if there was a cycle then `hare` would backtrack and eventually meet `tort` and they would never meet if there wasn't a cycle since `hare` is to fast. 

If there was no cycle then `hare` or `hare.next` would become `null` and there is no cycle if any nodes `.next` is `null`, this is a suitable condition for our while loop.

We should also make our pointers move before checking if they are equal since at the start `tort == hare` since they haven't moved at all yet:
```java
public boolean hasCycle(ListNode head) {
	ListNode tort = head;
	ListNode hare = head;
	while(hare != null && hare.next != null) {
		hare = hare.next.next;
		tort = tort.next;
		if(hare == tort) {
			return true;
		}
	}
	return false;
}
```

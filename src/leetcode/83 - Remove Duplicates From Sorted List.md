Given the `head` of a sorted linked list, _delete all duplicates such that each element appears only once_. Return _the linked list **sorted** as well_.
***
This problem has a straight-forward solution but is a bit different which will be mentioned soon. Since the list is ordered we know that a node holding `val=x` will only have this `val` nearby so we can assign a node `neighbour` storing our `pointer` next value using `neighbour=pointer.next` and compare this with `pointer.val` and if this is true we skip our `neighbour` by doing `pointer.next = neighbour.next` and repeat this process using the **same** `pointer` and don't move our pointer only when the condition earlier is `false`.

The difference mentioned earlier is that we do not always have to move our pointer, only when we have two distinct values next to each other since that is solving the problem essentially:
```java
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
```

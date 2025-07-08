You are given the heads of two sorted linked lists `list1` and `list2`.

Merge the two lists into one **sorted** list. The list should be made by splicing together the nodes of the first two lists.

Return _the head of the merged linked list_.
***
This problem heavily relies on the understanding of linked lists, if you can understand that then its a straightforward problem. We will be constructing our own linked list from scratch given our two lists so we must first understand how to add elements to a linked list, for this we use a temporary pointer `current` which will help us add elements by pointing at the **tail** and being used as a reference point for adding elements:
```java
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	ListNode ans = new ListNode(0);
	ListNode current = ans;
```
The two lists given are in order, this helps us as we do not need to consider every single node in both the lists since when one is exhausted and fully iterated over, then we can just append the node of the non-exhausted list as it already has the other nodes linked and it would finish the job.

This means that we have reduced the problem to just iterating over both lists and only accepting the smallest numbers considering both lists until one is exhausted and then we can append the rest
We can check if a list has been exhausted if it is `null` and it is important to note that we will always have only one list exhausted, hence if one list is exhausted then the other one isn't.

Our while loop will be `while(list1 != null && list2 != null)` which will allow us to only iterate one list hasn't been exhausted yet, if it is then it will terminate and append the other list:
```java
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	ListNode ans = new ListNode(0);
	ListNode current = ans;
	while(list1 != null && list2 != null) {
		if(list1.val <= list2.val) {
			current.next = list1;
			list1 = list1.next;
		} else {
			current.next = list2;
			list2 = list2.next;
		}
		current = current.next;
	}
	if (list1 != null) {
		current.next = list1;
	} else {
		current.next = list2;
	}
	return ans.next;
}
```
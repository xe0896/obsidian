You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order**, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
***
For this problem I got a big hint already from looking at the discussions from earlier on and it was on about why the digits being in reverse order was helpful so we can perform column addition.

The first problem I faced with this is that given that we had to consider the column addition of these two linked lists, how would we reach the end by not just pointing to the next `ListNode` until it was null since that seemed to expensive to do since column addition starts at the end.

Before I considered this problem, I think it was worthwhile to look at the object `ListNode` and the methods was given:

```java
public class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	
	ListNode(int val) {
		this.val = val;
	}
	
	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
```

The first constructor I assume was to make a `ListNode` with no pointers yet and the other one was for when we want to assign a pointer straight away, these didn't seemed useful on actually solving the problem.

After some thinking the problem was easier then I thought, there was no need to go to the end like a normal column addition, we can just start at index `0` and perform column addition from there as the linked list variant is reversed so it acts as starting from the end anyways (which could be seen as very obvious but it wasn't intuitive to me for some reason).

Initially a for-loop was being made to iterate over the linked lists but since its a conditioned controlled loop on whether or not the linked list next value is null or not, a while loop seemed to fit and also we wasn't going to be using the iterator anyways ($i$).

When examining my solution (may or not have been done after the stuff below), I was making a `ListNode` referencing `ans` and I was returning that as my answer, but this will always point to the tail but we want to return the head so the solution checker can do `.next` over and over to get the answers, this means we needed an extra pointer `current` that points to the `ListNode's` that we want and will be at the tail in the end and allow `ans` to remain at on the head:

```java
ListNode ans = new ListNode();
ListNode current = ans;
```

I encountered some `NullPointerException` errors since the two `ListNode's` could be null and if one of them was and the other one wasn't, we had to do extra checks on which one is `null` so we can assign them to `0`:
```java
while (l1 != null || l2 != null || add1) { // add1 added here to handle the case of a new digit from the summuation
	int val1;
	int val2;
	if (l1 != null) { // this could of looked nicer via multiplexers
		val1 = l1.val;
	} else {
		val1 = 0;
	}
	if (l2 != null) {
		val2 = l2.val;
	} else {
		val2 = 0;
	}
}
```

A boolean `add1` was made to see if we had to add `1` on the next column and this was added onto any val, so I chose `val1`
```java
if (add1) { // before the add1 stuff to handle the first case where add1 may be true and adds 1 to val1 (i.e: itself)
	val++;
}
if (val1 + val2 > 9) {
	add1 = true;
	current.val = val1 + val2 - 10;
} else {
	add1 = false;
	current.val = val1 + val2;
}
```

Now that we handled the summation, we now had to handle the part where we want to point to the next `ListNode` and decide whether creating a new node is necessary.

```java
if (l1 != null) {
	l1 = l1.next;
}
if (l2 != null) {
	l2 = l2.next;
}
```

This was done since `l1` or `l2` may be null as the `ListNode` that they are pointing to might be `null` (makes more sense later on).

Initially the following was done without any `null` checks to create a new `ListNode`:

```java
	current.next = new ListNode();
	current = current.next;
```

This wasn't correct as it would create a new node without the check of the next node existing or not meaning an extra node at the end was being created regardless of it being needed or not, this led to us making some `null` checks:

```java
if (l1 != null || l2 != null || add1) {
	current.next = new ListNode();
	current = current.next;
}
```
After all this, the following solution passed the `1569/1569` tests:
```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	ListNode ans = new ListNode();
	ListNode current = ans;
	boolean add1 = false;
	while (l1 != null || l2 != null || add1) {
		int val1;
		int val2;

		// Default value is 0 if there is no value
		if (l1 != null) {
			val1 = l1.val;
		} else {
			val1 = 0;
		}
		if (l2 != null) {
			val2 = l2.val;
		} else {
			val2 = 0;
		}

		// val1++ is add1, could of been val2++
		if (add1) {
			val1++;
		}

		// Assigning current.val based on val1 and val2, add1 checks
		if (val1 + val2 > 9) {
			add1 = true;
			current.val = val1 + val2 - 10;
		} else {
			add1 = false;
			current.val = val1 + val2;
		}

		// Moves to next node if it exists, atleast one will exist due to loop
		if (l1 != null) {
			l1 = l1.next;
		}
		if (l2 != null) {
			l2 = l2.next;
		}

		// Creating new node and hopping to it as it will get a new value next iter
		if (l1 != null || l2 != null || add1) {
			current.next = new ListNode();
			current = current.next;
		}
	}

	return ans;
}
```

## Lessons learned

- The pointer `current` being used rather then `ans`, characteristics of the linked list
- More `null` checks, think of every possibility, links to the use of `val1` and `val2`
- Creating new objects when required
- While loops could be better then for loops
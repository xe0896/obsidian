Given the heads of two singly linked-lists `headA` and `headB`, return _the node at which the two lists intersect_. If the two linked lists have no intersection at all, return `null`.

For example, the following two linked lists begin to intersect at node `c1`:

![](https://assets.leetcode.com/uploads/2021/03/05/160_statement.png)

The test cases are generated such that there are no cycles anywhere in the entire linked structure.
***
There are two ways to think about this question, one is the naïve way and to maintain a list of both traversals and the moment when nodes start to connect we return that node, but the other much more thought-out way would be to traverse the given heads at the same time and once we encounter `null` we redirect to the head of the other given head, we do this for both heads.

This logic can be seen if we say that `a` is the length of the list of the first head and `b` is the length of the list of the second head and both lengths do not consider there connection part, we can also assign `c` to be the connection part which both full lists would contain.

We can then align the traversal by seeing that `a + c + b = b + c + a`, in the LHS we see that we start at `a` then go through the connection `b` then redirect to the other list `a`, if we do this for the other list to then we would align our traversals and terminate when our pointers are equal. 

This logic is basically just finding out which list is the shortest list and when we start at the other lists head we essentially remove the difference that this shortest list had against the longer list and if we apply this to the other head then we will be fully aligned which is what makes this problem, a problem.
```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA
        ListNode B = headB;
        while(A != B) {
            if(A == null) {
                A = headB;
            } else {
                A = A.next;
            }
  
            if(B == null) {
                B = headA;
            } else {
                B = B.next;
            }
        }
        return A;
    }
```
We can make this much more readable by using multiplexers:
```java
public ListNode getIntersectNode(ListNode headA, ListNode headB) {
	ListNode A = headA;
	ListNode B = headB;
	while(A != B) {
		A = (A == null) ? headB : A.next;
		B = (B == null) ? headA : B.next;
	}
	return A;
}
```


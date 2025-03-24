
**Big O Notation for arrays**

When defining the Big O for an array we will represent it using $O(N)$ since the size of the array will be $N$, however the size of the array when removing any empty elements will be $n$ elements.

**Accessing an element in an array**

When accessing an element in an array, it is assumed that it takes a constant time, i.e $O(1)$

**What is the cost of insertion when inputting an element in an array?**

The cost of insertion of a single element: $T(n) = O(n-i)$o

Let's say we want to insert an element $e$ to the index $i$, we do this by shifting the elements that are greater then the index $i$, then we overwrite the value in the index $i$ after the shift with the element $e$.

![[Pasted image 20240115132639.png]]


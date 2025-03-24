
**What is a multiset?**

A multiset is a set where the same element appears more then once

**What is a multimap?**

A same key can be mapped to multiple values, i.e: an index

**Operations that can be applied to a set via code**

![[Pasted image 20240117170218.png]]

**How to store a set via code**

A set can be stored in an array or list, elements are stored according to some canonical ordering, the space used is $O(n)$

![[Pasted image 20240117170359.png]]

Any of the set operations can be implemented by using generic merging:

- For intersection: only copy the elements that are duplicated in both lists
- For union: copy every element from both lists excluding duplicates
- For subtraction: only copy elements that are not in list $B$ 

All methods run in $O(n_{A}+n_{B})$ time such that $n_{A/B}$ are the size of list $A,B$, provided that the auxiliary methods run in $O(1)$ time. 
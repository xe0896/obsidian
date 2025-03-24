
**What is a map?**

A map is a searchable collection of key-value entries similar to queues and stacks.

**What are the operations used in a map?**

Inserting, searching and deleting items.

**Characteristics of a map**

Multiple entries with the same key are not allowed

**What are some applications for a map?**

- Mapping ID's 
- DNS maps to an IP address
- RGB corresponding to a color

**Functions used in a map**

![[Pasted image 20240206121932.png]]

And how they work can be seen in the example below:

![[Pasted image 20240206122055.png]]

**Performance of a list-based map**

Basic functions such as get(), remove and put() take $O(n)$ time since we traverse the whole list in order to find an element in the worst case scenario where the element doesn't exist. However the implementation of an un-ordered list is only effective for small map sizes, we must consider large map sizes.

Surprisingly we can implement these basic methods in $O(1)$ time using a different approach using hash tables.

### pop/push, shift/unshift
Arrays are used for common data structures such as stacks and queues, meaning they have their own pre-built functions to convert an array to these data structures with simple functions. This also will mean that a given array can be utilise the functions of a normal stack and queue at the same time, giving them a special name Deque.

There are four main functions that allow us to use an array like it is a Deque:
- If we wanted to act as a queue we use the functions `push` to append at the end and `shift` to shift the elements and return the first element
- If we wanted to act as a stack we use the functions `push` to append at the end of the list and `pop` to take the element at the end
The last function is named `unshift` which adds the given element to the beginning of the array. The four functions will act as expected and doesn't need any clarification.
You are given an integer n. Return all well-formed parentheses strings that you can generate with n pairs of parentheses.
***
This question can be seen as a backtracking question instantly as it wants us to generate something that has some constraints, this means that we can make a tree that considers possibilities and since the branching factor would only be `2`, it will be appropriate.

We would need a base case and we can do this by looking at a small example like `n=2` which means we need two pairs of `(` and `)` and ensure it is valid. A valid parenthesis sequence would need two things, one thing would be that the amount of closing brackets and opening brackets are equal, and the other is that `n` is equal to both counts. 

We can see this base case is valid if we look at the values `n=2` would output: `(())` and `()()` and see that we need both the frequency of `(` and `)` are equal and that both frequencies are equal to `n`. 

Now we have two options to do at each point of the tree, to either append an opening parenthesis or a closing parenthesis and this decision will depend on two conditions: `openN < n` and `openN > closedN` where `openN` and `closedN` are the amount of opening and closing parenthesis of this function call respectively. 

The reason for `openN < n` is because we initially append `(` greedily to then add `)` later on which `openN > closedN` would do since our first answer would always be `(((..)))` and then we would backtrack from this answer to when `openN 
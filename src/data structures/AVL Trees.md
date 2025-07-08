An AVL tree can be seen as an optimised binary tree, this is because a binary tree can be heavily in-balanced and lose its `O(log n)` retrievals and go down to `O(n)`. Consider inserting the number `1` first then `2,3,4` and `5`, this will construct the following binary tree:

ADD IMAGE OF THIS

The binary tree acts like a linked-list which has a `O(n)`retrieval time, which is not great if we have large amounts of data. The initial number we inserted was `1` which then is less then `2` which is then less then `3` and so on, this greatly affects the in-balance of the tree and in run-time we cannot affect the order of our insertions since in a realistic scenario we cannot organise our data first before insertion. 

This means that we must rely on a dynamic data structure that will optimise itself after insertion, the reason we do not optimise first then insert is because we do not know where the imbalance will occur after insertion, this means that we should just insert expecting an imbalance where we can optimise it right afterwards. 

AVL trees will optimise our tree via rotations, but we must be able to identify if we even have an imbalance to see if any optimisations are required, the rule AVL trees use is $|h_{L} - h_{R}| \leq 1$ which means for a given node, the left subtree height $h_{L}$ minus its right subtree height $h_{R}$ must be less than or equal to `1`. This enforces that our trees are not to imbalance on each node, it is also important to note that when inserting a new node our condition is not needed to be checked for every node in the tree, we should only re-calculate our condition for a node if its height has been changed due to this new insertion. 

The way we can tell if a height has changed is done by our backtrack from recursion which will be outlined later, but in a nutshell it will insert our value and backtrack to its ancestors and compare its stored height with our new height due to the insertion of a new node, it will increment as we go up (height) and could be different as we backtrack, if we do find that they are the same then we can cut off the search early as it hasn't affected the heights this far up.

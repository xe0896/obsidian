Given a binary tree, determine if it is **height-balanced**.
***
This problem can easily get confusing, in terms of what the question is actually wanting us to do. To determine if a tree is height-balanced we must check the condition for $|h_{L} - h_{R} \leq 1|$ where $h_{L}$ and $h_{R}$ are the heights for the left and right subtree for a node respectively. One may try do this just for the root but we must do this for every node and once we find an inconsistency we can cut the search off early and return `false`.

Our traversal for this question will be post-order since it first goes to the `left` then `right` then it can use this information to calculate $|h_{L} - h_{R}|$ and ensure it is less then or equal to `1`, in-order wouldn't work since it does the calculation in-between the information gathering so it doesn't makes sense to use in-order.

We can re-use some of the logic from 
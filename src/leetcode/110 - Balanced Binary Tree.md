Given a binary tree, determine if it is **height-balanced**.
***
This problem can easily get confusing, in terms of what the question is actually wanting us to do. To determine if a tree is height-balanced we must check the condition for $|h_{L} - h_{R} \leq 1|$ where $h_{L}$ and $h_{R}$ are the heights for the left and right subtree for a node respectively. One may try do this just for the root but we must do this for every node and once we find an inconsistency we can cut the search off early and return `false`.

Our traversal for this question will be post-order since it first goes to the `left` then `right` then it can use this information to calculate $|h_{L} - h_{R}|$ and ensure it is less then or equal to `1`, in-order wouldn't work since it does the calculation in-between the information gathering so it doesn't makes sense to use in-order.

We can can re-use similar logic that we used for `104 - Maximum Depth of Binary Tree` since this question is basically asking for us to calculate the heights for a left and right nodes subtree and ensuring it meets our condition $|h_{L} - h_{R}|$

Given that we need to cut-off the search early once we find an inconsistency to make our solution efficient, there will be a lot of return statements regarding the left and right subtree. To show an inconsistency we will return `-1` for a particular sub-tree (left or right) or there can be an inconsistency on our current node which will be calculated with `Math.abs(left - right)` where `left` and `right` are the heights for the left and right subtrees (for a particular sub-tree they will also use `Math.abs`, since all nodes will experience this):
```java
public boolean isBalanced(TreeNode root) {
	return post(root, 0) != -1;
}
public int post(TreeNode root, int depth) {
	if(root == null) {
		return depth;
	}

	int left = post(root.left, depth + 1);
	if(left == -1) {
		return -1;
	}
	int right = post(root.right, depth + 1);
	if(right == -1) {
		return -1;
	}
	if(Math.abs(left - right) > 1) {
		return -1;
	}
	return Math.max(left, right);
}
```








Given the `root` of a binary tree, return _its maximum depth_.

A binary tree's **maximum depth** is the number of nodes along the longest path from the root node down to the farthest leaf node.
***
This solution would be done similar to in-order traversal or post-order traversal but wouldn't store the value visited since we just care about the depth. The trick is (but not limited) to increment our depth when we go to the next node in the return statement or a function call, for our implementation we will be incrementing our depth on the function call of our in-order traversal.

We must pass the `depth` variable as a parameter to get a local copy for each function call so that we just don't make `depth = no. of nodes` as it would be shared if we didn't make a copy. Given this new `depth` after each call we should check to see if it is the highest `depth` we have encountered using `Math.max()`:

```java
private int h;
public int maxDepth(TreeNode root) {
	int depth = 1;
	inOrder(root, depth);
	return h;
}

public void inOrder(TreeNode root, int depth) {
	if(root != null) {
		h = Math.max(h, depth);
		inOrder(root.left, depth + 1);
		inOrder(root.right, depth + 1);
	}
}
```
### Concise solution
The above solution is pretty concise but it can be much more concise, the logic is the same by using a traversal and using `Math.max()` to get the maximum depth so far, but it will combine both functions into one as we can capture the behaviour of both of them in a clean and concise way:
```java
public int maxDepth(TreeNode root, int depth) {
	if(root != null) {
		return depth;
	}
	return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
}
```




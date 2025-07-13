Given the `root` of a binary tree and an integer `targetSum`, return `true` if the tree has a **root-to-leaf** path such that adding up all the values along the path equals `targetSum`.
***
This question would require a pre-order traversal, since it follows the sequence of: visit, left, right. The fact that it visits a node first will allow us to start summing the root to a leaf and comparing it with our `targetSum` once we reach a leaf which can be identified by the condition: `root.left == null %% root.right == null`

Furthermore, once we reach a `null` node we must return `false` as we are looking to go from the `root` to a leaf but not a `root` to `null`, this also allows us to have a simple base case as we must stop the search once we find that there is no path that sums up to `targetSum`. 

We do this process for a given nodes children (left and right) who will continue until they satisfy one of our two base cases: `root.left == null && root.right == null && sum == targetSum` or `root == null` which these two conditions will return a `boolean` so we can see the validity of a child by assigning it to a `boolean` and if either is `true` then we must return `true` and propagate this to the `root` to return `true` as there exists a valid path:
```java
public boolean hasPathSum(TreeNode root, int targetSum) {
	int sum = 0;
	return preorder(root, targetSum, sum);
}

public boolean preorder(TreeNode root, int targetSum, int sum) {
	if(root == null) {
		return false;
	}
	int val = root.val;
	sum += val;
	if(root.left == null && root.right == null) {
		return sum == targetSum;
	}
	boolean left = preorder(root.left, targetSum, sum);
	boolean right = preorder(root.right, targetSum, sum);

	return left || right;
}
```

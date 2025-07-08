Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
***
This question was very simple if you know how to do any binary tree traversal, such as in-order. The logic will perform this traversal but with some checks before we continue as we want to terminate the recursive calls once we find an inconsistency. The first checks will be `null` checks between the two nodes `p` and `q` as they should both have `null` at the same places, enforcing that the structure is the same and not just the values.
```java
public boolean isSameTree(TreeNode p, TreeNode q) {
	return inOrder(p,q);
}

public boolean inOrder(TreeNode p, TreeNode q) {
	if(p == null && q == null) {
		return true;
	}
	if(p == null || q == null) {
		return false;
	}
}
```
The above enforces that the structure is the same as the first if-statement will check that they are the same and the second if-statement will never have `p = null` and  `q = null` as its been absorbed by the first if-statement. If one is `null` and the other is not `null` then they are not the same and we can return `false`.

After we reach the end of the recursive stack we backtrack and we use the above as the structural check with the left-subtree then compare the values and also the right-subtree until we traverse the whole tree to say that it is the same:
```java
public boolean isSameTree(TreeNode p, TreeNode q) {
	return inOrder(p,q);
}

public boolean inOrder(TreeNode p, TreeNode q) {
	if(p == null && q == null) {
		return true;
	}
	if(p == null || q == null) {
		return false;
	}
	if(!inOrder(p.left, q.left)) {
		return false;
	}
	if(p.val != q.val) {
		return false;
	}
	return inOrder(p.right, q.right);
}
```
There are a lot of return statements since we want to cut the search early as soon as we find any inconsistencies between the two trees.
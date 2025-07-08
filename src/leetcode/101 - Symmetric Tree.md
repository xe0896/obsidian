Given the `root` of a binary tree, _check whether it is a mirror of itself_ (i.e., symmetric around its center).
***
This problem is very similar to `101 - Same Tree` in the sense of traversing until we find any inconsistencies based on a condition, in this case our condition is that the given `root` is symmetric.

Before we start, we should understand what it means for a tree to be symmetric, it may seem as if we want the structure to be the same but its symmetric in a mirrored way meaning its not bound to structure only but a specific structure of mirroring:
![[Pasted image 20250707121819.png]]
This tree is mirrored properly, whereas this one is not:
![[Pasted image 20250707121841.png]]
In the symmetric tree, we see that for the sub-tree root `2` on both sub-trees we see that `.left = .right` and we can use this condition to check to see if the node is mirrored. We also need to check for `.right = .left` to ensure that the structure is the same in terms of the `null` being placed correctly to make the tree symmetric as well as the values and full subtrees:
```java
public isSymmetric(TreeNode root) {
	return check(root.left, root.right);
}

public boolean check(TreeNode p, TreeNode q) {
	if (p == null && q == null) {
		return true;
	}
	if (p == null || q == null) {
		return false;
	}

	if(p.val != q.val) {
		return false;
	}

	if(!check(p.left, q.right)) {
		return false;
	}
	
	return check(p.right, q.left);
}
```
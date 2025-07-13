Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
***
This question like `110 - Balanced Tree` will rely on our height calculation method from `104 - Mazimum Depth of Tree`, the only difference is that we want the minimum depth. The only extra thing we must consider is that if we was to be given a binary tree that acts like a linked list:
ADD IMAGE HERE

Then we should return `5` and not `1` since our left-subtree is empty and our answer shouldn't consider that as a valid leaf, answers could easily fall for this trap since they may consider `null` to be a valid leaf and return `1` in this case. 

To counter-act this we must have some extra logic that will make us ignore these invalid leafs, there are two methods to do this but one is much more practical then the other. The practical one is that we take the max height if we are at a node where either its left or right subtree height is `0`, this will allow us to ignore cases like shown above where we are at a node and one of its children is `null` when the other is a valid node. The unpractical one would be to check to see if a nodes left or right child is `null`, if this is the case then we assign that height to be a large number such that we do not explore it as we want the minimum depth, this is obvious to be unpractical.

We can capture our logic when it states that we want to pick the max height given that our left and right subtrees has a height of `0` by using an OR-statement, leading to the following answer:
```java
public int minDepth(TreeNode root) {
	return post(root);
}

public int post(TreeNode root) {
	if (root == null) {
		return 0;
	}
	int left = post(root.left);
	int right = post(root.right);

	if(left == 0 || right == 0) {
		return 1 + Math.max(left, right);
	} else {
		return 1 + Math.min(left, right);
	}
}
```
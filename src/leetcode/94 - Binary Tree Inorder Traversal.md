Given the `root` of a binary tree, return _the in-order traversal of its nodes' values_.
***
An in-order traversal follows attempts 3 actions and if one fails it will fall to the next: left, visit, right. 

![[Pasted image 20250706230604.png]]
The example above will begin at `1` then checks to see if a node exists on its left, and `2` is at its left so it traverses to `2` and repeats to reach `4` and there is no left node from `4` so it will visit `4` and store it as the first node.

Note that the left, visit, right rule saves, meaning if a node has satisfied left then it can no longer do that again. This is relevant since we backtrack to `2` from `4` and since we have already done left for `2` the next highest priority action is visit so we must also store `2` as the second node.

This repeats until we reach the final answer of: `[4,2,6,5,7,1,3,9,8]`. 

The input of this tree would be: `[1,2,3,4,5,null,8,null,null,6,7,9]` making the input act like adding nodes via BFS.

This question uses a `TreeNode` object so its important to outline the methods and attributes provided:
```java
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode() {}
	
	TreeNode(int val) { 
		this.val = val; 
	}
	
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
```

This implementation is simple if we use recursion as we can keep on going down `root.left` until we find that `root.left==null` and once this happens we visit the node and add it to our list and then check for `root.right` and repeat this process, if that also so happens to be `null` then we have fully passed the checks for this node and the function backtracks and repeats this process.
```java
import java.util.List;
import java.util.ArrayList;

public List<Integer> inorderTraversal(TreeNode root) {
	List<Integer> list = new ArrayList()<>;
	inOrder(list, root);
	return list;
}

public void inOrder(list, root) {
	if(root != null) {
		inOrder(root.left);
		list.add(root.val);
		inOrder(root.right);
	}
}
```
### Iterative solution
The recursion implementation could be seen as trivial as it is a very well-known solution for this question, the iterative solution requires a bit more thought.

```java
public int factorial(n) {
	if(n == 1) {
		return 1;
	}
	return n * factorial(n-1);
}
```

Given an integer array `nums` where the elements are sorted in **ascending order**, convert _it to a_ **_height-balanced_** _binary search tree_.
***
This problem has a natural divide and conquer structure, since we want a height-balanced tree so our BST to be well balanced. This can be seen easily by looking at an odd size array`[-11,-2,1,0,2,3,5]`:

The labels `L` and `R` represent the subtrees of the current midpoint node. As the recursion reaches the base case (when there are no more elements to process), it backtracks, allowing us to construct the tree from the bottom up by attaching these subtrees as children.

We can create a helper function that handles the recursion which is called first at the main function, the helper function will have parameters `L,R` to handle the new pointers for recursive calls and the `nums` array as it is not global.

The initial `L,R` would be `0` and `nums.length-1` respectively to capture the whole array as this would be our root.
```java
public TreeNode sortedArrayToBST(int[] nums) {
	return divide(0, nums.length-1, nums);
}

public TreeNode divide(int L, int R, int[] nums) {}
```
Before we start with our recursion we must figure out an appropriate base case, a way to think about this is to look at our earlier example and look at the last case. We see that our pointers `L` and `R` are equal which are both pointing at `-2`, but if we was to divide again we see that `L > R` which would mean we have encountered every element and should stop there. The value we should return is `null` from this base case as `null` represents no children which `-2` will have since we have gone through every element.

When given two pointers `L` and `R` we want to capture the midpoint of these two in the array and use our recursive function to create their children. Their children will also want to find their midpoint of their new pointers of `L` and `R` since the new `L` and `R` scope will be halved so we can find more appropriate midpoints. When we mention appropriate midpoints we want to find nodes that make this a height-balanced tree and since this is sorted we can find this by continuously halving our array for both sub-trees of the root, which is shown in the previous example.

We can access the children directly by using `node.right` and `node.left` where `node` is the midpoint of the previous halved scoped array:
```java
public TreeNode divide(int L, int R, int[] nums) {
	if (L > R) {
		return null;
	}
	int M = (L+R)/2;
	TreeNode node = new TreeNode(nums[M]);
	node.left = divide(L, M-1, nums);
	node.right = divide(M+1, R, nums);
	return node;
} 
```
This leads to the following correct solution:
```java
public TreeNode sortedArrayToBST(int[] nums) {
	return divide(0, nums.length-1, nums);
}

public TreeNode divide(int L, int R, int[] nums) {
	if (L > R) {
		return null;
	}
	int M = (L+R)/2;
	TreeNode node = new TreeNode(nums[M]);
	node.left = divide(L, M-1, nums);
	node.right = divide(M+1, R, nums);
	return node;
} 
```
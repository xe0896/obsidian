Given the `root` of a binary tree, return _the postorder traversal of its nodes' values_.
***
Exactly the same question as `144 - Binary Tree Preorder Traversal` but we are using post-order, meaning we must follow the sequence: `Left -> Right -> Visit`:
```java
public List<Integer> postorderTraversal(TreeNode root) {
	List<Integer> list = new ArrayList<>();
	postOrder(root, list);
	return list;
}
  
public void postOrder(TreeNode root, List<Integer> list) {
	if(root != null) {
		postOrder(root.left, list);
		postOrder(root.right, list);
		list.add(root.val);
	}
}
```

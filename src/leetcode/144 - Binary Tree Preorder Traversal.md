Given the `root` of a binary tree, return _the preorder traversal of its nodes' values_.
***
This question is very simple to `94 - Binary Tree Inorder Traversal` but instead of `Left -> Visit -> Right` we do `Visit -> Left -> Right` as we are doing preorder and not inorder:
```java
public List<Integer> preorderTraversal(TreeNode root) {
	List<Integer> list = new ArrayList<>();
	preOrder(root, list);
	return list;
}
	
public void preOrder(TreeNode root, List<Integer> list) {
	if(root != null) {
		list.add(root.val);
		preOrder(root.left, list);
		preOrder(root.right, list);
	}
}
```

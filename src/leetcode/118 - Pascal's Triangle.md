Given an integer `numRows`, return the first numRows of **Pascal's triangle**.

In **Pascal's triangle**, each number is the sum of the two numbers directly above it as shown:

![](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)
***
This question relies on knowledge on ArrayLists and the pre-defined structure of Pascal's Triangle, other then that it is a straight forward problem but it is easy to get an index of our bounds errors here.

Looking at the Pascal Triangle, we can see that the first two rows are always `[[1]. [1,1]` given that `numRows > 1` allowing us to start at this point so that we can build our tree:
```java
public List<List<Integer>> generate(int numRows) {
	List<List<Integer>> ans = new ArrayList<>();
	List<Integer> firstRow = new ArrayList<>(List.of(1));
	ans.add(firstRow);
	if(numRows == 1) {
		return ans;
	}
	List<Integer> secondRow = new ArrayList<>(List.of(1,1));
	ans.add(secondRow);
```
Since we have already defined the first two rows, we can start at `i=2` when we build our tree since the first two rows represent `i=0,1` respectively. 

Our logic for this question will be to define an ArrayList with `i+1` elements since the function we will be using to define a list of `n` elements in our ArrayList is `Collections.nCopies(n, 0)` which creates `n` elements of `0` (dummy value), since each row `i` will be used to calculate the next row `i+1`.

Inspecting the triangle we can see that the triangle is surrounded by `1` which we can pre-define in our loop:
```java
for(int i = 2; i < numRows; i++) {
	List<Integer> list = new ArrayList<>(Collections.nCopies(i + 1, 0));
	list.set(0, 1);
	list.set(i, 1);
}
```
We use the `.set` to assign a value at a specific value rather then append at the end of list via `.add`.

For our addition process we will be taking two pairs at index `j` and `j-1` meaning `j` must start index `1` and stop when `j < i` since we are taking pairs `j` and `j-1` and being bounded by the list **above** and not our current list.

We first need to grab our list above using `.get` and simply set our value at `j` to be the sum of `j` and `j-1` at the previous list and append this final list to our answer:
```java
public List<List<Integer>> generate(int numRows) {
	List<List<Integer>> ans = new ArrayList<>();
	List<Integer> firstRow = new ArrayList<>(List.of(1));
	ans.add(firstRow);
	if(numRows == 1) {
		return ans;
	}
	List<Integer> secondRow = new ArrayList<>(List.of(1,1));
	ans.add(secondRow);
		for(int i = 2; i < numRows; i++) {
			List<Integer> list = new ArrayList<>(Collections.nCopies(i + 1, 0));
			list.set(0, 1);
			list.set(i, 1);
		for(int j = 1; j < i; j++) {
			List<Integer> prev = ans.get(i-1);
			list.set(j, prev.get(j-1) + prev.get(j));
			}
			ans.add(list);
		}
	return ans;
}
```
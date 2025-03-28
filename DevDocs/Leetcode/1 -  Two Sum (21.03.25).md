Given an array of integers `nums` and an integer `target`, return _indices of the two numbers such that they add up to `target`_.

You may assume that each input would have **_exactly_ one solution**, and you may not use the _same_ element twice.

You can return the answer in any order.
***
This problem was very easy to see what I needed to do, the hard part was figuring out how to make this not $O(n^2)$, but we will focus on the easy solution for now. 

Given that we have to compare two elements in this array the straight-forward approach would be to create a nested loop of iterators $(i,j)$ and compare every single combination until we eventually find: 
```java
nums[i] + nums[j] = target;
```
The condition above was easily found by doing a simple example, such as `nums = [0,1,2,5,6,6]` and `target = 12`. The question wants us to find the two indexes that when used to index this array sums up to `target` we can easily deduce that `nums[4] + nums[5] = 12` and since we cannot use the same element an additional if-statement will need to be checked to ensure that $i \neq j$ as `6` would of been re-used.

```java
public int[] twoSum(int[] nums, int target) {
	int length = nums.length;
    int[] twoAns = new int[2];
	for (int i = 0; i < length; i++) {
		for (int j = 0; j < length; j++) {
			if (i != j && (nums[i] + nums[j] == target)) {
				twoAns[0] = i;
				twoAns[1] = j;
				return twoAns;
			}
		}
	return null; // wont be reached since we are given that every array has an answer
}
```

## $O(n)$ solution

Not sure when I will go round to figuring this one out
## Lessons learned

-  Lessons will be learned from $O(n^2)$ probably
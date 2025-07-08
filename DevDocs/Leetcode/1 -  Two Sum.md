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
The `O(n)` solution uses the fact that we can the two indices by checking to see if `target-x` exists in our current iteration, and if it does exist then the index that this value is stored in is the complement, the problem is that checking to see if a value exists every time can get expensive so we use a hash-map for its `O(1)` access time.
```java
public int[] twoSum(int[] nums. int target) {
	Map<Integer, Integer> map = new HashMap<>();
	for(int i = 0; i < nums.length; i++) {
		int complement = target - nums[i];
		if(map.containsKey(complement)) {
			return new int[] {map.get(complement), i}'
		}
		map.put(nums[i], i);
	}

	return new int[];
}
```
## Lessons learned

-  Lessons will be learned from $O(n^2)$ probably
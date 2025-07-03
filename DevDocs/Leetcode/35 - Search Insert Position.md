Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with `O(log n)` runtime complexity.
***
Reading the description that we want a search algorithm that doesn't always return the exact index since it doesn't exist and it must run in `O(log n)` time and is ordered, this screams binary search.

The only small difference that could be different to other binary search implementations is that we must return the index if it was to be inserted in order, this means that we must return `L` instead of  `midpoint` which would be `0` if it didn't exist, `L` would be the correct choice since it would be the smallest index where `target` fits as `L > R` since we would exit our `while` loop.
```java
public int searchInsert(int[] nums, int target) {
	int L = 0;
	int R = nums.length -1;
	int midpoint = nums.length / 2;
	while(L <= R) {
		midpoint = (L+R)/2;
		if (nums[midpoint] == target) {
			return midpoint;
		} else if (nums[midpoint] < target) {
			L = midpoint + 1;
		} else {
			R = midpoint - 1;
		}
	}
	return L;
}
```
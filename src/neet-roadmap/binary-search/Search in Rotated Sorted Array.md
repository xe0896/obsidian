You are given an array of length `n` which was originally sorted in ascending order. It has now been rotated between `1` and `n` times. For example, the array `nums = [1,2,3,4,5,6] `might become:

`[3,4,5,6,1,2]` if it was rotated 4 times.
`[1,2,3,4,5,6]` if it was rotated 6 times.
Given the rotated sorted array `nums` and an integer target, return the index of `target` within `nums`, or `-1` if it is not present.

You may assume all elements in the sorted rotated array `nums` are unique,

A solution that runs in `O(n)` time is trivial, can you write an algorithm that runs in `O(log n)` time?
***
This question is pretty tricky but once we find a certain pattern which will be outlined, it is trivial. The pattern is that we can construct two sub-arrays from our rotated array if we find the point where the array has been cut through, which we will denote as an index `cuttingPoint` and then perform binary search on a sorted array which is trivial to find `target`.

The point where the array has been cut through can be seen from an example, the array `[3,4,5,6,1,2]` can be broken down into two arrays if we cut it through the value `cuttingPoint = 1` in half into `[3,4,5]` and `[1,2]` where one array will have to include `nums[cuttingPoint]` and in our implementation we will be making the left sub-array contain `nums[cuttingPoint]`.

First, we need to find the `cuttingPoint` which can be done in a similar way we have done for [Find Minimum in Rotated Sorted Array] so the details won't be mentioned here:

```jsx
search(nums, target) {
	const n = nums.length;
	let L = 0;
	let R = n - 1;
	let cuttingPoint = null;
	let midpoint = null;
	
	while(L <= R) {
		midpoint = Math.floor((L + R) / 2);
		const prev = (midpoint - 1 + n) % n;
		if(nums[midpoint] === target) {
			return midpoint;
		} else if (nums[midpoint] < nums[prev]) {
			cuttingPoint = midpoint;
			break;
		} else if (nums[midpoint] > nums[R]) {
			L = midpoint + 1;
		} else {
			R = midpoint - 1;
		}
	}
}
```

Now that we have `cuttingPoint` we must consider an edge case, which is if `target` is not in the array and the array is not rotated, this means that when we do `return midpoint` here, it will make `cuttingPoint == null` and disallow us to use it for further logic, this means that we need to add conditional check to see if the `cuttingPoint` is `null`, if it is `null` then we should assign it to `0` as it is only `null` if the `target` is not found **and** it is not rotated meaning the rotation technically starts at `0`.

```jsx
cuttingPoint = (cuttingPoint) ? cuttingPoint: 0;
```

Instead of doing two binary searches in our two sub-arrays to find `target`, we can check to see if the last index of our right sub-array is greater or equal to `target` and if this is the case then the `target` is on our right-subarray, if this is not the case then it is on the left-subarray, allowing us to do binary search on only one and depending on an `O(1)` condition like this saves us from doing `log(n)` again.

To clarify on the above more as it could be a bit vague, if the `target` is less than `nums[n-1]` where `n` is `nums.length`, then that means that the left-subarray would be all greater then `target` (given that it is rotated) as it would wrap around to be even greater then `nums[n-1]`.

This means that we need to adjust our `L,R` pointers depending on this condition and since we want the left-subarray to contain the `target` then we would make the upper and lower bound of the right sub-array to be `0.. cuttingPoint - 1` respectively and for the left sub-array to have an upper and lower bound of `cuttingPoint.. n`.

```jsx
if(target <= nums[n-1]) {
	L = cuttingPoint;
	R = n - 1;
} else {
	L = 0;
	R = cuttingPoint - 1;
}
```

Now that we have our current `L,R` pointers, we can just do normal binary search and hopefully find our `target`, leading to the following code:

```jsx
search(nums, target) {
	const n = nums.length;
	let L = 0;
	let R = n - 1;
	let midpoint = null;
	let cuttingPoint = null;
	
	while(L <= R) {
		midpoint = Math.floor((L + R) / 2);
		const prev = (midpoint - 1 + n) % n;
		if(nums[midpoint] == target) {
			return midpoint;
		} else if (nums[midpoint] < nums[prev]) {
			cuttingPoint = midpoint;
			break;
		} else if (nums[midpoint] > nums[R]) {
			L = midpoint + 1;
		} else {
			R = midpoint - 1;
		}
	}
	
	cuttingPoint = (cuttingPoint) ? cuttingPoint: 0;
	
	if(nums[n-1] >= target) {
		L = cuttingPoint;
		R = n - 1;
	} else {
		L = 0;
		R = cuttingPoint - 1;
	}
	
	while(L <= R) {
		midpoint = Math.floor((L + R) / 2);
		if(nums[midpoint] == target) {
			return midpoint;
		} else if (nums[midpoint] > target) {
			R = midpoint - 1;
		} else {
			L = midpoint + 1;
		}
	}
	
	return -1;
}
```





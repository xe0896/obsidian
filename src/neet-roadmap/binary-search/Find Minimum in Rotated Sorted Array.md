You are given an array of length `n` which was originally sorted in ascending order. It has now been rotated between `1` and `n` times. For example, the array `nums = [1,2,3,4,5,6]` might become:

`[3,4,5,6,1,2]` if it was rotated 4 times.
`[1,2,3,4,5,6]` if it was rotated 6 times.
Notice that rotating the array `4` times moves the last four elements of the array to the beginning. Rotating the array 6 times produces the original array.

Assuming all elements in the rotated sorted array `nums` are unique, return the minimum element of this array.

A solution that runs in `O(n)` time is trivial, can you write an algorithm that runs in `O(log n)` time?
***
This question is pretty easy as we are told that we should be writing an algorithm that runs in `O(log n)` time which is screaming binary search. However, the binary search will obviously not be structured as the same as this array is not sorted, we will also need a different condition that we want to satisfy, in other words we aren't given a value to find like we do in normal binary search but we want to find a value that has the characteristic of being the minimum.

If we look at the example: `[3,4,5,6,1,2]` and find the minimum value `1` visually, if we look at the previous value `6`, we can see that it is always going to be greater than it (`6 > 1`) as it is the minimum value of this array and the array is sorted in ascending order.

This means that if we was to use binary search to find a value whose previous value is greater than it, then that means that this value is the minimum value of the array. However, another problem arises as if the resulting array is not rotated then once we check the value `nums[0]` then checking the previous value `nums[-1]` would be `undefined`, this means that we need to wrap around to the end of the array.

When hearing the phrase "wrap around" we should be thinking about the modulo operator, so we can define the previous value `prev` of a `midpoint` as:

```js
const prev = (midpoint - 1) % n;
```

The `-1` is there because we want the previous value relative to `midpoint` and wrap it around using `n=nums.length`, we need to be careful here as this is not fully correct as if we actually need to wrap around as if we give the value `midpoint=0` then `prev = (0 - 1) % n` in JavaScript is `-1` which is an invalid index and not the `n-1` that we expected, to mitigate this we can do the following:

```js
const prev = (midpoint - 1 + n) % n;
```

Which would remove the negative numbers and wrap around properly and avoids the operand to be negative.

In our binary search, the value that we are searching for is the value that satisfies `nums[midpoint] < nums[prev]` as the array should be increasing given that we are not at the minimum value which we have seen that the minimum value has the property of having the previous value being greater than itself as nothing is less than the minimum value.

Now we need to discuss how we will decrease our scope using our `L,R` pointers, this one is a bit tricky to see and the key thing here is to try to get closer to the point where the array has been distorted due to the rotation. If our value `nums[midpoint]` is greater than the value that the `R` pointer (upper bound) is pointing to `nums[R]` then this shouldn't be the case for a normal sorted array as the upper bound should be greater than `nums[midpoint]` as binary search assumes it is sorted, this means that the array has been distorted in between `nums[midpoint]` and `nums[R]`, and since the upper bound is always at `R` and could even be exactly at `R` we need to move the `L` pointer closer, so we decrease the scope by using `L` in this case by doing the usual `midpoint + 1`.

For the other case where `nums[midpoint] <= nums[R]` means that this is normal behaviour going on from `nums[midpoint] <= nums[R]` so we need to forget about this interval and move the `R` pointer closer to the distortion which would be happening between `L` and `nums[midpoint]` as distortion implies minimum value.

One more thing we need to consider is if we are given a sorted array, this means that our special binary search won't output the minimum value as it is assuming it is not sorted, and since it is sorted we can just output `nums[0]` if we do not return anything in our while loop.

Leading to the following answer:

```js
findMin(nums) {
	let L = 0l
	let n = nums.length;
	let R = n - 1;
	
	while(L <= R) {
		const midpoint = Math.floor((L + R) / 2);
		const prev = (midpoint - 1 + n) % n;
		if(nums[midpoint] < nums[prev]) {
			return nums[midpoint]
		} else if (nums[midpoint] > nums[R]) {
			L = midpoint + 1;
		} else {
			R = midpoint - 1;
		}
	}
	return nums[0];
}
```




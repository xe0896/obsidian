Given an integer array `nums` sorted in **non-decreasing order**, remove the duplicates [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm "https://en.wikipedia.org/wiki/In-place_algorithm") such that each unique element appears only **once**. The **relative order** of the elements should be kept the **same**. Then return _the number of unique elements in_ `nums`.

Consider the number of unique elements of `nums` to be `k`, to get accepted, you need to do the following things:

- Change the array `nums` such that the first `k` elements of `nums` contain the unique elements in the order they were present in `nums` initially. The remaining elements of `nums` are not important as well as the size of `nums`.
- Return `k`.
***
This problem was pretty simple but was different from the others since the answer didn't just depend on a singular return value but it also depended on another value which was the array orderings. The return value which is the amount of unique elements in the given array was a simple computation since it would just be the value our pointer takes for when the unique orderings stops, in our case it has been labelled `k`

Regarding the actual array orderings, we can start at the index `i=1` since the first element will always be unique and in the correct place, assuming that the array is not empty which the problem specification does state `1 <= nums.length <= 30000`. 

The main logic of this solution is that it will have an additional function that returns a `boolean` that checks if the given value from the array is unique, to this we can check this value against our current unique array orderings that is bounded by `k`:
```java
public int duplicateChecker(int[] nums, int k, int value) {
	for(int i = 0; i < k; i++) {
		if(nums[i] == value) {
			return false;
		}
	}
	return true;
}
```

If this returns `true` then we can assign this value at index `k` and then increment `k` and repeat this process.
```java
public int removeDuplicates(int[] nums) {
	int k = 1;
	for(int i = 1; i < nums.length; i++) {
		if(duplicateChecker(nums, k, nums[i])) {
			nums[k] = nums[i]
			k++;
		}
	}
	return k;
}
```
This solution is really slow but the memory beats `78%` of submissions so we take those
### Faster solution
A faster solution would be much simpler and more elegant then our previous solution, the logic boils down to this: we will also assume that `i=1` like before but we will take advantage over the fact that this array is non-increasing. order We do this by checking to see if `nums[i-1] != nums[i]`, if this is `true` then this is the first unique element of this value since this `nums[i]` value will not appear anywhere else other then around `nums[i]` since the array is in order. We can then take `nums[k]` and assign this to `nums[i]` which will ensure the unique array orderings are being updated and then increment `k`:

```java
public int removeDuplicates(int[] nums) {
	int k = 1;
	for(int i = 0; i < nums.length; i++) {
		if (nums[i-1] != nums[i]) {
			nums[k] = nums[i];
			k++;
		}
	}
	return k;
}
```
This beats `100%` of solutions on speed but has terrible memory usage.
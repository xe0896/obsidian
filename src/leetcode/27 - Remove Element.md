Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in `nums` [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm). The order of the elements may be changed. Then return _the number of elements in_ `nums` _which are not equal to_ `val`.

Consider the number of elements in `nums` which are not equal to `val` be `k`, to get accepted, you need to do the following things:

- Change the array `nums` such that the first `k` elements of `nums` contain the elements which are not equal to `val`. The remaining elements of `nums` are not important as well as the size of `nums`.
- Return `k`.
***
This problem was a bit weird initially since I never took advantage of the problem not caring what goes beyond index `k`, so this solution is incomplete and not great but documenting failures is fine. The logic boils down to incrementing `k` with `i` until we reach `val` and we count how many `val`'s in a row and store them into a variable `count` which would allow us to access the values beyond the potential in a row `val`'s and replace the `val` with the values beyond the `val` row, this doesn't work since it assumes we have something like: (`val=2`)`[0,1,2,2,3,0]` and not `[0,1,2,2,3,2]` as the in a row `val` in the first array has `[3,0]` to swap but the second array has `[3,2]` to swap but it includes `2` which is our `val` so what do we do next?

Here is the implementation which is in-complete:
```java
public int removeElement(int[] nums, int val) {
	int count = 0;
	int k = 0;
	for(int i = 0; i < nums.length; i++) {
		if(nums[i] == val) {
			while(nums[i] == val) {
				if(i < nums.length - 1) {
					count++;
					i++;
				 else {
					break;
					}
				}
		} else {
			k++;
		}
		i = i - count;
		for(int j = 0; j < count; j++) {
			nums[k] = nums[k + count];
			k++;
		}
		count = 0;
	}
	return k;
}
```

After realising that this type of logic is just not clean at all, still entirely possible but not worth to further pursue another solution would be just to iterate over the array with two pointers where pointer `i` would be at the start and `j` would be at the end and elements at index `i`, if they was equal to `val` then we swap it with the item at index `j` and if the index `j` was equal to `val` then we skip that index and go to the next until we can swap and continue with incrementing `i` until `i=j`

Another type of solution which is more simpler then the one mentioned above in terms of space complexity, would be to have an index `i` iterating over the array and boils down to this logic:
For each `i` from `0` to `nums.length - 1`:
- If `nums[i] != val`, copy it to `nums[k]` and then increment `k`.
- If `nums[i] == val`, just skip it and don’t increment `k`. 

The one pointer-solution is just simply:
```java
public int removeElement(int[] nums, int val) {
	int k = 0;
	for(int i = 0; i < nums.length; i++) {
		if (nums[i] != val) {
			nums[k] = nums[i];
			k++;
		}
	}
	return k;
}
```
The two pointer-solution:
```java
public int removeElement(int[] nums, int val) {
	int k = 0;
	int j = nums.length-1;
	while(k <= j) {
		if(nums[k] == val) {
			if(nums[j] == val) {
				while(k <= j && nums[j] == val) {
					j--;
				}
			}
			if(k <= j) {
				nums[k] = nums[j];
				j--;
			}
		} else {
			k++;
		}
	}
	return k;
}
```
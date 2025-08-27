Given an array `nums` of size `n`, return _the majority element_.

The majority element is the element that appears more than `⌊n / 2⌋` times. You may assume that the majority element always exists in the array.
***
This question with its `[n / 2]` frequency is implied if we just find the value that occurs the most since it tells us we only need to output a single element. We can then simply reword this question to be looking for the most frequent element in our array, to do this we can use a `HashMap` with key value pair `(val, frequency)` where we can iterate over our given array and check to see if we have encountered the given `val` yet, if not we can add it to the map with a frequency of `1`, if we have encountered it before we can check to see if its current frequency is the highest we have seen, if this is the case then we can store its `val` into a variable `ans` and rewrite the `max` we have seen so we can check this against new encounters:

There is a slight issue with this since if we had an array length of `1` then the first check of it being in the list won't be triggered again and won't rewrite `max` as we only iterate from `0` to `nums.length - 1`, we can catch this edge case before we enter our loop:
```java
public int majorityElement(int[] nums) {
	int max = 0;
	int ans = 0;
	if(nums.length == 1) {
		return nums[0];
	}
	Map<Integer, Integer> map = new HashMap<>();
	for(int i = 0; i < nums.length; i++) {
		if(map.containsKey(nums[i])) 
			int newVal = map.get(nums[i]) + 1;
			if(max < newVal) {
				ans = nums[i];
				max = newVal;
			}
			map.put(nums[i], newVal);
		} else {
			map.put(nums[i], 1);
		}
	}
	return ans;
}
```
### Follow-up
The question states if we could find a solution that still has linear time but with a constant space complexity, our answer above maintains a `HashMap` which can hold up most `n` elements which violates the constant space complexity.

We can use the Boyer-Moore Voting Algorithm which will run in `O(n)` and only take up `O(1)` space, this is done by maintaining two variables `count` and `current`:
- If count is `0` then we assign a new `current` at index `i`
- If we find that `current = nums[i]` then we increment `count`, else we decrement `count`

In our earlier answer we just looked for the most frequent element and since we are told that every input has an answer this worked, if we was given an input like `[1,2,3,4,1,5,6,7]` then we will get an incorrect output of `1` since even if it is the most frequent it only appears twice when it should appear `[n / 2`] times. 

The Boyer-Moore Voting Algorithm will ensure that it will only output an element that appears more then `[n / 2]` and is much more elegant. The reason why it will enforce this is because if we had an element `x` that was the majority element then the elements that are not `x` cannot out power `x` since `x` will appear `[n / 2]` times and we will always have `count > 0` for that `current` element `x`:
```java
public int majorityElement(int [] nums) {
	int count = 0;
	int current = 0;
	  
	for(int i = 0; i < nums.length; i++) {
		if(count == 0) {
			current = nums[i];
		}
		if(current == nums[i]) {
			count++;
		} else {
			count--;
		}
	}
	return current;
}
```


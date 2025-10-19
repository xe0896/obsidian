You are given an integer array `nums` where each element `nums[i]` indicates your maximum jump length at that position.

Return `true` if you can reach the last index starting from index `0`, or `false` otherwise.
***
This question has two types of solutions, which we will explore both as one of them is very concise. The first solution uses dynamic programming by creating a tree of all possibilities and we will use a cache `dp` to make it optimised, but it is still `O(n^2)`. 

Our base case for this solution will be whenever we reach the end of the array as that means our starting position has reached the end, we will track our position using `index` meaning the base case (to return `true`) will be: `index >= nums.length - 1`. 

The amount of times we will use recursion for a given `index` will depend on `nums[index]` so we will use a for loop that will initially start at `index + 1`, the reason for this is to make us not need to do `.. +1)` in the recursion loop for the next index meaning our boundary will need to be `i <= index + nums[index]` and that `<=` is key since we are starting at `index + 1`. We could just do the `.. +1)` instead but that will change the boundary conditions so it felt necessary to explain this, we could of just done `for(let i = index; i < index + nums[index]; i++)`. 

Our cache will work like every other cache and check to see if `dp[index] !== undefined` as that will show that we have explored this `index` already and know what it leads to, we use `undefined` as our `dp` cache will initially fill in the empty elements with `undefined` since `dp = Array(nums.length)`. 

The recursive calls in our for loop will be checking to see if it returns `true`, if this is the case then we will set `dp[index] = true`  and then return `true` as when the for loop ends we will return `false` so we can filter out all the "`true"` indexes and only return `false` for the `"false"` indexes plus assert `dp[index] = false`:

```js
var jumpGame = function(nums) {
	const dp = Array(nums.length);
	return helper(0, dp, nums);
}

var helper(index, dp, nums) {
	if(index >= nums.length - 1) {
		return true;
	}
	
	if(dp[index] !== undefined) {
		return dp[index];
	}
	
	for(let i = index + 1; i <= index + nums[index]; i++) {
		if(helper(i, dp, nums)) {
			dp[index] = true;
			return true;
		}
	}
	
	dp[index] = false;
	return false;
}
```
### O(n) solution
The other solution is much more concise but hard to see: we will start at the end of `nums` and assert a variable `goal` to indicate that the end of the array to which can reach the end, the initial value is obviously going to be the end of the array (`nums.length - 1`) as if we are at the end, we can reach the end. We could theoretically make the `goal` start at `nums.length - 2` as the goal is always going to be the start but we still have to make `i` start at `nums.length - 1`. For this implementation we will just stick with the initial value of `goal = nums.length - 1` so we can use initial value of `i` to be `goal`. 

The reason why we do all this is because if we can reach the `goal` from the current index `i` then we can move the `goal` to be `i` then we will keep on doing this as `i` is decrementing to `0` (the start of `nums`) and we will return `true` if `goal === 0` as the goal is decreasing in a linear fashion and should end at `0`, if this is not the case then it must be greater then `0` so return `false` as the `goal` isn't reachable from the start of `nums`.

The method to check if we can reach the `goal` from the current index `i` is to use `i + nums[i]` as this is basically going from `0` to `i` and then from `i` to the current value stored at `i` (`nums[i]` ) and we compare this with `goal`, since it could overshoot `goal` we must compare it using `<=`:

```js
var jumpGame = function(nums) {
	let goal = nums.length - 1;
	for(let i = goal; i >= 0; i--) {
		if(i + nums[i] >= goal) {
			goal = i
		}
	}
	
	return goal === 0;
}
```


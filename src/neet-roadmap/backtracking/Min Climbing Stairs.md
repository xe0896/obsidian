You are given an array of integers cost where `cost[i]` is the cost of taking a step from the `it`h floor of a staircase. After paying the cost, you can step to either the `(i + 1)`th floor or the `(i + 2)`th floor.

You may choose to start at the index `0` or the index `1` floor.

Return the minimum cost to reach the top of the staircase, i.e. just past the last index in `cost`.
***
This question requires dynamic programming, and there is a `O(1)` space solution but I cannot be asked, so we will stick to the usual `O(n)` space solution. We can identify that we need dynamic programming since we the branching factor for this problem is only `2` and the base case is just when we reach the end of the array so `index <= nums.length` the reason why `<=` because the question states "past the last in `cost`" so we want to reach after the last index and not the last element. 

Memoization can be used here since we have two different options: go up one floor or two floors. If we started at `0` and want to reach `2`, there are two different ways of doing this:  
   1. `0 -> 1 -> 2`  
   2. `0 -> 2`  
So if we save the minimum cost of going from a stair to the top, we can cache it during the first traversal (`0 -> 1 -> 2`).  Then, for the second path (`0 -> 2`), it wouldn't need to compute the minimum cost again, since we already have it in the cache (`0` is not limited to be the start but `2` is the end).

Given that the question wants the minimum steps then we need to use `Math.min` when we call both the branch `i+1` and `i+2`, the question also states we could start index `0` or `1` so when we call our `helper` function we should take the minimum for both perspectives of `0` and `1`.

The DP equation would be `dp[i] = cost[i] + min(dp[i+1], dp[i+2])` since we start at `cost[i]` and want to see what jump would lead to the better solution in terms of the least cost:

```js
minCostClimbingStairs(cost) {
	const memo = Array(cost.length).fill(undefined);
	return Math.min(this.helper(0, memo, cost), this.helper(1, memo, cost));
}

helper(index, memo, cost) {
	if(index >= cost.length) {
		return 0;
	}
	
	if(memo[index] !== undefined) {
		return memo[index];
	}
	
	const oneJump = this.helper(index + 1, memo, cost);
	const twoJump = this.helper(index + 2, memo, cost);
	
	memo[index] = Math.min(cost[index] + oneJump, cost[index] + twoJump);
	return memo[index];
}
```


You are climbing a staircase. It takes `n` steps to reach the top.

Each time you can either climb `1` or `2` steps. In how many distinct ways can you climb to the top?
***
This problem is definitely one of the more harder "Easy" problems in here as the solution is very thought-out but the solution is very concise and elegant.

The best way to find out what to do is to represent the problem in a particular way, and this is done by representing the problem using a decision tree as if we start with step `0` where we haven't moved at all we have two options from here, we can either go up `1` or `2` steps and we can keep on doing this until we have reached all possibilities:
![[output 2.png]]
The tree above shows us branching to all possibilities and the distinct number of solutions is the amount of times `n` shows up and this case it is `8`, this means we would return `1` as a solution once we reach `5`, if we find `n > 5` which in this case is `6` we would return `0`. 

If we inspect the tree we can see this can get very large for large `n`, we could reduce the computation required if we use Memoization since for example if our reduced `n` was `2` then we can see the sub-tree that `2` causes is large and also is used twice in our example, if we stored the result when we calculate it once then we wouldn't need to go to compute the tree for the second occurrence of `2`, making this much faster.

We could do this by creating an array that acts as a cache where `memo[n]` stores the result `n` and we can always try to see if our given `n` makes `memo[n] != 0`, if this is the case then we can use `memo[n]` rather then going down an already known recursive call. 

Before starting with our Memoization, we must consider what the base case would be in this problem, and since we are accessing `n-1` and `n-2` our base cases must cover both these values so our base case would be using an inequality. If we calculate the problem for small `n` such as `0,1,2` we see that the answer for them are all `n` so our base case would be `return n <= 2` as `n-1` and `n-2` would reach `1` and `2` but not `0` in our case.

Regarding our Memoization we will require two functions, one that is responsible for returning the answer with the help of the other function calculating which would be responsible for checking against our base case, then if it is not `true` then check our cache and if its a miss then we go make the recursive call with this `n`.

```java
public int climbStairs(int n) {
	int[] memo = new int[n+1];
	return helper(n, memo);
}

public int helper(int n, int[] memo) {
	if (n <= 2) {
		return n;
	}

	if (memo[n] != 0) {
		return memo[n];
	}

	memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
	return memo[n];	
}
```
We initialise the cache to go from 0 to `n+1` since `n` is a given integer and is not zero indexed.
### Bottom-up solution
The Memoization solution works well but there is a much more elegant and more thought-out solution since the Memoization is just recognising the recursive Fibonacci sequence and just optimises it.

The bottom-up solution starts from the top (`n`) and goes down until we reach `0` and propagates the distinct ways to climb to the top downwards as for top `n` we say that the distinct amount of steps to get to `n` is `1` since we do nothing, this is just a way to make the recursion flowing and for top `n-1` we say the distinct amount of steps to get to `n` is `1` since we can only do `1` step:

This could get hard to visualise so the diagram would specifically calculate the case for `3` and `4` which should hopefully clear this up:
![[output 3.png]]


This means that we can use these two values to calculate a reduced `n` (top `n-2`) and then keep on doing this until we reach `0`. 

We could store the values in an array but if we want to keep our space complexity low we can just use two variables `first` and `second` where `first` stores `n-1` and second stores `n-2` since that is all we need to calculate the distinct steps required from `0` to `n` so we require a `temp` value to store `first` to assign it to a new value by summing `first` and `second` and `second` will take the old value of `first`:
```java
public int climbStairs(int n) {
	// Prior calculation
	int first = 1;
	int second = 1;
	for(int i = 0; i < n-1; i++) {
		int temp = first;
		first = first + second;
		second = temp;
	}

	return first;
}
```



Given an integer `n`, return _`true` if it is a power of two. Otherwise, return `false`_.

An integer `n` is a power of two, if there exists an integer `x` such that `n == 2^x`.
***
This problem has a very trivial answer which is not to efficient and another answer which is genius and is very efficient, we will look at the trivial one first. We can simply divide our answer by `2` continuously until we reach `1`, if we ever see that our output is not an integer then we can return `false` immediately as a power of two would always be an integer every time you divide by `2` given that we stop at `1`. To see if our number is an integer or not we can use JavaScript's `Number.isInteger` function every time we use a new number from our dividing of `2`.

There is also a case where we are given the number `0` as our initial `n`, and we cannot pass this down our loop so we can create a special case for this instance and return `false` as there is no `x` that satisfies `2^x = 0`:
```js
var isPowerOfTwo = function(n) {
	if(n == 0) { return false }
	while(n != 0) {
		if(Number.isInteger(n)) {
			n = n / 2;
		} else {
			return false;
		}
	}
	return true;
}
```

This is very inefficient so we will explore another solution that can be done with one line. If we look at the binary number `n` for a given `x` that satisfies this problem, then we can see that there is only one instance of `1` of the whole binary number as binary numbers are in powers of two and since we have `n` which is a power of two then we only need one instance of `1` in binary to represent `n`. 

This property can be used to identify if a given `n` is a power of two or not as we can look at `n-1` and represent this as binary and see that we will have something like `0111..`, if we done the AND operation between `n` and `n-1`, if `n` is a power of two then this operation will ALWAYS output `0`, using this information we can make a one-liner for this question:
```js
var isPowerOfTwo = function(n) {
	return (n & (n-1) == 0);
}
```

However, this solution isn't fully correct as there is an instance when this would output an incorrect answer, this is when we receive an input of `0`, meaning we can either make a case where `n == 0` or we can use the same return statement but add an `n > 0` since we can't accept negative numbers anyway since `n` cannot be less then `0` since it will no longer be an integer meaning the `x` value that satisfies `2^x == n` when `x` is negative shouldn't' t be accepted, as well as `0`.
```js
var isPowerOfTwo = function(n) {
	return (n > 0) & (n & (n-1) == 0);
}
```


Given a non-negative integer `x`, return _the square root of_ `x` _rounded down to the nearest integer_. The returned integer should be **non-negative** as well.

You **must not use** any built-in exponent function or operator.

- For example, do not use `pow(x, 0.5)` in c++ or `x ** 0.5` in python.
***
This problem becomes a whole much easier once you realise that we are returning an `int` here, this means that we can just have a counter `i` that is being squared and is being compared with `x` and if it is larger then the `i^2` and it less then `(i+1)*(i+1)` then we can return `i` since the question wants us to round **down** to the nearest integer.

Furthermore, if we go through this whole loop without returning a value then we return `1` since the only value that can go pass this whole for loop is `1` and `sqrt(1) = 1`:
```java
public int mySqrt(int x) {
	for(int i = 0; i <= x; i++) {
		if(x >= i*i; && x < (i+1)*(i+1)) {
			return i;
		}
	}
	return 1;
}
```

A problem arises with this though since `(i+1)*(i+1)` can get really large (as well as `i*i`) so to adjust we can convert these large numbers into `long` by changing the for-loop into `long` and casting our return type back into `int`:
```java
public int mySqrt(int x) {
	for(long i = 0; i <= x; i++) {
		if(x >= i*i && x < (i+1)*(i+1)) {
			return (int) i;
		}
	}
	return 1;
}
```
This solution is really slow however so we must also consider a better solution, a solution with `O(log n)`, and this is using binary search.
### Binary search solution
The binary search solution will have the `L` and `R` pointers to be `1` and `x/2` respectively as `sqrt(x)` is bounded by `x/2` making not need to search from `1` to `x`. The midpoint will be squared and checked against the given `x` to see if it is greater or lower and perform binary search as normal until our squared midpoint is `x`, but this is unlikely as we are more likely be given a non-perfect square `x`. To handle this we will store the last valid midpoint into our `ans` variable which would be returned if we have done a full complete binary search and couldn't find our perfect `sqrt(x)`

The `ans` variable will be updated every time our squared midpoint is smaller then `x` as this will be the last valid midpoint since if `x=28` and we see that `25 < 28 < 36` then we should return `5` which would be returned as `ans` since `25 < 28`. Regarding `36` in this example, we would still consider it since `28 < 36` but `ans` is still `5` as we are not changing `ans` if our squared midpoint is greater then `x` and we have completed our binary search so we return `ans`:
```java
public int mySqrt(int x) {
	int L = 1;
	int R = x/2;
	int ans;
	while(L <= R) {
		int midpoint = (L+R)/2;
		long squaredMin = (long) midpoint * midpoint;

		if(squaredMin == x) {
			return midpoint;
		} else if(squaredMin < x) {
			L = midpoint + 1;
			ans = midpoint;
		} else {
			R = midpoint - 1;
		}
	}
	return ans;
}
```
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
		if(x >= i*i; && x < (i+1)*(i+1)) {
			return (int) i;
		}
	}
	return 1;
}
```
This solution is really slow however so we must also consider a better solution, a solution with `O(log n)`, and this is using binary search.
### Binary search solution

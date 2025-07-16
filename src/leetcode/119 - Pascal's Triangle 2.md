Given an integer `rowIndex`, return the `rowIndexth` (**0-indexed**) row of the **Pascal's triangle**.
***
This question can be easily done in an inefficient way depending on what formula you use to calculate `rowIndex` row, the well known formula is: $\binom{n}{k} = \frac{n!}{k!(n - k)!}$ which when looking at this, it can be seen as intuitive to implement in code which it is but we will see why this formula wouldn't work for all cases:
```java
public List<Integer> getRow(int rowIndex) {
	List<Integer> list = new ArrayList<>();
	long numerator = factorial(rowIndex);
		for(int k = 0; i <= rowIndex; k++) {
			long denominator = factorial(k)*factorial(rowIndex-k);
		list.add((int) (numerator / denominator));
	}
	return list;
}

public long factorial(int n) {
	long result = 1;
	for(int i = 2; i <= n; i++) {
		result*=i;
	}
	return result;
}
```
When we see the values for a moderate value of `rowIndex` like `50`, we will see that we have to calculate `50!` which is much higher then the max value of `int` which is `2^(31)-1` and max value of `long` which is `2^(63)-1` meaning we cannot store this value in the numerator without having some special objects like `BigInteger`. 

We can avoid using `BigInteger` by using a different formula for calculating a binomial row which is: $\binom{n}{k} = \binom{n}{k-1} \times \frac{n-k+1}{k}$ which avoids the use of factorials and allows us to calculate in a much more efficient way.

Since the formula requires us to have knowledge about the previous calculation, we can add the number `1` to the list and start at `k=1` since the first value is always `1` regardless of the value `rowIndex`:
```java
public List<Integer> getRow(int rowIndex) {
	List<Integer> list = new ArrayList<>();
	long value = 1;
	list.add(1);
	  
	for(int i = 1; i <= rowIndex; i++) {
		value = value*(rowIndex-i+1)/i;
		list.add((int) value);
	}
	return list;
}
```

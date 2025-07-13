You are given an array `prices` where `prices[i]` is the price of a given stock on the `ith` day.

You want to maximize your profit by choosing a **single day** to buy one stock and choosing a **different day in the future** to sell that stock.

Return _the maximum profit you can achieve from this transaction_. If you cannot achieve any profit, return `0`.
***
This question requires a particular way of thinking if we want that sweet `O(n)` time complexity. Instead of storing a `max` and `min` and aiming to maximise `max-min` given that the `indexOf(min) < indexOf(max)` we will just be storing `min` and using `prices[i]` as an attempt of a new `max` since we want a `prices[i]` that maximises `prices[i]-min=profit` and store this `profit` to be our `maxProfit`

We need to also consider when we find a new `min` since we do not want to do `prices[i]-min` when we have a new `min` at an index `i` since it would just output `0` and be meaningless so we use an `else` statement to consider `prices[i]-min` only if we haven't find a new `min` by checking to see `prices[i] < min`:
```java
public int maxProfit(int[] prices) {
	int maxProfit = 0;
	int min = Integer.MAX_VALUE;
	for(int i = 0; i < prices.length; i++) {
		if(prices[i] < min) {
			min = prices[i];
		} else {
			int profit = prices[i] - min;
			maxProfit = Math.max(maxProfit, profit);
		}
	}
	return maxProfit;
}
```
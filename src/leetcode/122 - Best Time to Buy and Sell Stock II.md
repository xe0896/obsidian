You are given an integer array `prices` where `prices[i]` is the price of a given stock on the `ith` day.

On each day, you may decide to buy and/or sell the stock. You can only hold **at most one** share of the stock at any time. However, you can buy it then immediately sell it on the **same day**.

Find and return _the **maximum** profit you can achieve_.
***
This question relies on a greedy strategy where we look at adjacent pairs and accumulate profit if `prices[i-1] < prices[i]`, we can consider two cases where we have the prices ascending indefinitely or we have occasional dips in prices, for the prices being ascending indefinitely we can represent this nicely with price  $p_{m}$  where $m$ denotes the day that this price is at, if we had an ascending `prices` array, it would look like:
$$p_0, p_1, p_2, p_3, \ldots, p_k$$
The obvious answer for the maximum profit would be $p_k - p_0$ as we would want to buy at the lowest and sell at the highest, we can use our logic on accumulating profits via `prices[i-1] - prices[i]` given that `prices[i-1] < prices[i]` and represent this in our example array and see if it evaluates to $p_k - p_0$:
$$(p_1 - p_0) + (p_2 - p_1) + (p_3 - p_2) + \ldots (p_k - p_{k-1})$$
We are allowed to do this since $p_0 < p_1 < p_2 < \ldots p_k$ and if we simplify this sum we find out that it is equal to $p_k - p_0$, there does exist another case where we experience dips in prices, since the approach is greedy, it skips over temporary price drops if they don't lead to immediate gains meaning it will always adjust and output the correct profit.
```java
public int maxProfit(int[] prices) {
	int profit = 0;
	for(int i = 1; i < prices.length; i++) {
		if(prices[i-1] < prices[i]) {
			profit += prices[i] - prices[i-1];
		}
	}
	return profit;
}
```

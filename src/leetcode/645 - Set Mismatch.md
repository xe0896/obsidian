You have a set of integers `s`, which originally contains all the numbers from `1` to `n`. Unfortunately, due to some error, one of the numbers in `s` got duplicated to another number in the set, which results in **repetition of one** number and **loss of another** number.

You are given an integer array `nums` representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return _them in the form of an array_.
***
This problem required some thinking but was overall pretty simple once you figured out that we can compare the sum of the given array and the sum of what the array should be, to find our two missing values: the duplicate and the missing value. We can use the formula that finds the sum for `1..n` which is $\frac{n(n+1)}{2}$ to find our missing value since the sum of our given array can be denoted as `actualSum` and can be calculated easily with a for loop by doing something like `actualSum += nums[i]`, and the sum of what the array should be would be calculated using our formula mentioned above can be denoted as `sum`, and the problem states that there is a duplicate value that is replacing our missing value `missing`, meaning our `actualSum` can be broken down in terms of `sum`, `duplicate` and `missing`: `actualSum = sum + duplicate - missing`, this is because the `missing` value is taken away and a duplicate is replacing it meaning we add these to our `actualSum` and the rest of the numbers that are all valid are being represented by `sum`.

The formula that we have constructed requires us to know either `missing` or `duplicate` as `actualSum` and `sum` can be calculated trivially, we can find the `duplicate` value by using a set, which will iterate over our given array and only include values in the set that are not currently in the set, which will easily find our `duplicate` for us, now that we know what our `duplicate` is, we can use this to find our `missing` value: `missing = duplicate -(actualSum - sum)`:
```js
var findErrorNums = function(nums) {
	let newArr = [];
	let sum = (nums.length * (nums.length + 1))/2;
	let actualSum = 0;
	let seen = new Set();
	for(let i = 0; i < nums.length; i++) {
		actualSum += nums[i];
		if(seen.has(nums[i])) {
			newArr.push(nums[i]);
		} else {
			seen.add(nums[i]);
		}
	}
	
	newArr.push(newArr[0] - (actualSum - sum));
	return newArr;
};
```
`newArr[0]` is our `duplicate` value as we pushed it to be the first value of `newArr`.


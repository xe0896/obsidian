You are given a string s consisting of only uppercase english characters and an integer k. You can choose up to k characters of the string and replace them with any other uppercase English character.

After performing at most k replacements, return the length of the longest substring which contains only one distinct character
***
This problem requires some deep understanding on how sliding windows work and is a great problem to learn sliding windows, there are two pretty good solutions for this but one is a bit better as it has a pure `O(n)` space complexity, we will focus on this one.

We should start with an example so we can understand the problem properly, so lets take `AABABB` first, before we start including the sliding window logic we should construct a condition on when to advance our `L` pointer as the `R` pointer would always be going forward but our `L` pointer will need a condition to advance (`R` and `L` are the width of the sliding window). 

Given that we can replace characters in our sliding window `k` times, our condition will require `k` and we need to formula that can show if `k` has been exhausted, we can use the maximum frequency of the character in our current sliding window and do `windowSize - maxFreq` to see if we can use more `k`'s to do more replacements, effectively `windowSize - maxFreq > k`.

In our example `AABABB`, our `R` pointer is going to go forward regardless of what happens so we can leave that aside, and could assign it to something like index `2` and our `L` would remain at index `0`, the reason for this is because our current window is `AAB` and if `k=2` we can look at the maximum character frequency which is `2` due to `A` and do `3-2` which is `1`, this implies that we have replaced `B` with `A` as if the  `windowSize=maxFreq` then it means we have `AAAA..` but since we have a `B` that could be replaced with `A`, we can replace this an `A` using our budget `k` and keep on doing this until we have no more `k` which means `windowSize-maxFreq > k` as our `windowSize` is to high and our budget `k` has been exhausted. 

If `k` has been exhausted then we must move the `L` pointer one up to reduce the window size and also remove whatever character has been removed pointing to our `L` pointer on our frequency map  that is storing the character frequency on our sliding window, like we are with the `R` pointer but with `R` we are increasing the frequency rather than decreasing which is what `L` is doing.

After moving our `L` pointer, we can record the current maximum length replace the maximum length stored so far and store this in `maxLen` and return this as the answer.

Understanding how this work will allow us to emulate this in code pretty easily, the main problem of this is maintaining our frequency map of our sliding window as it is always growing and shrinking, lets first complete the growing of our maximum frequency and leave the shrinking part later:
```js
characterReplacement(s,k) {
	let L = 0;
	let maxFreq = 0;
	let maxLen = 0;
	const myMap = new Map();
	for(let R = 0; R , s.length; R++) {
		const charR = s[R];
		myMap.set(charR, myMap.get(charR || 0) + 1); // || adding  elem
		maxFreq = Math.max(maxFreq, myMap.get(charR));
		const windowSize = R - L + 1;
		// Shrinking logic
		maxLen = Math.max(maxLen, windowSize);
	}
	return maxLen;
}
```

We are simply just adding to our frequency map in here and after we shrink we must collect this current `windowSize` and see if it is the greatest we have seen so we can return this later on once we have considered the whole string.

As mentioned before, we would shrink the sliding window once `windowSize - maxFreq > k` and once we find this is true we will simply grab the value pointed by `L` and decrement this in our frequency map as it is no longer in our window then we will decrement `L`, leading to the following answer:
```js
characterReplacement(s,k) {
	let L = 0;
	let maxFreq = 0;
	let maxLen = 0;
	const myMap = new Map();
	for(let R = 0; R , s.length; R++) {
		const charR = s[R];
		myMap.set(charR, myMap.get(charR || 0) + 1); // || adding  elem
		maxFreq = Math.max(maxFreq, myMap.get(charR));
		const windowSize = R - L + 1;
		if(windowSize - maxFreq > k) {
			const charL = s[L]
			myMap.get(charL, myMap.set(charL) - 1);
			L++;
		}
		maxLen = Math.max(maxLen, windowSize);
	}
	return maxLen;
}
```
The thing that separates the `O(26n)` solution and the `O(n)` solution is this line here: `maxFreq = Math.max(maxFreq, myMap.get(charR))`, we do not need to scan the whole frequency map to get the maximum frequency of our sliding window as we can rely on the `R` to be a potential new `maxFreq` as it could be the same character as last time so just `maxFreq + 1` or could be a new character which would stick with `maxFreq` which could be violating our condition `windowSize - maxFreq > k`at first but the if-statement that is enforcing that condition adjusts the `windowSize` to adjust the `maxLen`. 


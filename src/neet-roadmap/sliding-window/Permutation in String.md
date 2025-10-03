You are given two strings s1 and s2.

Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a substring of s2, then return true.

Both strings only contain lowercase letters
***
This problem has two main solutions, one which require a look up of the character frequency map each substring we attempt and another solution which cleverly uses a variable called `matches` which can be used to determine if our current window is classified as a valid answer by only maintaining two frequency maps.

The two frequency map will storing the same information for different strings `s1` and `s2`, our `s1` map will stay static and not change since that is what we are checking against with, and our `s2` map will be dynamic and changing depending on our current window and the frequency with the `s1` map.

Instead of using an actual `Map` in JS, we can use an array that is filled with `0`'s initially that is of`26` length and then create the initial window which is always fixed length as the permutation is equal to `s1.length`:
```js
checkInclusion(s1, s2) {
	const s1count = new Array(26).fill(0);
	const s2count = new Array(26).fill(0);
	let matches = 0;
	for(let i = 0; i < s1.length; i++) {
		s1count[s1.charCodeAt(i) - 97]++;
		s2count[s2.charCodeAt(i) - 97]++;
	}
}
```

We start from `0` to `s1.length` meaning the array `s1count` would capture the entire `s1` string so we can use it for comparisons and `s2count` would have length `s1count` meaning the length of our window. `s.charCode(i) - 97` is used because we will be iterating over the string `s2` which returns a character and we want a character to be associated to be with its alphabet number `0-25` allowing it to be like a key value pair in a `Map`. 

We now need to compute the initial `matches` value as we have just constructed a window that can be tested with and must be treated differently, and the reason why will be more obvious later.
```js
let matches = 0;
for(let i = 0; i < 26; i++) {
	if(s1count[i] === s2count[i]) {
		matches++;
	}
}
```

The reason for this is because if we have different frequencies then it won't be considered a match and if we see an occurrence of a character in `s2` that isn't in `s1` then it would also not be considered a match, everything else would be considered a match meaning our array filled with `0`'s will be considered a match. The goal here is to make the two arrays equal. 

Now we must construct the main loop which will follow this logic: we will have a static length sliding window which will be having a pointer `R` and `L` which `R` will point to the end and `L` would point to the start, we will make `R` exclusive instead of inclusive on the sliding window since we want to grow `R+1` if it was inclusive so we might as well make it exclusive. We will look at the character at `R` and include it in our array:
```js
for(let R = s1.length; R < s2.length; R++) {
	if(matches === 26) {
		return true; // Arrays are equal
	}
	let index = s2.charCodeAt(R) - 97;
	s2count[index]++;
}
```

We can now check to see if this has changed our `matches` variable, if we see that `s1count[index] = s2count[index]` we are getting closer on making the array equal so we increase `matches`, but this may make the frequency of this character off by `1` meaning we have lost a match, we can encapsulate this case by doing `s2count[index] - 1 === s1count[index]` leading to:
```js
if(s2count[index] === s1count[index]) {
	matches++;
} else if (s2count[index] - 1 === s1count[index]) {
	matches--;
}
```

Since we are moving the sliding window to the right by `1`, we must also do the same for the left. The logic is the same but instead of the pointer `R` we look at pointer `L` and since we are losing a character, we must check if the presence of this character was enforcing `s2count[index] === s1count[index]` so we can check this condition by doing `s2count[index] + 1 === s1count[index]`.

The reason why we need to make a separate else-if statement for `matches--` and not just `else { matches-- }` is because we would be aggressively decrementing `matches` whenever we do not have a match instead of decrementing `matches` when we have just lost a match.
```js
index = s2.charCodeAt(L) - 97;
if(s2count[index] === s1count[index]) {
	matches++;
} else if (s2count[index] + 1 === s1count[index]) {
	matches--;
}
L++; // Not automatic like R
```

Our final return statement would be `return matches === 26` as that is what our goal is, to make our arrays equal as a permutation of a string has the same character frequency as all other permutations, which is including `s1`.

Leading to the following solution:
```js
checkInclusion(s1, s2) {
	const s1count = new Array(26).fill(0);
	const s2count = new Array(26).fill(0);
	
	for(let i = 0; i < s1.length; i++) {
		s1count[s1.charCodeAt(i) - 97]++;
		s2count[s2.charCodeAt(i) - 97]++;
	}
	let matches = 0;
	for(let i = 0; i < 26; i++) {
		if(s1count[i] === s2count[i]) {
			matches++;
		}
	}
	let L = 0;
	for(let R = s1.length; R < s2.length; R++) {
		if(matches === 26) {
			return true;
		}
		let index = s2.charCodeAt(R) - 97;
		s2count[index]++;
		
		if (s1count[index] === s2count[index]) {
			matches++;
		} else if (s2count[index] - 1 === s1count[index]) {
			matches--;
		}
		index = s2.charCodeAt(L) - 97;
		s2count[index]--;
		
		if(s1count[index] === s2count[index]) {
			matches++;
		} else if (s2count[index] + 1 === s1count[index]) {
			matches--;
		}
		L++;
	}
	return matches === 26;
}
```




``
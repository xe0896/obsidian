Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
***
This question is pretty tricky to do in your head, we will focus on an iterative solution instead of a well known recursive solution. Before we start we should make a `lookup` table that will map a digit to its possible letters:

```js
var letterCombinations = function(digits) {
	const lookup = {
		2: "abc",
		3: "def",
		4: "ghi",
		5: "jkl",
		6: "mno",
		7: "pqrs",
		8: "tuv",
		9: "wxyz",
	};
}
```

The logic will work like this: our result array `arr` will initially start to store an empty string, we then will iterate it over and append the strings depending on our `lookup` table from a given digit. An example of this will make it more clear, given that `digits=23` we will populate a temporary array `temp`  with `["a", "b", "c"`] then we will copy this to our result array `arr` and then iterate over our result array `arr` again but with another empty `temp` array that will use the values we have in `arr` to append more characters.

This is probably not really clear but a full example should help: `digits=234` will mean our `temp` array will start off with `["a", "b", "c"]` which then is copied to our `arr` and now remember that `arr=["a", "b", "c"]`. The next digit is `3` which maps to `def` so now with our **empty** `temp` array we will use the `arr` array and iterate it by appending the values of `def` which then makes `temp=["ad", "ae", "af", "bd"...]` and now we copy this to `arr` and start over but now with `ghi` in mind. We keep on doing this until we finish our digits:

```js
var letterCombinations = function(digits) {
   const lookup = {
	   	2: "abc",
	   	3: "def",
	   	4: "ghi",
	   	5: "jkl",
	   	6: "mno",
	   	7: "pqrs",
	   	8: "tuv",
	   	9: "wxyz",
   };
   
   const iter = digits.toString();
   let arr = [''];
   
   for(let c = 0; c < iter.length; c++) {
	   const letters = lookup[Number(iter[c])];
	   const temp = [];
	   for(let i = 0; i < arr.length; i++) {
		   for(j = 0; j < letters.length; j++) {
			   temp.push(arr[i] + letters[j]);
		   }
	   }
	   arr = temp;
   }
   return arr;
}
```



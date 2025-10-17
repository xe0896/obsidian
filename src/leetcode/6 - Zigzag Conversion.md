The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
<img alt ="center" src = "Pasted image 20250327220727.png">
And then read line by line: `"PAHNAPLSIIGYIR"`

Write the code that will take a string and make this conversion given a number of rows:

```java
string convert(string s, int numRows);
```
***
This problem is pretty hard to figure out but is concise and easy to understand. Looking at this problem and processing the zigzag in our brains, we will go down then up down then up and repeat until the characters end, we can use this to see that if we maintain `numRows` arrays then we can store the character for that row as we go down and up down and up. 

For example: if we had the example `"PAYPALISHIRING"` with `numRows=3` then we can see that the first row has `P` and the next row has `A` and then the next row has `Y`, we want to construct rows as once we have fully populated our arrays then we can concatenate them and output them. 

Another problem arises regarding when to go down and up, if we maintain a variable `current` which will dictate what row we are working with, then we can manipulate it depending on some conditions, but let us consider that later. We can make a variable `down` which will be used as we need to know when we are going up or down as that will change our direction.

```js
var convert = function(s, numRows) {
	const rows = new Array(numRows).fill("");
	let down = false;
	let current = 0;
}
```

The reason why we make `down=false` initially even though we are going down first is because in our loop we will instantly do `rows[current] += s[0]` for `i=0` meaning it doesn't matter and when we flip our `down` variable it will become `true` which means we are currently going down which makes sense for the first part of the zigzag.

There are two conditions that will make us flip `down`, when `current == 0` or `current == numsRows - 1`:

```js
for(let i = 0; i < s.length; i++) {
	rows[current] += s[i];
	if(current == 0 || current == numRows - 1) [
		down = !down;
	]
}
```

The only thing left to do now is to adjust our `current` to increment when we go down and to decrement when we go back up, this will emulate the zigzag logic:

```js
if(down) {
	current++;
} else {
	current--;
}
```

After we have our completed `rows` array, all we need to do is concatenate the arrays starting from `0` to `numRows - 1`:

```js
let ans = "";
for(let i = 0; i < numRows; i++) {
	ans += rows[i];	
}
```

Combining all this leads to the following answer (there is an edge case of `numRows==0`):

```js
var convert = function(s, numRows) {
	if(numRows == 0) {return s}
	const rows = new Array(numRows).fill("");
	let down = false;
	let current = 0;
	
	for(let i = 0; i < s.length; i++) {
		rows[current] += s[i];
		if(current == 0 || current == numRows - 1) {
			down = !down;
		}
		if(down) {
			current++;
		} else {
			current--;
		}
	}
	let ans = "";
	for(let i = 0; i < numRows; i++) {
		ans += rows[i];
	}
	
	return ans;
	
}
```




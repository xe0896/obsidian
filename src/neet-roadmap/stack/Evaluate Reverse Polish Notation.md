You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.

Return the integer that represents the evaluation of the expression.

The operands may be integers or the results of other operations.
The operators include `+`, `-`, `*`, and `/`.
Assume that division between integers always truncates toward zero.
***
This problem is pretty straight forward if you truly understand Reverse Polish Notation, so lets go over this: Reverse Polish Notation (RPN) will have the operators follow their operands, meaning `((1+2)*3) - 4` in RPN would be `[1,2,+,3,*,4,-`] and we can evaluate this expression using a stack.

When we iterate over the given string, if we encounter a number we must know whether or not it is a number (which we will go over soon) so we can define a function that takes in a parameter `token` which will return `true` if it is a number, we can use the usual trick of `!isNaN(Number(token))` as converting anything else to a number using `Number` would return `NaN` if it wasn't a number and since we want this function to return `true` if this is a number, we will include the `!` to negate the boolean:
```js
isNumber(token) {
	return !isNaN(Number(token));
}
```
The reason why this works for our problem is because we are told the `tokens` string will only contain numbers or operators and not any empty strings as they are also considered as `0`, there also some more edges cases as well.

Encountered numbers will be pushed onto the stack and will repeatedly done so until we reach some operators:
```js
evalRPN(tokens) {
	const stack = [];
	for(let i = 0; i < tokens.length; i++) {
		const token = tokens[i];
		if(this.isNumber(token)) {
			stack.push(Number(token)); // token is a string
		} else {
			...
		}
	}
}
```

Before we start with our logic on the operator side of this, we need to a way to map a given character that is an operator to its operation, we can do this using an object map that will take in two parameters `a,b` and return the result depending on the operation given to the map. 

```js
const operators = {
	"*": (a,b) => a * b,
	"+": (a,b) => a + b,
	"-": (a,b) => a - b,
}
```

Notice how we left out `/` as there is a subtle rule given in the problem description, "Assume that division between integers always truncates toward zero", this means that if we had `7/2` which is `3.5` it should truncate towards zero so we round down to `0` so the common mistake is to do `Math.floor(7/2)` but what if the given numbers where negative, we would get `Math.floor(-7/2) = -4` which is not truncating toward zero but instead to negative infinity. The way to handle this is to check if `a / b > 0`, if this is the case then we can use `Math.floor(a/b)` but if `a / b <= 0` then we need to do `Math.ceil(a/b)` which makes it align with the rule.
```js
const operators = {
	...
	"/": (a,b) => (a / b > 0 ? Math.floor(a/b) : Math.ceil(a/b))
}
```

The way we can call this is to do something like `operators["/'](-7,2)`, good to clarify this as it is a bit of a weird syntax. 

Now, lets begin with the logic with the operators, the main insight here is that we only need to pop two values from the stack and use the operation using these two values and push them back into the stack, as RPN does not allow something like `1 2 3 +` and will require something like `1 2 3 + +` as it would first do `3 + 2` then use the `+` to get `5` then push this value back into the stack to get `5 + 1` to get the result `6`. 

Then given that we are given a valid RPN sequence then the answer should be stored in `stack[0]`, leading to the following answer:
```js
isNumber(token) {
	return (!isNaN(Number(token)));
}

evalRPN(tokens) {
	const stack = [];
	const operators = {
		"*": (a,b) => a * b,
		"+": (a,b) => a + b,
		"-": (a,b) => a - b,
		"/": (a,b) => (a / b > 0) ? Math.floor(a/b) : Math.ceil(a/b),
	}
	
	for(let i = 0; i < tokens.length; i++) {
		const token = tokens[i];
		if(isNumber(token)) {
			stack.push(Number(token));
		} else {
			const token1 = stack.pop();
			const token2 = stack.pop();
			const value = operators[token](token2, token1);
			stack.push(value);
		}
	}
	
	return stack[0];
}
```

Note that we do `operators[token](token2, token1)` as if we look at a small example `[1, 2, /`] then this evaluates to `1/2` and since `2` is at the top of the stack then we can assign this as `token1` and `1` as `token2` and to do `1/2` we would need to do `token2/token1`, this would work for `-` as well.





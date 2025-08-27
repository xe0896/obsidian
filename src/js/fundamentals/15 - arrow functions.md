Arrow functions are a concise way of creating functions that is often better then function expressions:
```javascript
let func = (arg1, arg2, arg3, .., argN) => expression;
let funcNoParam = () => expression;
```
This is the same thing as saying, its just a different syntax if we can't be asked writing extra lines for the same functionality:
```javascript
let func = function(arg1, arg2, arg3, .., argN) {
	return expression;
};
```
We can dynamically create an arrow function depending on a pre-condition:
```javascript
let age = prompt("What is your age", 18);
let welcome = (age > 18) ? () => alert("Hello!") : () => alert("Greetings!");
welcome();
```
### Multi-line arrow functions
Instead of the previous examples where we just have `return expression`, we can extend this using curly braces and add extra lines for additional computation:
```javascript
let func = (arg1, arg2, arg3, .., argN) => {
	let result = a + b;
	return result;
};
alert(sum(1,2)) // 3
```

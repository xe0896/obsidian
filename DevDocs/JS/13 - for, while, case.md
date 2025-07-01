`while` loops are basically identical to how other `while` loops work in other programming language.

`for` loops are very similar to the loops in `Java`, but it is more flexible on what could be omitted in the loop, a standard `for` loop could look like:
```javascript
for (let i = 0; i < 3; i++) {
	alert(i);
}
```
We could omit the initialisation of `i`, the condition tied to the loop and also the increment of `i`, or emit everything:
```javascript
let i = 0;
for(; i < 3; i++) {
	alert(i);
}
```

```javascript
let i = 0;
for(; i < 3;) {
	alert(i++);
}
```

```javascript
for (;;) {
	// Infinite loop, semi-colons required or else a syntax error arises
}
```
`case` statements use strict equalities when evaluating cases, this means that if we was prompting the user with a value and store this in a `String` then we must use a `String` when we evaluate cases.
```javascript
let msg = prompt("Enter a value");
switch(msg) {
	case '0':
	case '1':
		alert("0 or 1");
		break;
	case '2':
		alert("2");
		break;
	case 3:
		alert("Never executes");
		break;
}
```
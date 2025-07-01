Creating a JavaScript function looks like:
```javascript
function msg() {
	alert("Hello");
}
```
Allowing parameters and adhering to standard local and global variables, if we have multiple parameters and we do not pass them all in the function then by default the values will be `undefined`, if we wanted to change the default value from `undefined` to something else then we do the following:
```javascript
function msg(person, msg = "Empty text") {
	alert(person + ": " + msg);
}
msg("Bob"); // outputs: Bob: Empty text
msg("Bob", undefined); // outputs: Bob: Empty text
```
We could replace the hard-coded string value `Empty text` with a function that gets called whenever the parameter is not given or is `undefined`.

When a function doesn't return any value, if we try to call it and read/assign it to a value then it will return `undefined`.

In JavaScript, functions are still a value meaning it can be handled like a value:
```javascript
function saySup() {
	alert("Sup");
}
alert(saySup); // returns source code of saySup()
```
As it is a value we can also copy functions and make it have another type of way to reference a function:
```javascript
function saySup() {
	alert("Sup");
}

let func = saySup();
func(); // Sup
saySup(); // Sup
```
### Callback functions
Callback functions are just functions that are passed as parameters to a main function and then called by adding parenthesis after the parameter in the function body.
```javascript
function ask(question, yes, no) {
	if(x) {
		yes();
	} else {
		no();
	}
}

function showOk() {
	alert("Agreed");
}

function showCancel() {
	alert{"Cancelled");
}

ask("Do you agree or cancel", showOk, showCancel);
```
### Function expressions
Function expressions allows us to create a new function in the middle of any expression:
```javascript
let hello = function() {
	alert("Hello");
};
```
We are allowed to omit the name of the function, but we can add names if we wanted to. Function expressions are not hoisted like normal function declarations meaning we cannot call function expressions before it has been made but with functions that have been declared, we can call them before the declaration and function expressions can be changed dynamically.

Other then that function expressions and function declaration are very similar, just depends if something is dynamic and we want to change the functionality and whether or not we want to pollute the global scope.





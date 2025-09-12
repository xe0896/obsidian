Constructors are basically the same in Java for JavaScript:
```javascript
function User(name) {
	this.name = name;
	this.isAdmin = false;
}

let user = new User("Jack");
alert(user.name); // Jack
```
The constructor is implicitly doing the following when we execute a function with "new":
1. An empty object is created and assigned with `this`
2. The function is executed and assigns `this` with some properties
3. `this` is returned
In the other words the following is happening:
```javascript
function User(name) {
	this = {}
	// Assign this with some properties
	return this;
}
```
If we wanted to create an object that can use local variables and exhibit more complex logic in context with the current program then we can do the following:
```javascript
let user = new function() {
	this.name = "John";
	this.isAdmin = false;

	// local variables and stuff can come here
}
```
This is different then using object literals since we can use local variables where object literals cannot, but this only creates a single object as this object is anonymous.
### new.target
This syntax is rarely used but mostly used in libraries to make it easier to create objects, if we have a constructor function then it could be called without `new` and we can detect this be checking if `new.target` is `true`, if it is `true` then it has been made with `new`. This is useful for libraries since people may forget to include `new` and this is a problem if they don't use `new` since it won't correctly allow `this` to be used which is likely to be used in the object a lot.
### Return with constructor
Constructor methods will normally return `this` but we could add a `return` statement but it will fall into two scenarios:
- The value being returned is a primitive, will be ignored and return `this` instead
- The value being returned is an object, will be returned instead of `this`
```javascript
function user() {
	this.name = "John"
	return { name: "King Kong" };
}
alert(new user().name); // Godzilla
```
If it returned a primitive:
```javascript
function user() {
	this.name = "John"
	return; // returns this
}
alert(new user().name); // John
```
### Methods in constructor
We can add methods inside an object but it must be a function expression and not a function declaration:
```javascript
function User(name) {
	this.name = name;
	this.sayHi = function() {
		alert( "My name is: " + this.name );
	};
}
let john = new User("John");
```
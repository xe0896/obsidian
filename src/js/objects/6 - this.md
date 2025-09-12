When we are making our object it may need to access some data tied to itself, so we can use the `this` keyword to reference itself. This is useful since if we was to access it using `user.name` rather then `this.name` this is assuming that the object will be named `user` during run-time, it may change to `admin` so using `this` will cover all bases:
```javascript
let user = {
	name: "John",
	age: 30,
	sayHi() {
		alert(this.name);
	}
}

user.sayHi(); // John
```
`this` keyword is not limited to be inside an object declaration, it can be in a normal function but then this normal function should be copied into the object so that the object then can use it and act like it was declared in its declaration:
```javascript
let a  = {value: "x"}
let b = {value: "y"}

function sayHi() {
	alert(this.value);
}

a.f = sayHi;
b.f = sayHi;

a.f(); // x
b.f(); // y
b['f'](); // y
```
This is using the `obj.f` to assign it to the object scope and then calling it using parenthesis, if we was to call this function without having it within the scope of another object then it would return `undefined` in strict mode.
### Arrow functions working with this
Arrow functions do not have their "own" `this`, if we do reference `this` then it is taken from the outer function that is calling the arrow function. 
```javascript
let user = {
	firstName: "Ilya",
	sayHi() {
		let arrow = () => alert(this.firstName);
		arrow();
	}
};
user.sayHi(); // Ilya

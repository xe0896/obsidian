We can make objects perform actions by adding functions, we can make a `user` object output "Hello":
```javascript
let user = {
	name: "Bob",
	age: 30,
}
user.sayHi = function() {
	alert("Hello");
};

user.sayHi(); // Hello
```
This is a function expression assigned to specifically the `user` object, but we could just make a function declaration and then assign this to be accessed by the `user`.
```javascript
let user = {}

function sayHi() {
	alert("Hello");
}
user.sayHi = sayHi;
user.sayHi();
```
There is a short-hand way of making methods that could appear, they are not exactly identical as there are some subtle differences regarding inheritence:
```javascript
user = {
	sayHi: function() {
		alert("Hello");
	}
};

user = {
	sayHi() {
		alert("Hello");
	}
};
```

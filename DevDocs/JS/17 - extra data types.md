There are 7 primitive types:
- `String`
- `Number`
- `bigint`
- `boolean`
- `symbol`
- `null`
- `undefined`
Objects can store functions as properties allowing us to apply operations to the object:
```javascript
let john = {
	name: "John",
	sayHi: function() {
		alert("Hi buddy!");
	}
};
john.sayHi(); // Hi buddy! 
```
JavaScript allows us to work with primitive types like `String` and `Number` like they are objects, they also provide us methods that we can use by temporarily using an object wrapper then when the method is finished then it is destroyed.
```javascript
let str = "hi";
alert(str.toUpperCase()); // HI
```

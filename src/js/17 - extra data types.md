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
### Object wrappers
JavaScript provides object wrappers to primitives such as `new Number(0)` but is not really used since primitives are automatically converted into objects when using methods on primitives such as `toString()`, they are actually avoided since they can cause unpredictable behaviour. Namely the fact that the comparison of the value of a primitive using an object wrapper and a primitive differ:
```javascript
let a = 0;
let b = new Number(0);
alert(a == b); // true, due to type coercion
alert(a === b); // false, due to number vs object
```

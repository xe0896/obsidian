Objects are different then primitives when referencing as if we have a variable storing a primitive that is being copied by another variable then it creates a separate variable and one changing doesn't affect the other variable, with objects they will change as it won't create independent references.
### Comparison by reference
If we have two objects that are the same type, independent but storing the same data then doing:
```javascript
let a = {};
let b = {};
alert(a == b);
alert(a === b);
```
Will all return `false` as they are independent objects, if we make `b` copy `a` then we encounter different behaviour:
```javascript
let a = {};
let b = a;
alert(a == b);
alert(a === b);
```
Will all return `true`.
### Const objects
When initialising `const` objects we can just replace `let` with `const` similar to variables:
```javascript
const user = {
	name: "Bob",
}
user.name = "Bobby";
alert(user.name); // Bobby
```
We can still change the `value` of a property but we cannot modify the properties during run-time if it is declared with `const`.
### Cloning and merging objects
If we wanted to copy an object contents then we could just use a for-in loop:
```javascript
let user = {
	name: "Ben",
	age: "30",
	occupation: "Unemployed",
}
let clone = {};
for (let key in user) {
	clone[key] = user[key]; 
}
alert(clone.name); // Ben
```
But this is a bit cumbersome since this task is likely to be a common thing, so we can use a function designed for this: `Object.assign(dest, .. sources)` where `dest` is the reference where we want to store our `source` where it could be a property or a whole object
```javascript
let clone = Object.assign({}, user);
alert(clone.name); // Ben
alert(clone.age); // 30
Object.assign(clone, {name: "Jack"});
alert(clone.name); // Jack
```
### Nested cloning
So far we have just been accessing primitives inside and object but we can access objects inside an object which can store a primitive or carry on until we get a primitive:
```javascript
let user = {
	name: "Bob",
	sizes: {
		height: 180,
		weight: 1034,
	}
}
alert(user.sizes.height); // 180
```
But if we wanted to clone this then we cannot use simple `Object.assign()` if we wanted a full clone since the `sizes` object would be copied by reference and not value so changing `user.sizes.height` for example would change the value for all copies which is not what we want.
To make a fully independent `user` clone, we call the `structuredClone(object)` which will clone `object` with all its nested properties. 
```javascript
let clone = structuredClone(user);
alert(user.sizes === clone.sizes); // false, a fully different clone
```
This also supports circular references:
```javascript
let user = {};
user.me = user;
let clone = structuredClone(user);
alert(clone === clone.me) // true
```
The clone is referencing itself rather then the `user` object so the clone is fully independent.
However, there are times when cloning fails, for example when we want to clone an object that has a function property:
```javascript
structuredClone({
	f: function() {}
});
```
There is another special library from `lodash` where we can use `_.clonedeep(obj)` for this.
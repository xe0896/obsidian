 An object can be created using the `Object()` constructor or using figure brackets `{..}`, where they store an optional list of properties where each property is a `(key, value)` pair where `key` is a string also known as "property name" and `value` can be anything:
```javascript
/// Creating an empty object, two ways
let user = new Object();
let user = {}; // The norm
```
We can add some properties belonging to `user`:
```javascript
let user = {
	name: "Bob",
	occupation: "Sales"
};
```
In this case `name` is our `key` and `Bob` is our value, accessing these values are similar to how Java accesses its attributes:
```javascript
alert(user.name); // Outputs Bob
alert(user.occupation); // Outputs Sales
```
One powerful thing that JavaScript objects can do is that it can add properties or even functions during run-time, to do this we just simply assume the `key` exists and assign it to a `value`:
```javascript
user.isMale = true;
alert(user.isMale) // Outputs true, this wasn't in our object definition but it exists now
```
Removing a property that an object has requires us to use the `delete` operator:
```javascript
delete user.occupation;
```
The object definition can be altered a bit to aid us with managing our properties by removing the semi-colon at the end and making all `(key, value)` pairs end with commas rather then just the last one having no commas.
```javascript
let user = {
	name: "Bob",
	occupation: "Sales",
}
```
### Square brackets
If we wanted our `key` to be more then one word then we can use quotation marks:
```javascript
let user = {
	name: "Bob",
	occupation: "Sales",
	"is male": true
};
```
However, a problem arises if we use multi worded `key` since if we want to access that property then we cannot do `user.is male` so instead we use `user["is male"]` for accessing and also setting. We can also assign a variable like `let key = "is male"` and then do `user[key]`, its the same thing.

Using brackets to access our `value` can be helpful if we asked for a prompt that asks the user what they want to know about a specific person and store that into a variable and use the bracket notation to access that information from the object:
```javascript
let key = prompt("What do you want to know about this user? name, occupation, is male?");
alert(user[key]);
```
This type of logic won't work with dot notation as we are accessing the key directly rather then having a dynamic input.
### Computed properties
When defining the object properties, we can put the `key` in square brackets to allow it to change:
```javascript
let fruit = prompt("What fruit to buy?");
let bag = {
	[fruit]: 5,
}
alert(bag.apple) 
```
If the user didn't input `apple` then it would output `undefined`, we could do `bag[fruit]` to get whatever is being stored regardless of the user input so it poses the question, "What is the point of this?" and the real reason is just to make it easier to read and what to expect when we are scanning our code.

When using square brackets we can concatenate strings with the `key`:
```javascript
let bag = {
	[fruit + "Computers"] : 5
}
alert(bag.appleComputers); // 5
```
### Property existence
A special property of objects that was kind of outlined before is that accessing a non-existent property won't break the program but just return `undefined`:
```javascript
let user = {};
alert(user.blabla === undefined); // returns true if doesn't exist
```
There is a shorter way to do this, we can use the `in` operator:
```javascript
// "key" in object
alert("blabla" in user); // returns true
```
The left hand side should normally be a `String` but could also be a variable but the variable must be storing the `String`, another thing to note with this operator is that if the `value` was `undefined` then the `in` operator would always return `false` as it is just checking to see if accessing that property returns `undefined`. This means that we should use another data-type if nothing has been assigned to a `key` and this value is normally `null`.
### for-in loop
If we wanted to iterate over all keys in an object then we can use the for-in loop, given that we can iterate over the keys then we can also iterate over the values using our square bracket referencing or dot notation:
```javascript
for(let key in user) {
	alert(key); // Outputs key
	alert(user[key]); // Outputs value
}
```
Regarding ordering when iterating over an object's properties depends whether if the `key` is a `String` or `Number`, if its a `String` then it will order depending on the creation of the value in the object definition but if it is a `Number` then it will order on ascending order, if we didn't want this ascending order and want to order based on creation then we must turn numbers like `44` into `+44`:
```javascript
let codes = {
	"+49": "Germany",
	"+41": "Switzerland",
	"+44": "Great Britain",
	// ..,
	"+1": "USA"
};
for (let code in codes) {
	alert( +code ); // 49, 41, 44, 1
}
```
We are using `+code` since it will remove the `+49` and convert this into `49` when we alert this.
### Object referencing
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
### Methods in Objects
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
### this
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
```
### Constructor
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
### Non-existent property problem
If we have an object then we must consider if a property exists since if we access a property that is not defined then it will output `undefined` and accessing a property of `undefined` will output an error.  This may not seem too important but we want to reduce our `undefined` outputs since we do not know the full context if we are trying to debug since we just have an `undefined` output to workout with which can propagate to more unpredictable behaviour or we do not know where this output is really coming from.

There are some obvious solutions to solve this problem by doing statements like:
```javascript
let user = {};
alert(user.address ? user.address.street ? user.address.street.name ? : null : null);
alert(user.address && user.address.street && && user.address.street.name);
```
But these statements are repeatedly referencing `user.address` and there is no way to make this not happen if we want to check if it will be `undefined`, so we can use optional chaining
### Optional chaining
The optional chaining `?.` stops the evaluation if the value before `?.` is `undefined` or `null` and returns `undefined`:
```javascript
let user = {};
alert(user?.address?.street); // undefined instead of an error
```
This works for functions and `[]` brackets with the same logic:
```javascript
// Functions:
let userAdmin = {
	admin() {
		alert("I am admin");
	}
};
let userGuest = {};
userAdmin.admin?.(); // I am admin
userGuest.admin?.(); // nothing happens (no such method)

// [] bracketsL
let key = "firstName";
let user1 = {
	firstName: "John"
};
let user2 = null;
alert( user1?.[key] ); // John
alert( user2?.[key] ); // undefined
```
The optional chaining `?.` syntax has three forms:
1. `obj?.prop` – returns `obj.prop` if `obj` exists, otherwise `undefined`.
2. `obj?.[prop]` – returns `obj[prop]` if `obj` exists, otherwise `undefined`.
3. `obj.method?.()` – calls `obj.method()` if `obj.method` exists, otherwise returns `undefined`.
### Symbol
Our properties are `(key,value)` pairs and `key` is normally a `String` and if it was a `Number` or `boolean` then it is converted into a `String`, but we could also have another type of `key` which is known as `Symbol`.  This will always output a unique value and can be used for identification and prevent `key` collisions in objects.

We can create a `Symbol` by using the `Symbol(x)` function where `x` is the `Symbol` description and is mostly used for debugging purposes and doesn't affect the uniqueness, but this is optional:
```javascript
let id1 = Symbol("id");
let id2 = Symbol("id");
alert(id1 == id2); // false
```
We cannot do stuff like `alert(id1)` as we will get an error, but we can use the `toString()` function to get an output which would be `Symbol()` if we done `alert(id.toString())`.
### Hidden properties
We can hide properties using `Symbol` and when we say hide it could be about finding it by iterating over the object by using a for-in loop:
```javascript
let user = {
	name: "John",
}
let id = Symbol("id");
user[id] = 1;
alert(user[id]) // 1
```
We are hiding `id` in this case as if we was to iterate over `user` then we wouldn't be able to find `id`, and this may seem a bit worthless since we could just use a `String` id rather then use a `Symbol` but since `Symbol` is always unique then no collisions will occur, for example:
```javascript
let user = {
	name: "John",
}
user.id = "old id";
user.id = "new id";
// Changes
```
If we used `Symbol` instead then we can make the `id` not create multiple `id1`, `id2`, etc but instead use multiple `Symbol` and not pollute the object property list:
```javascript
let user = {
	name: "John",
}

let id = Symbol("id");
let id1 = Symbol("id");
user[id] = "id";
user[id1] = "id1";
```
### Symbols in object literals
If we want to use a symbol in an object literal then we must encase it with an `[]`:
```javascript
let id = Symbol("id");
let user = {
	name: "Jack",
	[id]: 12,
}
```
We do this since we want the value from the variable `id` and not the string "id"
### Symbols being skipped in for-in
If we iterate over an object that has a `Symbol` in its definition then the `Symbol` will be skipped, it can only be directly accessed:
```javascript
let id = Symbol("id");
let user = {
	name: "John",
	age: 30,
	[id]: 123
};
for (let key in user) alert(key); // name, age (no symbols)
// the direct access by the symbol works

alert( "Direct: " + user[id] ); // Direct: 123
```
`Object.keys(user)` will also ignore the `Symbol`, `Object.assign` will copy the `Symbol` but will still act normal, in terms of ensuring its hidden.
### Global symbols
We can create global symbols by using a `.for` function, this will make a `Symbol` have the same value mapped to the given `key` in `Symbol(key)`. If the given `key` is not in the global registry then it will create one:
```javascript
let id = Symbol.for("id");
let id1 = Symbol.for("id");
alert(id === id1); // true
```
We can use the `Symbol.keyFor` to find out the `id` for this global key, this will only work if the `Symbol` is global:
```javascript
let id = Symbol.for("id");
let id1 = Symbol.for("name");
alert(Symbol.keyFor(id)); // "id"
alert(Symbol.keyFor(id1)); // "name"
```
### Object to primitive conversion
Conversion concerning just primitives such as `String` to `Number` is what we've already seen but we can also have objects convert to primitives as well. When converting an object to a primitive, JavaScript needs to figure out the intent behind this and give the expected output and to do this JavaScript uses hints, which are like patterns that occur is what to be expected in general cases.
For object-to-string conversion, this will happen when we do something like `alert`:
```javascript
let obj = {};
alert(obj); // object Object (string)
```
For object-to-number conversion, this will happen when mathematical operations are applied to objects:
```javascript
let num = Number(obj); // Explicit conversion (NaN) 
// maths (except binary plus)
let n = +obj; // unary plus
let delta = date1 - date2;

// less/greater comparison
let greater = user1 > user2;
```
 In cases where the operator is not sure what to expect, for example `obj1 + obj2` could be either arithmetic or concatenation, this is known as the `default` hint:
 ```javascript
 // binary plus uses the "default" hint
let total = obj1 + obj2;
// obj == number uses the "default" hint
if (user == 1) { ... };
```
The `default` hint is normally relied on and JavaScript will call three methods automatically to aid with relying on this hint:
**To do the conversion, JavaScript tries to find and call three object methods:**

- Call `obj[Symbol.toPrimitive](hint)` – the method with the symbolic key `Symbol.toPrimitive` (system symbol), if such method exists,
- Otherwise if hint is `"string"`
	- try calling `obj.toString()` or `obj.valueOf()`, whatever exists.
- Otherwise if hint is `"number"` or `"default"`
	- try calling `obj.valueOf()` or `obj.toString()`, whatever exists.
### Symbol.toPrimitive
This method will be called always if this is implemented in the object as it can handle all cases, JavaScript will provide the `hint` parameter depending on the situation:
```javascript
let user = {
  name: "John",
  money: 1000,
  [Symbol.toPrimitive](hint) {
    alert(`hint: ${hint}`);
    return hint == "string" ? `{name: "${this.name}"}` : this.money;
  }
};
// conversions demo:
alert(user); // hint: string -> {name: "John"}
alert(+user); // hint: number -> 1000
alert(user + 500); // hint: default -> 1500
```
### toString/valueOf
If there is no `Symbol.toPrimitive` function then JavaScript will try find `toString` and `valueOf` methods:
- For the `"string"` hint: call `toString` method, and if it doesn’t exist or if it returns an object instead of a primitive value, then call `valueOf` (so `toString` has the priority for string conversions).
- For other hints: call `valueOf`, and if it doesn’t exist or if it returns an object instead of a primitive value, then call `toString` (so `valueOf` has the priority for maths).
These are the old ancient way to do this, `Symbol.toPrimitive` is normally preferred over these two functions

It is important to note that a conversion can return any primitive type, but the important thing is that this type is not an object as it could lead to unpredictable behaviour. 

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
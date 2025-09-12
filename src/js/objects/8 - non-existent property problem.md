### Non-existent property problem
If we have an object then we must consider if a property exists since if we access a property that is not defined then it will output `undefined` and accessing a property of `undefined` will output an error.  This may not seem too important but we want to reduce our `undefined` outputs since we do not know the full context if we are trying to debug since we just have an `undefined` output to work with which can propagate to more unpredictable behaviour, or we do not know where this output is really coming from.

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

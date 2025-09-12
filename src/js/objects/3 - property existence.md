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
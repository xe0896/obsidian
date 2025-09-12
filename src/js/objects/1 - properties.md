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
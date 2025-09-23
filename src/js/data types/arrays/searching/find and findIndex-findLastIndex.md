Let's say we have an array and we want to find a specific item in this array but it must satisfy a certain condition, we can use `arr.find(fn)` to find this, where `fn` is a function that can be used to enforce this condition, it has similar parameters to `forEach`:
```js
arr.find(function(item, index, array) {
	// Condition that must return true or false
});
```
If our function returns `true` then the item is found and the function halts, else it will return `undefined`. 

When we want to return the index instead of the item if we found the item, then we should use `findIndex` which will return the index we found an item that satisfied our condition, we could also use `findLastIndex` if we wanted to start at the end.
```js
let users = [
	{id: 1, name: "John"},
	{id: 2, name: "Pete"},
	{id: 3, name: "Mary"},
	{id: 4, name: "John"}
];
  
// Find the index of the first John
alert(users.findIndex(user => user.name == 'John')); // 0
  
// Find the index of the last John
alert(users.findLastIndex(user => user.name == 'John')); // 3
```

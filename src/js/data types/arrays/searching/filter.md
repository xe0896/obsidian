The `find` function will return the first single occurrence that satisfies our given condition, if we want it to return an array of all the occurrences then we should use `filter` which will return an array, and it also takes the same parameters of `find`. 
```js
let results = arr.filter(function(item, index, array) {
	// Condition that returns true or false
});
```
For example:
```js
let users = [
	{id: 1, name: "John"},
	{id: 2, name: "Pete"},
	{id: 3, name: "Mary"}
];
  
// returns array of the first two users
let someUsers = users.filter(item => item.id < 3);

alert(someUsers.length); // 2
```

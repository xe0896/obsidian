The `.map` function is considered the most useful array function, it calls a function for each element of the array and returns the array of results:
```js
arr.map(function(item, index, array) {
	// Returns the new value instead of new item
});
```
It is important to make our function return the new value by modifying our current given `item`, if we do not return anything then the array will not transform.

For instance, here we transform each element into its length:
```js
let lengths = ["Bilbo", "Gandalf", "Nazgul"].map(item => item.length);
alert(lengths); // 5,7,6
```

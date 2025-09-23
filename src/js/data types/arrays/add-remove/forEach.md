The `arr.forEach` function allows us to run a function for every element in `arr`:
```js
arr.forEach(function(item, index, array) {
	// Operation
});
```
We can create our own function or use any function provided by JavaScript, a standard approach here would be to make an arrow function as it is anonymous and doesn't require a whole function definition if it was only a one-liner:
```js
arr.forEach((item, index, array) =>(
	arr[index] = item * 2;
));
```
However, if we wanted to transform an array then we should use `.map` instead since it will allow us to use the `item` parameter and actually manipulate it to see its changes on the array, that is the reason why we use `arr[index]` to actually change the array rather then doing something like `item = item * 2`.

`forEach` should be used for read only and not for write, that is for the `.map` function, but we can still make it work.

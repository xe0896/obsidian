The `sort` function does not behave as most people would think, if we was to have an unsorted array and call the `arr.sort` on it then we will get something like:
```js
let arr = [ 1, 2, 15 ];
  
// the method reorders the content of arr
arr.sort();

alert( arr ); // 1, 15, 2
```
Given that `arr.sort` will change the actual reference of `arr` then the return value of `arr.sort` is often ignored, we can also see that the array is not sorted and it is because JavaScript causes our elements to be converted into string and do lexicographical ordering and since `"2" > "1"` is true then `2` is greater then `15` as it will also forget the `5` in `"15"`. 

This is why `sort` takes in a function parameter to give it some rules, if we wanted the usual rules where we want ascending order then we can give this function:
```js
function compare(a, b) {
	if (a > b) return 1; // if the first value is greater than the second
	if (a == b) return 0; // if values are equal
	if (a < b) return -1; // if the first value is less than the second
}
```
The `sort` function is expecting a function parameter that has parameters `a,b` and also `arr` which we can omit, allowing us to sort our array:
```js
let arr = [1, 15, 2];
arr.sort(compare);
alert(arr); // [1, 2, 15]
```
We could also see what is being compared by adding some `alert` into our `compare` function, `compare` could also be optimised as we can just reduce it to:
```js
function compare(a,b) {
	return a - b;
}
```
As the `sort` function will just look at the sign of our returned result and if it is positive then it will imply `a` is after `b`, if it is negative then `b` after `a` and if they are the same then `a - b` returns `0` and `sort` can treat this as normal.

We could even reduce this further by using an arrow function:
```js
arr.sort((a,b) => a - b);
```

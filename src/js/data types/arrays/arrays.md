Declaring an empty array is very simple and similar to how it is in Java:
```javascript
let arr = new Array();
let arr = [];
```
We can also declare the items in an array similar to an object literal by listing the values with commas, also it is important to note that the data types do not need to be the same for all values in the array, we can have different data types such as strings, objects and functions:
```javascript
let arr = [`Apple`, { name: 'John' }, true, function()]; // No errors
```
### Internals
An array will be considered an array if we do not mess with the internals, in the sense of not adding any properties to the array as the compiler will consider the array to be a generic object which will lose its optimisations and can cause some unpredictable behaviour if we are not aware of this de-optimisation. When we are working with a former array that was storing millions of values then a de-optimisation can make a big performance impact.
### Performance
Methods that arrays have such as `pop/push` are fast and `shift/unshift` are seen as slow, this is because it is faster to work with the end of an array rather then the start since if we was to change the elements at the start then we will need to shift our elements in order to preserve the ordered nature that arrays offer.
### Loops
There are different ways to iterate over an array, one of the more common ways is to iterate over the arrays indexes:
```javascript
let arr = ['Apple', 'Orange', 'Pear'];
for(let i = 0; i < arr.length; i++) {
	alert(arr[i]);
}
```
A more concise way which is also as common is to use `for of`:
```javascript
for(let arrs of arr) {
	alert(arrs);
}
```
There are no major differences regarding both of these but the main difference is that the 2nd one is more readable and less prone to bugs then the 1st.

We could also use `for in` and treat the array like an object, but this is not always a good idea as it will iterate over the entire property list of the array, including `length` and potentially other unwanted properties to be listed that have been created prior.

Also, `for in` is not optimised for arrays, meaning it will run much slower then the previous options.
### length property
The property `length` in an array is writable, meaning we can change it, this will also reflect on what is available to be gathered from the array as if we was to do `arr.length = 5` when there are `6` elements then we can only view `5` elements rather then the full `6`, this also means that if we wanted to clear an array we can set `arr.length = 0`.
### new Array()
There is a less common way on creating an array, and that is to use the following syntax:
```javascript
let arr = new Array('Apple', 'Pear', 'Melon');
```
We could also do `new Array(100)` which will create an empty array but will have the property of `arr.length = 100`.
### Multi-dimensional arrays
We can create multi-dimensional arrays, similar to how other languages do it by storing an array within an array:
```javascript
let matrix = [
	[1, 2, 3],
	[4, 5, 6],
	[7, 8, 9]
];
alert(matrix[0][1]);
```
### Identify arrays
We can use `Array.isArray(potentialArr)` to see if it is an array, the reason for this is because `typeof` will make arrays return an object.

Declaring an empty array is very simple and similar to how it is in Java:
```javascript
let arr = new Array();
let arr = [];
```
We can also declare the items in an array similar to an object literal by listing the values with commas, also it is important to note that the data types do not need to be the same for all values in the array, we can have different data types such as strings, objects and functions:
```javascript
let arr = [`Apple`, { name: 'John' }, true, function()]; // No errors
```
### pop/push, shift/unshift
Arrays are used for common data structures such as stacks and queues, meaning they have their own pre-built functions to convert an array to these data structures with simple functions. This also will mean that a given array can be utilise the functions of a normal stack and queue at the same time, giving them a special name Deque.

There are four main functions that allow us to use an array like it is a Deque:
- If we wanted to act as a queue we use the functions `push` to append at the end and `shift` to shift the elements and return the first element
- If we wanted to act as a stack we use the functions `push` to append at the end of the list and `pop` to take the element at the end
The last function is named `unshift` which adds the given element to the beginning of the array. The four functions will act as expected and doesn't need any clarification.
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
### toString
We can convert an array into a string by using `toString` but we can also output its string version by using `alert`
### Comparing arrays
Like other programming languages, we cannot compare two arrays using `===` or `==`, but we must iterate the two arrays and compare them, item by item.
## Array methods
There are many methods that arrays have that we can use, excluding the stack and queue ones:
- `splice`
- `slice`
- `concat`
- `forEach`
- `indexOf/lastIndexOf`
- `includes`
- `find`
- `findIndex/findLastIndex`
- `filter`
- `sort`
- `reverse`
- `split/join`
- `reduce/reduceRight`
- `isArray`
- `thisArg` (special one)
### splice
Whenever we want to delete an element from an array we can use `delete`:
```javascript
let arr = ["Hello", "World", "!"];
delete arr[1];
alert(arr[1]); // Undefined
alert(arr.length); // 3
```
As we can see from `arr.length`, the item has been removed but its index is still considered to be non vacant but not empty, this means that the array would look like: `[Hello, , !]`.

If we wanted to remove an element from an array and make it affect `arr.length` by shifting all the elements above it, then we can use the `splice` method. This method can also do insertions and replacements, so it can be seen very useful, the syntax is:
```javascript
arr.splice(start[, deleteCount, elem1, ..., elemN]);
```
The `[,` may look a bit strange but that is just indicating that `deleteCount, elem1, ..., elemN` are optional parameters and that if there was two parameters in `splice` then it would be `arr.splice(start, deleteCount)`.

The `start` specifies what index we want to start deleting from and `deleteCount` specifies how many elements from `start` do we want to delete, the `elem`'s given will be replacing the deleted elements depending on our `start` and `deleteCount`.
### slice
If we had an array but wanted to make a sub-array, we can use the `slice` method, which has the syntax:
```javascript
arr.slice([start], [end])
```
Where `start` denotes the start of the sub-array and `end` denotes the end of the sub-array, `end` will not be included in the sub-array. We could have `start` and `end` to be negative numbers, in which case they would operate at the end of the array, we could also have no parameters at all, which would just produce a duplicate array.


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

Parameter sequence `elemN` will be used to add extra items onto `arr` since if we was to remove `3` elements starting from index `2` then we will start at index`2` and remove `3` elements then we have the option to fill in the removed `3` elements and we specify that information using `elemN`. 

A common question would be: "What if we specified more `elemN` then `deleteCount`" and the answer is that `deleteCount` takes precedence here and our extra elements would be disregarded.

If we wanted to add elements then we would make `deleteCount=0` and specify the elements we want to add with `elemN` by also giving it a starting index using `start`. 
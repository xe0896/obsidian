 If we had an array but wanted to make a sub-array, we can use the `slice` method, which has the syntax:
```javascript
arr.slice([start], [end])
```
Where `start` denotes the start of the sub-array and `end` denotes the end of the sub-array, `end` will not be included in the sub-array. We could have `start` and `end` to be negative numbers, in which case they would operate at the end of the array, we could also have no parameters at all, which would just produce a duplicate array.
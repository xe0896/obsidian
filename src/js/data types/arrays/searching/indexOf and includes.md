These two functions are basically the same but return different things, `indexOf` will take in two parameters `item` and `from` where `item` is the item we want to find and `from` is where we want to start and is optional, if `from` is not specified then it is assumed to be `0`. `indexOf` will return the index of the `item` value, if there is more then one occurrence then we can use `from `if necessary to look into more deeper values. 

`includes` will also take in the same parameters but will return either `true` or `false` if the value is there, it is basically `indexOf` in disguise but returns `true` if it doesn't return `-1` which is the value `indexOf` would return if there is no item in the array. 
```js
let arr = [1, 0, false];
  
alert( arr.indexOf(0) ); // 1
alert( arr.indexOf(false) ); // 2
alert( arr.indexOf(null) ); // -1
  
alert( arr.includes(1) ); // true
```
It is also important to note that `includes` will use the strict equality `===` for comparison, so it will look for exactly `false` and not `0`, also `includes` can handle the input `NaN` which `indexOf` cannot. 
```js
const arr = [NaN];
alert( arr.indexOf(NaN) ); // -1 (wrong, should be 0)
alert( arr.includes(NaN) );// true (correct)
```
### lastIndexOf` 
We can also start from right to left as oppose to left to right which `indexOf` by doing `lastIndexOf`


The method `arr.concat` will create a new array that includes values from other arrays given and also additional items:
```js
arr.concat(arg1, arg2, arg3..., argN);
```
Our arguments could be integers and doesn't have to be arrays and will just be appended as normal, we could also include objects given that the object has a special property:
```js
let arr = [1, 2];
  
let arrayLike = {
	0: "something",
	1: "else",
	[Symbol.isConcatSpreadable]: true,
	length: 2
};

alert( arr.concat(arrayLike) ); // 1,2,something,else
```
By specifying that `Symbol.isConcatSpreadable` is `true`, we can spread out all the properties and make this object into an array, and since every array has a length specified, it will not be outputted when we use `.concat` .

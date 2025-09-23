`split` will take in a string and split it depending on a delimiter and represent this as an array, for example: if we had a string that had a list of names: `John, Khan, Bob` then we can use the delimiter `", "` to break this string into an array of size `3`:
```js
let names = "John, Khan, Bob"
let arr = names.split(', ');
alert(arr); // ["John","Khan","Bob"]
```
`split` also has an extra parameter which can limit the amount of elements of our array.

`arr.join` does the opposite of `split` and takes in a string that could be seen as a glue, it will iterate over our array and concatenate with our glue excluding the last element:
```js
let arr = ['Bilbo', 'Gandalf', 'Nazgul'];
let str = arr.join(';'); // glue the array into a string using ;
alert( str ); // Bilbo;Gandalf;Nazgul
```

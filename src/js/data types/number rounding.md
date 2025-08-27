JavaScript has two types of numbers:
- Regular numbers called `Number` stored in 64-bit format
- Numbers representing arbitrary lengths called `BigInt`

The following will be focusing on `Number`:

If we have a large `Number` instead of enumerating all the digits we can use `e` to represent large numbers as `1e9` would be equivalent to `1` and `9` zeros, namely `1` billion.
```javascript
alert(1e3 === 1 * 1000);
alert(1.23e6 === 1.23 * 1000000);
```
If we wanted to represent a smaller number we can replace `e` with `-e`:
```javascript
let mcs = 0.000001;
alert(mcs === 1e-6);
```
### Hex, binary and octal numbers
We can represent hexadecimal numbers by using `0x` notation:
```javascript
alert(0xFF); // 255
alert(0xff); // 255
```
We can also represent binary numbers and octal numbers by using `0b` and `0o` respectively:
```javascript
let a = 0b11111111;
let b = 0o377;
alert(a === b); // true
```
### toString(base)
We can represent the `String` representation of `num` by a given base via: `num.toString(base)`:
```javascript
let num = 255;
alert(num.toString(2)); // 11111111
alert(num.toString(16)); // ff
```
If we wanted to use a direct number and convert it to its `String` format given a base then we must use double `..`:
```javascript
123456..toString(16);
```
This is because JavaScript will get confused with the decimal as it will expect extra numbers after the `.` as it is thinking that the code will include something like `123456.111`, if we use double `..` this  makes the parser imply that this is a whole number that wants to get its `String` format.
### Rounding
There are several in-built functions for rounding with different behaviours:
- `Math.floor`: Rounds down, `3.9` becomes `3` and `-1.1` becomes `-2`
- `Math.ceil`: Rounds up, `3.1` becomes `4` and `-1.1` becomes `-1`
- `Math.round:` Rounds to the nearest integer, `3.8` becomes `4` and `3.2` becomes `3`
- `Math.trunc`: Removes the decimal part of a number, `3.9` becomes `3`

If we wanted to round the number to `n-th` digit after the decimal, there are two ways to do so:
1. Multiply and divide: for example, to round the number to the 2nd digit after the decimal, we can multiply the number by `100`, call the rounding function and then divide it back.
2. toFixed(n): The method [toFixed(n)](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Number/toFixed) rounds the number to `n` digits after the point and returns a string representation of the result.
### Imprecise calculations
Due to JavaScript being limited to 64-bit integers, we have 52 bits to store the digits and 11 bits for decimal point and 1 bit for the sign bit. This means that we are limited to 52 bits meaning if we was to go pass this value we will reach a `Infinity`:
```javascript
alert(1e500); // Infinity
```

We can also encounter the classic problem of `0.1 + 0.2 != 0.3`:
```javascript
alert(0.1 + 0.2); // 0.30000000000000004
```
To avoid this happening since we clearly want `0.3` we can use `toFixed(n)` function to round it to an appropriate value.
### isFinite and isNaN
Our two special values `Infinity` and `NaN` can't be identified using equality checks such as `x === NaN`, so to identify our special values we can use functions `isFinite` and `isNaN`:
```javascript
alert(isNaN(NaN)); // true
alert(isNaN("a")); // true
alert(NaN === NaN); // false
alert( isFinite("15") ); // true
alert( isFinite("str") ); // false, because a special value: NaN
alert( isFinite(Infinity) ); // false, because a special value: Infinity
```
### Object.is(x,y)
Where `x` and `y` are what we want to compare, this is similar to `===` but is more reliable for two edge cases:
- It works with `NaN`: `Object.is(NaN, NaN) === true`, that’s a good thing.
- Values `0` and `-0` are different: `Object.is(0, -0) === false`, technically that’s correct because internally the number has a sign bit that may be different even if all other bits are zeroes.
### parseInt, parsefloat
We cannot keep on relying on converting a `String` to a `Number` by using the `+` trick since we could be given a `String=100px` and we cannot convert to a `Number` nicely since `px` is in the way so we can use `parseInt` to just get the `Number` we want.
```javascript
alert(+"100px"); // NaN
alert(parseInt('100px')); // 100
```
This can also be applied to `float` and requires a distinct function since of decimal numbers being omitted appropriately:
```javascript
alert(parseFloat(12.3.4)); // 12.3, the second decimal point is ignored, only conisiders first occurence
```
Sometimes we can get an output of `NaN` if the first symbol was a character like `a`:
```javascript
alert(parseInt('a123')); // NaN
```
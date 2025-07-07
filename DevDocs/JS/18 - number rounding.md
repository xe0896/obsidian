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
1. Multiply and divide
Data types in JavaScript are not as strict in Java where we have to declare the data type before declaring a variable, the following will output no errors:
```javascript
let msg "Hello";
msg = 121;
```
This is the case for integers also.

There are special datatypes such as `Infinity` and `NaN`:
```javascript
n = 1/0 // Infinity
alert("Hello" / 20) //NaN
```
These special datatypes are sticky, which means that they can be used in mathematical operations and return `NaN` or `Infinity` accordingly.

Math in JavaScript is "safe", meaning we will not get any errors when dividing by zero or dividing a string by `20` we will just get these special datatypes.
### BigInt
The "number" type in JavaScript cannot safely represent numbers larger then $2^{53}-1$, we say safely since any numbers larger then that will encounter rounding errors, we could theoretically store numbers up to $1.7976931348623157 \times 10^{308}$ but it will encounter rounding errors as we are storing this in 64-bit memory. 
```javascript
console.log(9007199254740991 + 1); // 9007199254740992
console.log(9007199254740991 + 2); // 9007199254740992
```
These output the same value due to rounding errors.

If we want really large numbers, we can use `BigInt` to store this, we add an `n` at the end of a number to indicate that we want to use `BigInt`:
```javascript
const bigInt = 1234567890123456789012345678901234567890n;
```
### String
There are 3 types of quotes:
1. Double quotes: "Sup"
2. Single quotes: 'Sup'
3. Backticks: `Sup`, Markdown..
```javascript
let msg0 = "Hello";
let msg1 = 'Hello';
let msg2 = `Hello`;
```
`msg0` and `msg1` are functionally the same, but `msg2` in this case is still the same but can be extended:

```javascript
let name = "Zain";
alert(`Hello, ${name}`);
alert(`1+1 = ${1+1}`); // x
```
If we tried to replace the backticks with double quotes on the statement commented with `x` then it would just output: `${1+1} = 2`, rather then calculating.

### Boolean
Booleans are lower case not upper case.
### null
null exists.
### Undefined
Similar to null values but it is more relevant as it could be not undefined, for example:
```javascript
let age;
alert(age);
```
The above returns `undefined` as the age is initalised but is not pointing to any value, we can also assign values to `undefined` explicitly, but this is not general practise, we should stick to assigning stuff to `null`. 
### Objects and Symbols
This deserves its own section, `symbol` type is used to create unique identifiers for objects. Mentioned here since it is a data type.
### typeof operator
If we have a reference to a datatype and want to know what data type it is then we can do the following:
```javascript
typeof "foo"
// Same thing below
typeof("foo")
```
Which will output `String`, this can be useful when we want to do a different operation depending on the data-type, or if we want to quickly check what data-type is.

This also works for `functions`, `objects` and `symbols` too.






The operators used in JavaScript align with other languages but there are some few differences which will be outlined.
## Exponents
Exponents differ between languages so outlining this is somewhat useful:
```javascript
alert(2**4) // 16
```
## String concatenation
String concatenation is flexible like in Python where we can use `+`  to concatenate strings, but there are some different behaviours depending on what `String` is being used.
```javascript
let str = "hello" + "world";
alert(str) // helloworld
```
There is extended behaviour with string concatenation, if we was to concatenate a `Stirng` with a `Number`, then depending on what is being added first whether it be `String` or `Number` it will either concatenate or perform a summation.
```javascript
alert('1' + 2 + 2): // 122
alert(2 + 2 + '1'); // 41
```
In the first line, starting from the left the first data-type is a `String` so then it will concatenate the rest regardless of the data-type and if it was a `Number`, then it will perform standard addition.
### Unary +
A unary + which is in the form `+x` will have no effect to `Number` but it will have effects to all other data-types by converting the data-type to its `Number` form, i.e: `+true = 1`
### Assignment = returning a value
JavaScript can use `=` in a weird way, in the form `x = value`  and we can locate this within another assignment:
```javascript
let a = 2
let b = 3
let c = 3 - (a = b + 1);
alert(c); // -1
alert(a); // 4
```
Not considered readable code though so this is rarely used.
### Chaining assignments
We are able to chain assignments, in the sense where we can assign multiple variables to be assigned with one another in one-line
```javascript
let a, b, c;
a = b = c = 0;
alert(a); // 0
alert(b); // 0
alert(c); // 0
```
### Increment/Decrement
A lot of programming languages already offer the use of `++` and `--` to increment and decrement, but JavaScript extends this by being able to put this before a variable rather then after it.

The difference between the two is that if the prefix is before the variable then it will apply the operation "immediately", in the sense of us returning the value and obtaining the incremental or decremental form of the variable.
```javascript
let a = 0;
let b = 0;
alert(++a) // 1
alert(a++) // 0
```
Both will have the same result in the end but the value it will return will be different at that time
### Bitwise operators
Not to be confused with logical operators

|        Symbol         | Operation |
| :-------------------: | :-------: |
|           &           |    AND    |
|          \|           |    OR     |
|           ^           |    XOR    |
|           ~           |    NOT    |
|      LEFT SHIFT       |    <<     |
|      RIGHT SHIFT      |    >>     |
| ZERO-FILL RIGHT SHIFT |    >>>    |
The zero-fill right shift operator could be a bit new and this is just filling the 0s on the left when doing a right shift, this is relevant since if we was shifting a negative number then the sign bit will be ignored and filled in with 0s which will then turn a small negative number into a large positive number.
### Comma
Commas are used to evaluate several expressions in one line, on obvious case is to initialise multiple variables 
```javascript
let a,b,c;
```
The other case is to use this to initialise one variable but will only use the last expression used, this isn't entirely useful in this case
```javascript
let a = (1 + 2, 3 + 5);
alert(a) // 8
```
This will evaluate `1+2` which is `3` then is thrown away and then evaluates `3+5` which is `8`. JavaScript frameworks usually use this to combine single expressions into one line with different variables.


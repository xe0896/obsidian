We can convert our data-types to other data-types very loosely and the conversion of a `boolean` to `String` will mean the `String` will be either `false` or `true`. 

This will be a short one since there isn't much to cover.

`x` conversion implies that we convert a data-type to `x`. 
### String conversion
The data-type that we convert to a string will have its reference such as `true`, `NaN` or `10` turned into a string.
```javascript
let bool = true;
bool = String(bool);
alert(bool); // "bool"
```
### Numeric conversion
This conversion happens automatically, and doesn't require the `Number()` function in some cases.
```javascript
alert("6"/ "2"); // 3, and 3 is an integer
```
- If we try to convert a `String` that is not a complete number like `John` to a `Number` then it will return `NaN`, if the `String` is empty then it will to `0`
- If we try to convert a `Boolean` to a `Number` then it will be `0` or `1` depending on the `Boolean` value
- If we try to convert `null` into a `Number` then it will return `0`
### Boolean conversion
Booleans have special cases on when they will output false, this is because an existence of a value can be seen as something being true, in the sense of it actually existing.

|      Value      | Output |
| :-------------: | :----: |
|        0        | false  |
|      null       | false  |
|    undefined    | false  |
|       NaN       | false  |
|       ""        | false  |
| any other value |  true  |

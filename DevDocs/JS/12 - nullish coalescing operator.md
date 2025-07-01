A defined value is a value that is not `null` or `undefined`, if we have two values `a` and `b` then want to figure out the first defined value depending on the order of `a` and `b` we can do `a ?? b`:
```javascript
result = a ?? b;
// Same thing below:
result = (a !== undefined && a !== null) ? a : b;
```
This can be useful if we have a variable that could be defined or not and if it is not we can label it undefined in our context:
```javascript
let name = "Zain";
alert(name ?? "Anonymous"); // returns Zain, if it was just "let name" then would return "Anonymous"
```
We can extend this with a sequence of parameters: `a ?? b ?? c ?? ..`

The `??` operator can be seen the same as the `||` operator and was seen as the same and used by many but the only difference is that:
- `||` returns the first truthy value
- `??` returns the first defined value
`||` considers `false`, `0`, `""` as falsy but `??` still considers them as defined since they was assigned a value

Parenthesis when using this operator is important as it has the same precedence as the `||` operator which means we must use parenthesis if we want the correct order:
```javascript
let area = (height ?? 50) * (width ?? 50); // Correct with parenthesis
// Assume the below didn't have parenthesis, JavaScript will assume these brackets
let area = height ?? (50 * width) ?? 50);
```
This is because `* > ??` in terms of precedence.

Combining `||` with `??` outputs a syntax error unless there are brackets to aid with the precedence since the precedence is the same as JavaScript is not sure what to execute first.
```javascript
let x = 1 && 2 ?? 3; // syntax error
let x = (1 && 2) ?? 3; // returns 2
```

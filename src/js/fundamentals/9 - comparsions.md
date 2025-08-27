Comparisons in JavaScript align with other programming languages but there is a few differences which will be outlined.
### Strict equality
When using normal equality we will see that it cannot distinguish between different types and will convert the two operands to a form that could potentially make them equal and return `true`, for example `alert(0 == false)`will return `true` as it converts the operands to the same data-type.

If we do not want this behaviour and want to make the equality detect different data-types we use the `===` equality which will make `alert(0 == false)` return `false`.
### Comparison with null and defined
Comparing values to `null` and `defined` can have some strange outputs, for instance: `null` and `defined` are seen as equal but if we use strict equality then it will return `false`
```javascript
alert(null == undefined); // returns true
alert(null === undefined); // return false
```
`null` can also have some strange behaviour when comparing with `0`:
```javascript
alert(null > 0); // false
alert(null == 0); // false
alert(null >= 0); // true
```
The first two statements are expressing the same thing as the last statement but they are still both `false` when at least one of them should be `true`. For the first statement, `null` is being converted to `0` which makes it turn into `alert(0 > 0)` which is `false`, for the second statement the only data-type that can make `null = x` return `true` is `undefined`, so this returns `false` also. The last statement is a comparison operator and not an equality check so it doesn't require `x` to be `undefined` in this case and will convert it to a `0`, so: `alert(0 >= 0)` returns `true`.
### Incomparable undefined
`undefined` shouldn't be compared to any value at all other then `null` since it will always return `false` if this is the case:
```javascript
alert(undefined > 0); // return false
alert(undefined == 0); // return false
alert(undefined >= 0); // return false
alert(null >= 0); // return true
```
The reason for this behaviour is that when comparing with `undefined`, it converts to `NaN` which then will make all comparisons with it return `false`.


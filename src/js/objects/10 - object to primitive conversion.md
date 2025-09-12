Conversion concerning just primitives such as `String` to `Number` is what we've already seen but we can also have objects convert to primitives as well. When converting an object to a primitive, JavaScript needs to figure out the intent behind this and give the expected output and to do this JavaScript uses hints, which are like patterns that occur is what to be expected in general cases.
For object-to-string conversion, this will happen when we do something like `alert`:
```javascript
let obj = {};
alert(obj); // object Object (string)
```
For object-to-number conversion, this will happen when mathematical operations are applied to objects:
```javascript
let num = Number(obj); // Explicit conversion (NaN) 
// maths (except binary plus)
let n = +obj; // unary plus
let delta = date1 - date2;

// less/greater comparison
let greater = user1 > user2;
```
 In cases where the operator is not sure what to expect, for example `obj1 + obj2` could be either arithmetic or concatenation, this is known as the `default` hint:
 ```javascript
 // binary plus uses the "default" hint
let total = obj1 + obj2;
// obj == number uses the "default" hint
if (user == 1) { ... };
```
The `default` hint is normally relied on and JavaScript will call three methods automatically to aid with relying on this hint:
**To do the conversion, JavaScript tries to find and call three object methods:**

- Call `obj[Symbol.toPrimitive](hint)` – the method with the symbolic key `Symbol.toPrimitive` (system symbol), if such method exists,
- Otherwise if hint is `"string"`
	- try calling `obj.toString()` or `obj.valueOf()`, whatever exists.
- Otherwise if hint is `"number"` or `"default"`
	- try calling `obj.valueOf()` or `obj.toString()`, whatever exists.
### Symbol.toPrimitive
This method will be called always if this is implemented in the object as it can handle all cases, JavaScript will provide the `hint` parameter depending on the situation:
```javascript
let user = {
  name: "John",
  money: 1000,
  [Symbol.toPrimitive](hint) {
    alert(`hint: ${hint}`);
    return hint == "string" ? `{name: "${this.name}"}` : this.money;
  }
};
// conversions demo:
alert(user); // hint: string -> {name: "John"}
alert(+user); // hint: number -> 1000
alert(user + 500); // hint: default -> 1500
```
### toString/valueOf
If there is no `Symbol.toPrimitive` function then JavaScript will try find `toString` and `valueOf` methods:
- For the `"string"` hint: call `toString` method, and if it doesn’t exist or if it returns an object instead of a primitive value, then call `valueOf` (so `toString` has the priority for string conversions).
- For other hints: call `valueOf`, and if it doesn’t exist or if it returns an object instead of a primitive value, then call `toString` (so `valueOf` has the priority for maths).
These are the old ancient way to do this, `Symbol.toPrimitive` is normally preferred over these two functions

It is important to note that a conversion can return any primitive type, but the important thing is that this type is not an object as it could lead to unpredictable behaviour. 

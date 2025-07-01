The four logical operators are: `||` (OR), `&&` (AND), `!` (NOT) and `??` (Nullish Coalescing). The first three are obvious on what they do but the last one is special to JavaScript. There are some additional behaviours with the first three though in JavaScript.
### Special cases of OR
The additional behaviour is how the boolean expression is evaluated when using data-types that are not `boolean`, for the `OR` operator we execute the expression from left to right and once we find a data-type that when converting it to `boolean` is `1`, we return the original operand and not the `boolean` value:
```javascript
let a = "";
let b = "";
let c = "Hello";
alert(a || b || c || "Sup"); // returns "Hello"
```
Since empty strings return `false`, we continue once we find a conversion that is `true`, which in this case is `c` and then return the operand which is `Hello` and not `true`, if all variables was `false` then it would return `Sup` always.

Another behaviour that can be enabled with `OR` is by using short-circuit evaluation which is when once we encounter a value that returns `true` then it will ignore the operands after it, this is can obviously be seen as an optimisation but it can also be seen as executing a statement only if the first operand is `false` as if it was `true` it would evaluate `true` and ignore the second operand:
```javascript
true || alert("dont print"); // doesn't do anything, evaluates true and stops
false || alert("print"); // operand is false so moves on and evaluates print
```
### Special cases of AND
Similar to the `OR` operator, operands are evaluated left to right and for each operand it will convert it to a `boolean` and once it encounters a `false` conversion then it will output the operand not the `boolean` value and if all values are `true` then it will return the last operand, similar to the `OR` case.
### Special cases of NOT
The NOT operator works as normal but it can also be seen as converting a operand into its `boolean` form by doing a double NOT:
```javascript
alert(!true); // return false
alert(!!"Hello"); // return true
```
A more verbose way of doing this is using the `Boolean()` function

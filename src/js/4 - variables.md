Variables are declared using the `let` keyword, we first initalise its name with the `let` keyword then we can assign it to a value, just like Java.

```javascript
let msg;
msg = "Sup";
```
We could also combine these into one, just like Java.
```javascript
let msg = "Sup";
```

We could also use one `let` keyword to declare multiple variables, not like Java.
```javascript
let msg = "Sup", num = 2, user = "Bob";
```
`let` and `var` are basically the same thing but with subtle differences, `let` is the more up-to date way of declaring variables.

There are some limitations but they are obvious to what we can name our variables, such as variables that start with a digit, variables that have the name `return`, `let`, etc.
### Constants
When a programmer is sure that a variable will never change, they can declare it with `const` to guarantee and communicate that fact to everyone.
```javascript
const myBirthday = '28.03.2010`;
myBirthday = '01.01.2012'; // Not allowed
```
It is good practise to use constants to know other programmers that see our code that this piece of information will never change, it is also good practise to use constants to store information that are hard to remember and then assign these to variables later on with the more easier to remember name:
```javascript
const RED = #F00;
const GREEN = #0F0;
const BLUE = #00F;

let blue = BLUE;
```
## Example

1. Declare two variables: `admin` and `name`.
2. Assign the value `"John"` to `name`.
3. Copy the value from `name` to `admin`.
4. Show the value of `admin` using `alert` (must output “John”).

```javascript
let admin, name;

name = "John";
admin = name;

alert(admin);
```


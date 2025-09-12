If we wanted our `key` to be more then one word then we can use quotation marks:
```javascript
let user = {
	name: "Bob",
	occupation: "Sales",
	"is male": true
};
```
However, a problem arises if we use multi worded `key` since if we want to access that property then we cannot do `user.is male` so instead we use `user["is male"]` for accessing and also setting. We can also assign a variable like `let key = "is male"` and then do `user[key]`, its the same thing.

Using brackets to access our `value` can be helpful if we asked for a prompt that asks the user what they want to know about a specific person and store that into a variable and use the bracket notation to access that information from the object:
```javascript
let key = prompt("What do you want to know about this user? name, occupation, is male?");
alert(user[key]);
```
This type of logic won't work with dot notation as we are accessing the key directly rather then having a dynamic input.
### Computed properties
When defining the object properties, we can put the `key` in square brackets to allow it to change:
```javascript
let fruit = prompt("What fruit to buy?");
let bag = {
	[fruit]: 5,
}
alert(bag.apple) 
```
If the user didn't input `apple` then it would output `undefined`, we could do `bag[fruit]` to get whatever is being stored regardless of the user input so it poses the question, "What is the point of this?" and the real reason is just to make it easier to read and what to expect when we are scanning our code.

When using square brackets we can concatenate strings with the `key`:
```javascript
let bag = {
	[fruit + "Computers"] : 5
}
alert(bag.appleComputers); // 5
```

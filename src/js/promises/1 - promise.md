Promises are used to handle asynchronous operations, in a cleaner and manageable way than traditional callbacks. If there was a world without Promises then we will have something known as callback hell:
```js
doSomething(function(result1) {
    doSomethingElse(result1, function(result2) {
        doThirdThing(result2, function(result3) {
            console.log("Done", result3);
        });
    });
});
```
The code is deeply nested and will just grow as we have more things to do and it would be a nuisance to handle errors.

A Promise represents a value that may not be available yet, but will be resolved (success) or rejected (failure) in the future, allowing us to change our code to this:
```js
doSomething()
    .then(result1 => doSomethingElse(result1))
    .then(result2 => doThirdThing(result2))
    .then(result3 => console.log("Done", result3))
    .catch(err => console.error(err));
```
- Pending: the operation hasn’t finished yet
- Fulfilled: operation succeeded → `.then()`runs
- Rejected: operation failed → `.catch()` runs

The code above is a bit mysterious for now, we will start from the basics:

When we want to create a Promise we create `new Promise` which will have parameters `resolve` and `reject` which are both functions:
```js
let promise = new Promise((resolve, reject) => {
	// DO some work
})
```
When we complete our operation and we want to return a value that represents this operation, then we would do `resolve(value)` where `value` is our value that we want to output, if something goes wrong then we should do `reject(err)` where `err` is our error value which is normally an `Error` object. For an example to represent this, we can make a `divide` function that takes in two parameters `a,b` which would attempt to do `a/b`, the obvious error here would be if `b=0`:

```js
function divide(a,b) {
	return new Promise((resolve, reject) => {
		if(b === 0) {
			reject(new Error("Cannot divide by zero"));
		} else {
			resolve(a / b);
		}
	});
}
```

Now if we was attempt to call this then we should see an appropriate output, since there is only one operation then we will not need to use `.then` as there is nothing that this depends on, meaning we just need `.catch`:
```js
divide(10,0).catch(err => console.log(err.message));
// Output: "Cannot divide by zero"
```
`.then` can take an additional parameter in the form `.then(onFulfilled, onRejected)` would be the error message that `.catch` would do for that promise, since an additional parameter versus just using `.catch` is seen to be less concise, it is advised to stick to `.catch`.

There is also an additional clause called `finally`, the idea of finally is to set up a handler for performing cleanup after the previous operations are complete, like stopping loading indicators or closing no longer needed connections. This would still execute regardless of whether it was a `resolve` or a `reject`, we should still do a cleanup. 

This means that if we have a promise that is rejected but it is given to a `.finally` clause then that `.finally` clause will not fall back on the `.catch` clause as it does not care whether if the promise was rejected or not, it is here just to do some cleanups.
```js
new Promise((resolve, reject) => {
  throw new Error("error");
})
  .finally(() => alert("Promise ready"))
  .catch(err => alert(err));
```

Here, we can see that we have received an `Error` object which is equivalent of doing `reject(new Error(...))` (this is also the same for `resolve` when we `return` something) meaning `.finally` has been given a rejected promise but it will still execute and alert `"Promise ready"`, also `.finally` would output what it has been given and we have given it a rejected promise so it will output a rejected promise to `.catch` which would output an error.

**To summarise for finally:**
A finally handler doesn’t get the outcome of the previous handler (it has no arguments). This outcome is passed through instead, to the next suitable handler.
If a finally handler returns something, it’s ignored. When finally throws an error, then the execution goes to the nearest error handler.



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


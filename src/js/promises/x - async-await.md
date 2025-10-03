Promises can be pretty intimidating when it comes to syntax, we can use `async` and `await` keyword to make this much more manageable for your brain, let's start with the `async` keyword.

`async` can be declared before a function that automatically makes wraps the return value with a resolved Promise, if we wanted a rejection then we would throw an error:

```js
async function foo() {
	return 1;
}

foo().then(value => console.log(value));
```

If we wanted to, we could return a Promise which would output the same result:

```js
async function foo() {
	return new Promise.resolve(1);
}

foo().then(console.log); // Console.log is a function that can be used as a callback
```

The `await` keyword will only work in functions that are `async` and the syntax is something like this:

```js
let value = await promise;
```

JavaScript will wait until this Promise is completed before carrying on. Lets make a Promise which can be outside the `async` or not (lets make it inside) and use the `await` keyword to make JavaScript wait until the Promise has been resolved and execute the next line which should signify that the Promise is completed (like an `alert`).

```js
await function task() {
	let promise = new Promise((resolve, reject) {
		setTimeout(() => resolve("Done"), 1000);
	});
	let value = await promise;
	alert(value);
}

task();
```
### Error handling
If a Promise is resolved then it would return the result of that Promise, if it was a rejection that it would `throw` an error object:

```js
async function fooPromise() {
	await Promise.reject(new Error("Error has occured"));
}
// Same thing as:
async function fooThrow() {
	throw new Error("Error has occured");
}
```

Promises would need some type of error handling in this case, so we can use `try` and `catch` to handle errors rather then the standard `.catch`: 

```js
async function foo() {
	try {
		let response = await fetch("GJWOjigjiog");
	} catch (err) {
		alert(err);
	}
}
```

If we didn't add `try` and `catch` then for our example which has a hard coded reject, it would return a rejected Promise which we can catch using `.catch`:

```js
async function foo() {
	await Promise.reject(new Error("Error has occured"));
}

foo().catch(console.error); // Remember .catch expects a function callback
```
### Promise.all
Given that we have multiple asynchronous operations in a sequence, we can use `Promise.all` to do them in parallel, which can take in all the async operations in an array and store the output in the array without several `await` calls, if we wanted to use the values from the Promises then we should use `try` and `catch` to use them in `try` and catch any errors in `catch`:

```js
async function f() {
  try {
    const [a, b, c] = await Promise.all([
      Promise.resolve(1),
      Promise.reject("fail!"),
      Promise.resolve(3)
    ]);
    console.log(a, b, c);
  } catch (err) {
    console.error("Caught error:", err);
  }
}

f(); // logs: "Caught error: fail!"
```

An important thing to note here is that if one of our Promises are rejected, then JavaScript won't consider the later promises and if they are rejected then they are not caught, which could lead to a system crash as it is a console error.
### Clarfications
When we use `async/await`, we rarely need `.then`, because await handles the waiting for us. And we can use a regular `try..catch` instead of `.catch`. That’s usually (but not always) more convenient.





Given that we have a sequence of asynchronous tasks, we should use Promises to create a chain to allow us to do this efficiently, an example of this could be shown with only one task that has an asynchronous task and the other tasks patiently waiting for this async task to finish:

```js
new Promise(function(resolve, reject) {

  setTimeout(() => resolve(1), 1000); // (*)

}).then(function(result) { // (**)

  alert(result); // 1
  return result * 2;

}).then(function(result) { // (***)

  alert(result); // 2
  return result * 2;

}).then(function(result) {

  alert(result); // 4
  return result * 2;

});
```

The task labelled `(*)` is the async task as it takes `1` second to complete and no other task below it will execute until this task is finished, the flag here is that they are waiting for `resolve` or `reject`. 

One common pitfall is to pass the value from `resolve` to an entirely different Promise, meaning we cannot propagate the output to any other Promise, leading to the recent Promise below to return `1`

```js
let promise = new Promise(function(resolve, reject) {
  setTimeout(() => resolve(1), 1000);
});

promise.then(function(result) {
  alert(result); // 1
  return result * 2;
});

promise.then(function(result) {
  alert(result); // 1
  return result * 2;
});
```

Let's look at an example of actually using Promises in a real-world context, given that we have a `loadScript` function that returns a Promise and loads scripts, we want to load in three scripts `one`, `two` and `three` where they all depend on each other, we must use chaining in order to load these scripts and catch any errors in a clean way:

```js
loadScript("/article/promise-chaining/one.js")
  .then(function(script) {
    return loadScript("/article/promise-chaining/two.js");
  })
  .then(function(script) {
    return loadScript("/article/promise-chaining/three.js");
  })
  .then(function(script) {
    // use functions declared in scripts
    // to show that they indeed loaded
    one();
    two();
    three();
  })
  .catch(function(err) {
	  console.error("Script failed to load": err);
  });
```



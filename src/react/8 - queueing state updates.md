When React finds that it is in a new state, it will re-render, meaning a button click will not always re-render if there is no function tied to that button that would lead to a change of state, like a state variable incrementing by `1`, the actual cause of triggering a re-render is when the state setter function is called, but it is important to note that two calls of a state setter function will lead to still only one re-render and will not immediately re-render.

When React re-renders a component:
1. React calls your function again.
2. Your function returns a new JSX snapshot.
3. React then updates the screen to match the snapshot your function returned.

Dealing with state variable setters can be done easily if we substitute our variable value for all instances, since the variable will not change after our main function is done.
### batching
Calling our state setter function multiple times for different state variables will all lead to only one re-render, this is called batching, allowing us to queue a series of state updates and all lead to one re-render as the full function call of our main component hasn't ended, meaning there is no re-rendering yet. 
### updater function
A single state variable that needs to be updated multiple times cannot be done by doing `setIndex(index + 1)` repeatedly, instead we can pass a function which will force our state setter function to use its most updated value of `index` instead, allowing us to repeatedly call `setIndex`:
```jsx
setIndex(index => index + 1);
setIndex(index => index + 1);
setIndex(index => index + 1);
```

`index` will be using its previous value if we pass in a function, the parenthesis of `index` is omitted. The function `index => index + 1` is known as a updater function and will process the function calls as FIFO.

We are also allowed to merge normal assignments with these updater functions:
```jsx
index = 0
setIndex(index + 5);
setIndex(index => index + 5);
```
This would make `index=10` meaning both function calls of `setIndex` are successful.

An example that would really make this more clear is the following:
```jsx
// index = 0
setIndex(index + 5);
setIndex(index => index + 10);
setIndex(index + 100);
```
This would output `100`, the flow works like this: `index` is `0` and is added on by `5`, then the updater function will take the most recent value it has, which is `5` and add `10` to make `15`, React batches all three updates but only the second call uses the latest result of a previous queued update, the most recent value it has stored is `15`, when we do `index + 100` we are using the stale version of `index` not the updated one so we do not care about the most recent value, so we take the value that is still rendered which is `0` and do `0 + 100` leaving `index` to be `100`.




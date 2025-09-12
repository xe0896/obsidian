Components often need to change what’s on the screen as a result of an interaction. Typing into the form should update the input field, clicking “next” on an image carousel should change which image is displayed, clicking “buy” should put a product in the shopping cart. Components need to “remember” things: the current input value, the current image, the shopping cart. In React, this kind of component-specific memory is called _state_.

A simple mind may think that variables are enough to keep this track of states but there are two main reasons why variables are not enough:
- Local variables do not persist between renders
- An update to a local variable won't trigger a render

When we update a component, we must ensure two things happen:
- Retain the data between renders
- Trigger React to render the component with new data

A `useState` hook offers both of these things, it will provide a variable that will always retain data in between renders, and a state setter function that we can update our variable and make sure React re-renders.

To add this state variable we must first import `useState`:
```jsx
import { useState } from 'react';
```

Then we can replace our variables with `const [variable, setVariable] = useState(0)`, the `variable` is our variable that we want to maintain our state and `setVariable` is our setter function for our `variable`.

Note that the `0` in `useState(0)` is the default value, and is the most common default value.

We use `[ ... ]` because `useState(0)` returns an array, and we are using array destructuring to assign:
- the **first value** to `index`
- the **second value** to `setIndex`

Now if we had a `variable` named `index` and we want to navigate through pages given that `index` is a key for some information, instead of assigning `index` normally and creating our setter function like:
```jsx
let index = 0;
function handleClick() {
	index = index + 1;
}
```

Given that this will not persist through renders and wont trigger any renders when being updated, we can use our `useState` component to create new variables which will persist through renders and update React:
```jsx
import { useState } from 'react';
const [index, setIndex] = useState(0);

function handleClick() {
	setIndex(index + 1);
}
```

We can now tie this to an `onClick` prop and it will update our `index` as expected.
### Hooks
`useState` shown above is a Hook, as all Hooks will begin with `use`, and all Hooks should be called at the top level of your components or your own Hooks. You cannot call Hooks inside conditions, loops, or other nested functions. Hooks are functions.

States are different to variables when it comes to them being private, if we had a global variable for a component, then that variable is global for all instances of that component, states are different as they are local for their component.

Another important note regarding states variables, we should only use state variables when we have an event which will manipulate a variable which then will mean the output will change, this will allow the state variable to do what a normal variable cannot which is re-render when a state variable changes. There are some scenarios where state variables are not appropriate, a simple example is when we have a function that changes a state variable and then expect a new value for the state variable from then on, this is not the case as the whole function will need to finish in order for a re-render which will make the state variable output its old value and always be one step behind. This is a very important topic that will be covered separately.

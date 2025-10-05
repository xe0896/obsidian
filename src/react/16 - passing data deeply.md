Normally, information is passed from a parent (ancestor) component down to its child component which could become verbose if there are several components to go through. Context allows parents to pass information to any component tree below it, no matter how deep it is without passing explicitly using props.

Passing props is normally fine, but depending on the structure it may become to verbose and inconvenient to manage, one easy way to see this is if we wanted to give information to a component that is very deep and the components that it needs to go through do not need the information, this will lead to components needing props just so it can pass it through down the tree, this is an example of "pipe drilling".

Context will allow us to essentially teleport data from the parent down to the component that needs that information without passing it as props and requiring the help from the intermediate components. 
### useContext
An example should make the use of `useContext` much more clear, let's say we had the following:

```jsx
<Box>
	<BoxBody>
		<BoxSection>
			<Text level = {3}>A</Text>
			<Text level = {3}>B</Text>
			<Text level = {3}>C</Text>
		</BoxSection>
	</BoxBody>
</Box>
```

Given that the `level` prop is required for the `Text` component, we could directly give it what `level` it is in, but we can see here that it is very verbose if there are a lot of `Text` components. Instead of this way, if the `Box` component at this position always wanted every `Text` component to have a `level` of `3`, we could just assign the `level` prop to `Box` so we didn't have to repeat the instances of `3` in the code:

```jsx
<Box level = {3}>
	<BoxBody>
		<BoxSection>
			<Text>A</Text>
			<Text>B</Text>
			<Text>C</Text>
		</BoxSection>
	</BoxBody>
</Box>
```

However, under the hood the intermediate nodes are passing the prop down to `Text`, leading to something like this:

```jsx
function Box({ level, children }) {
  return <BoxBody level={level}>{children}</BoxBody>;
}

function BoxBody({ level, children }) {
  return <BoxSection level={level}>{children}</BoxSection>;
}
```

This is why `useContext` is used to not require a prop passing down the tree to the component that actually needs the information, before we actually use the Hook we must create a context, which is in the form of a file like `LevelContext.js`. 

A standard context is usually:

```jsx
import { createContext } from 'react';
export const LevelContext = createContext(1);
```

The default value is given to `createContext` and is `1`, but it could be anything like an object. 

Now, we need to import `useContext` as well our `LevelContext.js`:

```jsx
import { useContext } from 'react';
import { LevelContext } from './LevelContext';
```

In our example, our `Text` component will take in a prop `level` under the hood, so now we must remove the prop in the `Text` component definition and instead read the value from the context we imported from `LevelContext`:

```jsx
export default function Text({ children }) {
	const level = useContext(LevelContext);
}
```

This is telling React that `useContext` wants to read the `LevelContext`, but this won't work yet as we need to ensure it reads the correct `level` as currently it will just take in the level of `1` as it was the initial value, we need to provide context properly.

In our `Box` component, it will render its children as normal by doing `{children}`, to provide some context we should provide it with `LevelContext` and wrap it around `{children}` to make it receive information:
```jsx
import { LevelContext } from './LevelContext';

export default function Box({ level, children }) {
  return (
    <section>
      <LevelContext value={level}>
        {children}
      </LevelContext>
    </section>
  );
}
```


We could also import `useContext` and assign `level` like we done last time but inside `Box` if we wanted the value of `level` from the previous `level` value assigned to the previous `Box` **if** they was nested, this is helpful if we wanted a nested `Box` structure where the `level` increases by `1`:

```jsx
import { useContext } from 'react';
import { LevelContext } from './LevelContext';

export default function Box({ children }) {
  const level = useContext(LevelContext);
  return (
    <section className="section">
      <LevelContext value={level + 1}>
        {children}
      </LevelContext>
    </section>
  );
}
```

Making able to just call `Box` without specifying the `level` and it receiving a higher `level` depending how nested a `Box` is.
### Context and Reducers
The use of context and reducers in conjunction is just re-using a pattern which is normally in the form:
- `useContext` is used to access information that has been created by `createContext`, so we should import be importing our `createContext` file a lot.
- Aim to make the `dispatch` function in context so that we can make certain modules read it from our `createContext` file and be able to change states
- Try to make our `createContext` file just not store `createContext`'s, instead we should include our reducer function meaning we should also create our reducer using `useReducer` in it.








A common misconception regarding states, is that a state lives inside a component and this isn't the case and the state actually is managed by React. If we was to assign a component to something we can reference like a `const` or `let` then we can call this many times and create multiple states from just a single component.

If we was to remove the state by not rendering it then if re-rendered it will start from scratch, the key point here is that React preserves a component’s state for as long as it’s being rendered at its position in the UI tree.

When we have something like a ternary operator that is making a call of a component conditional, as they are both in the same position in terms of the virtual DOM (`App->div->Component`) then they are considered the same component meaning the state won't be reset.
### Different components at same position reset state
If we was calling a component that has been replaced by another different component like a `<p>` tag, then the state of the component that has just been replaced has been reset:

```jsx
return (
	<div>
		{isPaused ? (
			<p>Paused.</p>
		) : (
			<Component />
		)}
	</div>
)
```

Whatever state that `<Component />` had will be lost if `isPaused=true`, meaning we must be take this into consideration as we may of lost a state like this and we wasn't sure why, in virtual DOM language: `div->Component` has been replaced with `div->p` meaning React has thrown away the data tied to `Component`.

To show the relevance of the virtual DOM, if the `div` tag in the virtual DOM was to be replaced by a tag like `<section>` but the component inside both are the same, then it is considered different and the state will reset when switching between the two same components:

```jsx
return (
	<div>
		{isPaused ? (
			<div>
				<Component />
			</div>
		) : (
			<section>
				<Component />
			</section>
		)} 
	</div>
)
```

Sometimes we do want a state reset and we can do this in two ways, one way is to simply just give a `key` prop which is a special prop that React understands as a different component and to treat this component as a different component, the other way is to render them in different positions, more precisely to destroy the component then replace it after, we can do this using booleans:

```jsx
{isPlayerA && <Counter person="Taylor" />}   // now false, removed
{!isPlayerA && <Counter person="Sarah" />}  // now true, renders
```




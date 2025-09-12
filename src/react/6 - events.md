Events are relied on a event handler, functions that respond to an event, this can be simple like a button being pressed and the event handler making an alert saying 'A button has been pressed':
```jsx
function handleClick() {
	alert("A button has been pressed");
}
```

The event handler can be triggered by creating a button using a `<button>` tag, which takes in a callback function as a prop which will be our event handler `handleClick`, the name of this prop is `onClick` and we can assign it to our event handler by doing `onClick = {handleClick}` as we are pointing to our function and not calling it ourselves, React will call it when the event is done rather then immediately.
```jsx
export default function Button() {
	return (
		<button onClick={handleClick}>
			Click
		</button>
	);
}
```

This is a much more verbose way of doing this, we can make an in-line arrow function to define our `handleClick` logic inside the `onClick` prop:
```jsx
export default function Interactivity() {
	return (
		<button onClick ={() => {
			alert("A button has been pressed");
		}}> Click </button>
	);
}
```
### event propagation 
The `onClick` prop can be used in other components, not just `<button>`, one common example of this is the `<div>` tag, if we specify an `onClick` prop with all the event handler functions we can make the whole `<div>` act as a button which can also overlap with other buttons, given that the buttons are children of the `<div>`, this will also mean that once we press the actual buttons, the `<div>` event handler will trigger as they overlap, this is known as event propagation, and the code has this *error*:
```jsx
export default function Interactivity() {
	return (
		<div className = 'NavBar' onClick={() => {
			alert("This is the navigation bar");
		}}>
		<button onClick={() => {
			alert("Home");
		}}>
			Home
		</button>
		
		<button onClick={() => {
			alert("About");
		}}>
			About
		</button>
		
		</div>
	);		
}
```
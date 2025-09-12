A button can be simply created via the `<button>` tag, it is a native HTML tag but React has added some event handlers that we can use:

| Prop                            | Description                            |
| ------------------------------- | -------------------------------------- |
| `onClick`                       | Function to run when button is clicked |
| `onMouseEnter` / `onMouseLeave` | Mouse hover events                     |
| `onFocus` / `onBlur`            | Focus/blur events                      |
| `onKeyDown` / `onKeyUp`         | Keyboard events                        |
| `onPointerDown` / `onPointerUp` | Pointer input events                   |
A lot of these are not required. but building large projects may require a special interaction between the user and the button, the main one is `onClick`. A common way to define the function of `onClick` is to use an arrow function:
```jsx
<button onClick ={() => 
	alert("CLICKED");
}>
	Click me!
</button>
```

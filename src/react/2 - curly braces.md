In JSX, curly braces `{}` let you insert JavaScript variables or expressions into the HTML-like code, so your website can show dynamic content, the following shows us using a static link:
```jsx
export default function ProfilePicture() {
	return (
		<img
			className = "profilePic"
			src = "https://i.imgur.com/7vQD0fPs.jpg"
			alt = "Random man"
		/>
	);
}
```

By using curly braces we can store our links and referrals to variables and then refer to the variables using curly braces:
```jsx
export default function ProfilePicture() {
	const profilePict = 'https://i.imgur.com/7vQD0fPs.jpg';
	const alternative = 'Random man';
	return (
		<img 
			className = "profilePic"
			src = {profilePict}
			alt = {alternative}
		/>
	);
}
```

We could also use curly braces to embed some calculated content into our JSX tags:
```jsx
export default function List() {
	const name = 'Dave';
	return (
		<h1>{name}'s List</h1>
	)
}
```

Another useful feature that can be used with curly braces is that we can create a function using pure JS and then call it and add it as content by calling it within curly braces so it is showcased.
### double curly
Objects in JavaScript are wrapped around curly braces by default, meaning if we wanted to pass objects in JSX we use another set of curly braces which means an object will be wrapped by two curly braces.
```jsx
export default function Bullet() {
	return (
		<ul style = {
			{ backgroundColor: 'red', color: 'pink'}
		}>
			<li>NumberOne</li>
			<li>NumberTwo</li>
		</ul>
	);
}
```
We can see above that our inline style is different to how HTML utilises inline, instead of using dashes we use camel casing, an easy way to see the difference is to view the HTML way of styling the above:
```html
<ul style = "background-color: black">
```
Objects can be created via JS then referred to using `.` notation, we can also access styling depending on an object. In this example, the `person` JavaScript object contains a name, string and a `theme` object:

```jsx
const person = {
	name: 'Gregorio Y. Zara',
	theme: {
		backgroundColor: 'black',
		color: 'pink'
	}
};
```

The component can use these values from `person` like so:
```jsx
<div style={person.theme}>
	<h1>{person.name}'s Todos</h1>
```
### more clarification regarding curly braces in functions
A function can either be in the form `foo({a,b,c..})` or `foo(a)` where the first form is the function destructuring our parameters and allowing us to access them instantly by calling `a` or `b` whether they are integers or objects, they must be handled appropriately. The other form has no curly braces and cannot be extended into something like `foo(a,b,c..)`, it can only accept one parameter if there are no curly braces, this will make an object storing all our parameters for us, if we had props such as `name` and `age` then we can access them by using `a` by doing `a.name` or `a.age`

When we call these two types of functions they can be both called the same, they both do not expect every parameter to be defined as they parameters that are not defined are labelled as `undefined`.
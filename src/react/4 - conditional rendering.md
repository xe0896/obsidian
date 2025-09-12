We can make our React components display different things depending on certain conditions, we can do this by simply returning a different type of content based on a condition:
```jsx
function Task({isFinished, name}) {
	if(isFinished) {
		return (
			<li> {name} is finished </li>;
		);
	}
	return <li> {name} </li>;
}

export default function List() {
	return (
		<ul>
			<Task
				isFinished = {false}
				name = "Clean the floor"
			/>
			
			<Task
				isFinished = {true}
				name = "Jump off a building"
			/>
		</ul>
	);
}
```
Sometimes we do not want to return anything but we must return something, in this case we can just return `null`, allowing our task list to just only output items that have been finished. However, returning `null` is always not the best solution for this as it can make the code hard to debug, instead we can conditionally render JSX.
### ternary operator
A conditional expression can be written concisely using the ternary operator, which can transform this repetitive code:
```jsx
if(isFinished) {
	return <li className = "task">{name} is finished</li>;
}
<li className = "task">{name}</li>;
```
To:
```jsx
return (  
	<li className="item">  
		{isFinished ? name + 'is Finished' : name}  
	</li>  
);
```
Or we could use `&&` to render "is Finished" if `isFinished` is true by doing a conjunction between them:
```jsx
return (
	<li className = "item">
		{name} {isFinished && 'isFinished'}
	</li>
);
```
	
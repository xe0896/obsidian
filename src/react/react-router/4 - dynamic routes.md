Dynamic routing is when we have a dynamic component that is part of the URL, this could be in the form of an ID for a task, such as task 1 has the URL `https://website/task/1` where `1` is the dynamic component. 

The Hook that is widely used for this is called `useParams` which will return an object of all the dynamic components of the URL, as there could be many. If we had a URL `https://website/task/20/post/30` then there are two dynamic components: `20` and `30` which the `useParams` can grab by using `useParams`:
```jsx
import { useParams } from `react-router-dom`;

const { task, post } = useParams();
```

The values of `task` and `post` can be helpful as we can base an output depending on these values:
```jsx
<h1>Task is: {task}, coming from: {post}</h1>
```

The users can navigate to these links using the `<Link>` component, depending on these IDs we must adjust the `<Route>` component to accept dynamic URLs by using `:` to notify React Router that this part of the URL is dynamic and we will make our `<Link>` give access to URLs that exist depending on a given object and would also display the ID of the URL in our hyperlink:
#### DynamicRouting.js
```jsx
import { NavLink, Routes, Route } from 'react-router-dom';

import Task from './Task';
  
export default function DynamicRouting() {
	const tasks = [
	{id: 1, name: 'Task 1'},
	{id: 2, name: 'Task 2'}
	];
	return (
		<>
			<nav>
				{tasks.map(task => (
					<NavLink key = {task.id} to = {`/task/${task.id}`}>
				{task.name}
					</NavLink>
			))}
			</nav>
			<Routes>
				<Route path = "/task/:id" element = {<Task />} />
			</Routes>
		</>
	);
}
```
#### Task.js
```jsx
import { useParams } from 'react-router-dom';
  
export default function Task() {
	const { id } = useParams();
	  
	return (
		<h1>{id}</h1>
	);
}
```

We first import the relevant React Router components and also our `Task` component so that we can call it alongside with its ID at `<Route>`. Defining an array holding an object that holds what a general task would have, an ID and the name of it will allow us to use the `.map` function to iterate over the object and defining our links in `<NavLink>`. 

Specifying the key using `key = {task.id}` is recommended for optimisation purposes for `.map`, we also can see that we have curly braces after `to..` in `<NavLink>` and that is because `/task/${task.id}` is still considered a string if we do not encase it with curly braces, to notify React that this is in JS mode, allowing concatenations with strings to make our link, we also specify the name of the task using `task.name` to make the link emulate what task it will bring the user to.

In `Task.js` the `useParams` as stated before just takes all the dynamic components of the URL and as specified in `<Routes>` would be only one, the `id`. By destructuring the object we can get the id instantly and use it for our task.

It is important to note that this type of code depends on the implementation of your earlier routes if you have one, such as in `App.js` to navigate to our `DynamicRouting` component as it may cause stacking if you do not specify that our paths can have extensions, we can do this by doing `/*`.

When we have a list of items that we want to display, we could display it using`<li>` tags:
```jsx
<ul>
	<li>Task 1</li>
	<li>Task 2</li>
	<li>Task 3</li>
</ul>
```

However, this can be seen as repetitive since if we wanted multiple instances of this list, then we would have to copy and paste this again and again, we could instead store this into an array instead and iterate it over each time and create a function that we can call whenever we want an instance of our list, we can do this using a `.map` function to iterate over an array and we can use arrow functions to concisely do this:
```jsx
const Tasks = [
	'Task 1',
	'Task 2',
	'Task 3'
];

export default function List() {
	const listTasks = Tasks.map(Task =>
		<li>{Task}</li>
	);
	return <ul>{listsTasks}</ul>;
}
```

`Tasks` may have some priorities, meaning we can make our array store objects which contain the task and its priority. The `.filter` method can filter out our array to only output tasks that have priority of `1`:
```jsx
const Tasks = [{
	priority: 0,
	name: 'Task 1'
}, {
	priority: 0,
	name: 'Task 2'
}, {
	priority: 1,
	name: 'Task 3'
}];

export default function ListPriorityOne() {
	const priorityOne = Tasks.filter(task =>
		task.priority === 1;
	);
	
	const ListTasksPriorityOne = priorityOne.map(task => 
		<li>{task.name}</li>
	);
	
	return <ul>{ListTasksPriorityOne}</ul>;
}
```

Adding `key={index}` helps React track list items, especially in real apps with dynamic updates meaning we must add this to our iteration, we add this onto our opening `<li>` tag  and we use the the `index` as it is a unique property given by the `.map` so we must add an `index` parameter along side `task`:
```jsx
const ListTasksPriorityOne = priorityOne.map((task, index) => 
    <li key={index}>{task.name}</li>
);
```
You might be tempted to use an item’s index in the array as its key. In fact, that’s what React will use if you don’t specify a `key` at all. But the order in which you render items will change over time if an item is inserted, deleted, or if the array gets reordered. Index as a key often leads to subtle and confusing bugs.
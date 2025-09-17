Similar to how objects behave, if we have an array state and we want to update it, then we must create a new array and pass this to our state setter function. This means that we shouldn't mutate our array by using operations such as `.push` or `.pop` and use operations that return a new array like `filter` and `.map`, if we do need to use operations that mutate our array then we should use Immer.

Given that we cannot mutate our array and use operations like `.push`, we must rely on using spread syntax `...` to copy our array elements and add an extra piece of information that we want:
```jsx
let nextId = 0;

export default function List() {
	const [item, setItem] = useState('');
	const [list, setList] = useState([]);
	
	return (
		<>
			<input value = {item} onChange = {e => setItem(e.target.value)}/>
			
			<button onClick = {() => {
				setList([...list, {id: nextId++, item: item}]);
			}}>
				Add item
			</button>
			<h1>Items</h1>
			
			<ul>
				{list.map(item => 
					<li key = {item.id}>{item.item}</li>
				)}
			</ul>
		</>
	);
}
```
We can see here that when we was using our state setter function `setList` for a new array, we done `...list` to ensure all other contents are here with our array and also this new value `item` that we have as a state variable which will always trace what is inside our input box due to `setItem` being tied to `e.target.value`.
### Transforming
Instead of wanting to append an array like shown above, we may want to transform some items inside our array, and to do this we can use the `.map` function that can iterate over our array and transform items depending on a condition:
```jsx
export default function Transforming() {
	const [numbers, setNumbers] = useState([
		{id: 0, value: 10},
		{id: 1, value: 20},
		{id: 2, value: 30}
	]);
	
	function handleClick() {
		const newNumbers = numbers.map(number => ({
			...number,
			value: number.value * 2
		}));
		
		setNumbers(newNumbers);
	}
	
	return (
		<>
			<h1>Numbers</h1>
			<button onClick = {handleClick}> +1 </button>
			{numbers.map(num => (
				<p key = {num.id}>{num.value}</p>
			))}
		</>
	);
}
```
### Other changes
When doing an operation that cannot be expressed using the `...` syntax, we normally we just apply that operation like `.reverse` onto a copied array of our current then set that using the state setter function:
```jsx
function handleClick() {
	const nextList = [...list];
	nextList.reverse();
	setList(nextList);
}
```

However, it is important to note that we cannot mutate a copied array and set this using our state setter function expecting a shortcut on changing our array, this is because they both will point to the same object meaning a mutation is happening regardless of how it seems.
### Updating objects inside arrays
Given that we have a component that outputs an array, if we was to call this component twice, giving us two instances of this array then the following code:
```jsx
const myNextList = [...myList];  
const artwork = myNextList.find(a => a.id === artworkId);  
artwork.seen = nextSeen; // Problem: mutates an existing item  
setMyList(myNextList);
```
Will make both our instances share the same value for `.seen`, to avoid this we should not be mutating our array that is being done from `artwork.seen = nextSeen`, instead we should `.map` over our array and making us check to see if the current array we have iterated and obtained is equal to our `id`, this is shown here:
```jsx
setMyList(myList.map(artwork => {  
if (artwork.id === artworkId) {  
	// Create a *new* object with changes  
	return { ...artwork, seen: nextSeen };  
} else {  
	// No changes  
return artwork;  
}  
}));
```

However, if we was using Immer then we could mutate in the form `artwork.seen = nextSeen` freely as we are not actually mutating the original state, but a special `draft` object given by Immer, we could also use `.push` and `.pop` on our `draft` object:
```jsx
updateMyTodos(draft => {  
	const artwork = draft.find(a => a.id === artworkId);  
	artwork.seen = nextSeen;  
});
```


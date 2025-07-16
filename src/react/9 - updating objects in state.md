Objects that technically mutable, as we can change what value it holds but React wont treat this as a state change and won't re-render, so the only way we can go forward is to replace the object as a whole to force a re-render. Whenever we declare our state variable when it is an object, the `useState(param)` should have its `param` as the default object, not `0`: 
```jsx
const [user, setUser] = useState({
	name: 'Default man',
	age: '0',
	email: 'xen@gmail.com'
});
```

If the `user` object needs to be updated, we must create a new object with the updated values. When only one field has changed, we can pass a function to the state updater to access the previous state, and then merge it with the new value. This ensures we only need to specify the field(s) we want to update:
```jsx
setUser({
	name: 'Man',
	age: '100',
	email: 'email@gmail.com'
});

// If only email has changed:
setUser(prevState => ({
	...prevState,
	email: 'email@gmail.com'
}});
```

An important thing to note about `...` is that it will only clone the top level properties, meaning if we was to change a value of a nested object then that nested object should also specify `...`, for example if we had a `person` object that has another object `house` nested in it:
```jsx
person = {
	name: 'John',
	house: {
		price: 100000,
		location: 'London',
	}
};
```

Then if we was to update `price` then we should specify `...person.house` as the `house` object will receive the default treatment of being  `undefined`, if we was to update only the `name` then we just have to specify `...person` instead of `...person.house`:
```jsx
setPerson({
	...person,
	house: {
		...person.house,
		city: `Japan`,
	}
});
```

If we was able to change every property of an object, then it could be tedious as we will have to specify a function for every different property being changed, like this:
```jsx
function handleLastNameChange(e) {
    setPerson({
      ...person,
      lastName: e.target.value
	});
}

function handleEmailChange(e) {
	setPerson({
	...person,
      email: e.target.value
	});
}
```

Instead, we can use square brackets to specify a dynamic name being altered for a given `e.target.value`, we can simply add a `name` prop to our input box and access that name using our event object `e` by doing `e.target.name` which give us the name of our prop directly if the name matches with the property, allowing us to only specifying one function:
```js
function handleChange(e) {
	setPerson({
		...person,
		[e.target.name]: e.target.value
	});
}
...
return (
<>
	<label>
		First name:
		<input
			name="firstName"
			value={person.firstName}
			onChange={handleChange}
		/>
	</label>
);
```
### Immer
If we had a state that is deeply nested, then we can use Immer to update everything instead of duplicating our logic for our different attributes in our nested objects, to use Immer we must import it by doing `npm install use-immer` and replace our instances of `useState` of it:
```jsx
import { useImmer } from 'use-immer';

export default function Form() {
  const [person, updatePerson] = useImmer({
    name: 'Niki de Saint Phalle',
    artwork: {
      title: 'Blue Nana',
      city: 'Hamburg',
      image: 'https://i.imgur.com/Sd1AgUOm.jpg',
    }
  });
  ...
```
Immer allows us to directly change the value that needs changing and not need to worry about preserving the state of the other attributes which would look like this:
```jsx
setPerson({
	...person,
	address: {
		...person.address,
		city: 'London'
	}
});
```
Allowing us by using Immer to do something like this instead:
```jsx
updatePerson(draft => {
	draft.address.city = 'London';
});
```

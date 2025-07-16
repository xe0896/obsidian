An interaction between a UI element like a button or input box and the user can have some valuable information such the exact button that was clicked, or if the shift button was held while pressing this button, we can gather all types of information if we consider our event handling.

Given that we have a two text boxes that want us to display our first and second name, we can ensure that whatever is typed onto the text box, is treated as a value for our `person` object and updates accordingly.
```jsx
export default function Form() {
	const [person, setPerson] = useState({
		firstName: 'John',
		secondName: 'Cena'
	});
	
	function handleFirstNameChange(e) {
		setPerson({
			...person,
			firstName: e.target.value
		});
	}
	
	function handleSecondNameChange(e) {
		setPerson({
			...person,
			secondName: e.target.value
		});
	}
	
	return (
		<label>
			<input 
				onChange = {handleFirstNameChange}
				value = {person.firstName}
			/>
			<input
				onChange = {handleSecondNameChange}
				value = {person.secondName}
			/>
		</label>
	);
}
```

The main point of this is looking how the event object `e` works, we can see that `onChange` takes in a prop function reference that will create a parameter `e` that we can work with, this will allow us to gather information on the event that just occurred, which in this case is the event of a text box being populated, allowing us to access what value the text box is holding so that we can assign this to first or last name. 

Properties that we can grab with our event object are specified on the `<input>` tag, such as `value` and `name` (if it was there). 



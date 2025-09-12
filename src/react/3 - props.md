Props are the information that we pass into a JSX tag such as `className` or `width`, these props are predefined but we can create our own props that can manipulate the tag in their special way.

When we want to output a repeated item, we can make a function that can specify the template and be given parameters to output the viewed item as many times it is called.

Given that we have two props `person` and `size` where `person` is an object and `size` is an integer, we can allow these props to be used by using a function such as `profile` which will return what we want, in this case we would want an profile picture-like image with custom modifications:
```jsx
const person = {
  name: 'Random man',
  imageId: '7vQD0fP',
  imageSize: 's',
};

const baseUrl = 'https://i.imgur.com/';

function profilePic({person, size}) {
	return (
		<img
			className = "avatar",
			src = {baseUrl + person.imageId + person.imageSize + '.jpg'}
			alt = {person.name}
			width = {size}
			height = {size}
		/>
	);
}
```

`profile` is now a defined function, all we need now is to call this function with props as parameters:
```jsx
export default function Profile() {
  return (
    <div>
      <profilePic
        size={100}
        person={{ 
          name: 'Katsuko Saruhashi', 
          imageId: 'YfeOqp2'
        }}
      />
      <profilePic
        size={80}
        person={{
          name: 'Aklilu Lemma', 
          imageId: 'OKS67lh'
        }}
      />
      <profilePic
        size={50}
        person={{ 
          name: 'Lin Lanying',
          imageId: '1bX5QH6'
        }}
      />
    </div>
  );
}
```

A function's parameters are only one object that will be restructured later into different parameters but we can pass one object, the `props` object which then we can access the `props` properties to access the props that was given:
```jsx
function profilePic(props) {
	let person = props.person;
	let size = props.size;
	// ...}
}
```

React components will always get called with one argument, so we will never see something in the form `foo(a,b)`.

If a prop is not defined when it is called we can assign a default value by specifying the value after the parameter:
```jsx
function profilePic({ person, size = 1000 }) {  
	// ...  
}
```

When specifying our props, it can be seen as repetitive so when we have some data we want to output in a specific way, we can store this in an object like `props` then pass this into the function:
```jsx
function Profile(props) {
	return (
		<div className = "card">
			<profilePic {...props} />
		</div>
	);
}
```
The `...` is important as it will spread out the object properties as parameters since props must be spread out as key value pairs to be used in functions, this is mainly used when we have a child and parent relationship and we want the child to have all the props given to the parent, if there are some that we do not need to pass then we cannot use `...` and use selective passing instead.

The tags that we are using such as `<profilePic>` can be nested with other pre/in-built tags to make them affected by their parents modifications, such as:
```jsx
<outer>
	<profilePic />
</outer>
```
We can make the `<outer>` tag to have some modifications like a CSS change by specifying a class such as `card` and then make it apply this to a given `children` object that would be basically our `<profilePic>` tag:
```jsx
function Card({ children }) {
  return (
    <div className="card">
      {children}
    </div>
  );
}

export default function Profile() {
  return (
    <outer>
      <profilePic
        size={100}
        person={{ 
          name: 'Katsuko Saruhashi',
          imageId: 'YfeOqp2'
        }}
      />
    </outer>
  );
}
```

Props can change state overtime depending on conditions set by the developer, but we must not "change" it forcefully, we should set a new state which is something to cover later.

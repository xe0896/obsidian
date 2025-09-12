React Router uses three main components for basic routing:
- `<Routes>`: A container of all our routes
- `<Link>`: Creates the navigation URLs that will change the current URL
- `<Route>`: Defines a mapping between a URL and a component

```jsx
function App() {
	return (
		<nav>
			<Link to="/">Home</Link>
			<Link to ="/about">About</Link>
		</nav>
		
		<Routes>
			<Route path = "/" element={<Home/>} />
			<Route path = "/about" element={<About/>} />
		</Routes>
	);
}
```

`<Routes>` is a wrapper that looks at the current URL and matches it to one of its child `<Route>` elements.  
The matching `<Route>` then renders the component you’ve specified using the `element` prop, like `<Home />`, `<About />`, etc.

The `<Home>` and `<About>` tags are JS functions/components that should be imported so that we can render it when the user presses "Home" or "About" on the `<Link>` tags:
```jsx
import Home from "./Home";
import About from "./About";
```

These components should be `export default function`'s, allowing us to render them on screen.

`<Link>` components can be located inside a navigation bar using `<nav>`, allowing navigations between different routes, it will tell the `<Routes>` tag which `<Route>` should be applied.

There is an extension to `<Link>` and that is `<NavLink>` which only has one difference, and that is that `<NavLink>` allows us to see what link is currently active by providing us with some special functions that we can use as props. One of the props that it provides is the `className` prop which is different to our usual instance of `className` as it is also a function that can be used and has access to a boolean value called `isActive` which tells us if this current link is active or not, we can use an arrow function after grabbing this `isActive` to conditionally apply a style:
```jsx
import { NavLink } from "react-router-dom";

<NavBar to="/Home" className={({isActive)} => (
	isActive ? 'active' : '' )}
>
	Home
</NavBar>
```
The class `active` can now be used to manipulate the text of our link whenever it is active, the empty string class implies that there is no class belonging to this link meaning it will not be styled as active and be treated as a normal tag, more precisely the `a` tag.






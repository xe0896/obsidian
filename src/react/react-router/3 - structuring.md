A simple program will be made here to show how a typical website would use React Router to navigate between different files, the easy part is understanding how each tag of React Router works such as `<Link>` and `<Route>` works, the main problem is how we will structure it:

As mentioned in [[1 - starting react router]] we will wrap our entire `<App>` with `<BrowserRouter>` allowing us to begin the navigation logic. To allow us to have navigation between different files it is best to create a navigation bar, a navigation bar can just have our `<Link>` component since that is the component that gives the user a choice on what file they want to navigate to. Creating a separate component for our navigation will improve our modularity in code, we will call it `<NavBar`>

`<NavBar>` will just return a `<nav>` component which contains our links to different files, since it is the starting point we can allow our `App.js` to handle the routing and in [[2 - routes and links]] we can see that `<Routes>` and `<Route>` will need an import of our file meaning `<NavBar>` does not require any imports, just `<Link>`.
```jsx
import { Link } from "react-router-dom"

function NavBar() {
	return (
		<nav>
			<Link to="/">Home</Link>|{" "} <!-- Creates a space inbetween -->
			<Link to="/about">About</Link>
		</nav>
	);
}

export default NavBar;
```

`App.js` will contain our file imports and the routing as well as calling our `<NavBar>` and the `<NavBar>` will always be rendered since the `<Routes>` will change what is being rendered underneath our `<NavBar>` given that we call our `<NavBar>` at the top:
```jsx
import { Home } from "./Home";
import { About } from "./About";
import { NavBar } from "./NavBar";

import { Routes, Route } from "react-router-dom";

export default function App() {
	return (
		<div>
			</NavBar>
			
			<Routes>
				<Route path="/" element={<Home/>} />
				<Route path="/about" element={<About/>} />
			</Routes>
		</div>
	);
}
```



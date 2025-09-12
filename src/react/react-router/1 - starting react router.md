Before starting on getting React Router to work, it is important to know what it is used for: React is known as a Single Page Application (SPA) meaning it works only on one HTML page, if we wanted to add more pages that we can navigate to we must use a separate library as React only handles the rendering of components, this library is React Router.

We can get React Router to start after we build our React project by doing something like `npm create-react-app my app`, this is so that we can get a template of a usual starting point of a React application. As mentioned before, as React Router is a library we must install it to our application, we can do this by doing `npm install react-router-dom` for websites or `npm install react-router-native` for mobile applications, we will stick with `dom`. 

Now that we have React Router in our application, we must import some important modules which we will build up, we will first import `BrowserRouter` which will set up our routing system and is essentially the navigation brain of the system, we will import this in `index.js` and wrap our whole `<App>` with `<BrowserRouter>`:
```js
import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./styles.css";

import { BrowserRouter } from "react-router-dom"
  
import App from "./App";
  
const root = createRoot(document.getElementById("root"));
root.render(
	<StrictMode>
		<BrowserRouter>
			<App />
		</BrowserRouter>
	</StrictMode>
);
```

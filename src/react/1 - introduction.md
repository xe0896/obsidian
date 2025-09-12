Before learning React, we must learn what language React uses and it uses a special language called JSX (JavaScript XML) which is basically JavaScript and HTML combined, meaning if you are proficient in HTMl and JavaScript then learning JSX should be trivial. 

Combining both HTML and JavaScript may be a bit unintuitive to some as it was always better for logic and content to be separated, however as web browsers become more interactive JavaScript was always in charge which caused JSX to exist to make it more easier to create websites to combine both logic and content.

We can also ensure that both logic and content being shown are in sync and have a connection rather then creating our own connection, this will heavily improve the speed of creating components in our website.
### components
A component (more precisely a React component) is a JavaScript function that may contain some markup (content) that React will render to the browser, these components use JSX to represent that markup. JSX is very similar to HTML but is not fully HTML as it has some stricter syntax and can display dynamic information rather then HTML sticking to static information.

A functional component created by JSX that is used by React would have a similar pattern:
```jsx
export default function func() {  
	return (  
		// ???  
	)  
}
```

| Part              | Explaination                                                     |
| ----------------- | ---------------------------------------------------------------- |
| `export default`  | Component is allowed to be imported else where                   |
| `function func()` | Defines the functional component                                 |
| `return {...}`    | Returns the JSX code, where React will render this to the screen |
The compilation process is as follows:
- You write JSX (looks like HTML inside JavaScript).
- JSX is compiled/transformed into JavaScript — mainly calls to `React.createElement()` or similar.  
    This creates **JS objects** that describe the UI.
- React uses those JS objects (the Virtual DOM) to figure out what the UI should look like. 
- React updates the real DOM (HTML) in the browser to match the Virtual DOM.
### rules of JSX
There are some rules in order to translate HTML to JSX given that there is no JavaScript logic yet.
#### 1. Return a single root element
To return multiple elements from a component, we must wrap them into a single parent tag, we can use `<div>` or `<>`, the difference between these two is that if we use `<>` we will not be polluting the HTML tree.
#### 2. Close all tags
A few HTML tags do not have to be closed with its closing tags such as `<img>` or `<br>` but in JSX, every single tag will need to be closed in order for it to be understood by JS.
### 3. camelCase for most things
Since JS does not understand dashes in contents such as `variable-name` we should stick to camel case by converting the content to `variableName`, some contents are used by JS such as `class` so we use `className` instead.

There are many uses for the `input` tag, it has many different types, which can be called with the prop `type`:

| Input Type | Purpose                           |
| ---------- | --------------------------------- |
| `text`     | Typing text into a box            |
| `checkbox` | Selecting true/false option       |
| `radio`    | Selecting one option from a group |
| `password` | Typing hidden characters          |
| `email`    | Typing email addresses            |
| `number`   | Typing numeric input              |
We would usually wrap our `<input>` tags with a `<label>` tag to make it readable by screen readers to notify users that may have some impairments on what the inputs are:
```jsx
<label>
	<input type = "text">Enter your name</label>
	<input type = "password">Enter your password</label>
	<input type = "number">Enter your age</label>
</label>
```

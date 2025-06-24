The following are about interaction with the user, which is important for browsers.
### alert
This will output a modal window, which is a window that will block the user from interacting with the application until the window is closed.
```javascript
alert("Hello");
```
### prompt
The following will show a modal window that will have a input box as well as a default answer, in this case our default answer is `John Doe`. 

**An important note:** In specifications, that tell us the different functions available that we could use, in this case a specification would be: `result = prompt(title, [default])`, a parameter that is in square brackets imply that this is optional, so in this case, `John Doe` is not a required parameter.
```javascript
let name = prompt("What is your name?", "John Doe");
```
### confirm
The following will show a modal window that will ask a question and will give two options to the user: `Ok` or `Cancel`, if the user picks `Ok` then it will store `true` on the variable, or else it will store `false`:
```javascript
let old = confirm("Are you old");
alert(old); // Outputs true or false depending on what is chosen above
```

All of these are very simple and an easy solution for interaction with the user, but is very limited and is restricted to how the browser designed the modal window locations and designs.

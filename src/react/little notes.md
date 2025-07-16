- `<StrictMode>` will render components twice to catch bugs
- React will always re-render when something changes, meaning we shouldn't change stuff in the `return` statement as it will keep on adding the stuff we are changing
### Pathing
|Path|Meaning|
|---|---|
|`./`|Current directory|
|`../`|Parent directory (go up one level)|
|`../../`|Go up **two** levels|
- Arrow function parenthesis that follow after `=>` can either be `(` to show that there is only one line, we could omit this entirely. If there are multiple lines, then we use curly braces as multiple lines will only mean we have some calculations before we `return` meaning we also need to include a separate `return `statement inside the curly braces.

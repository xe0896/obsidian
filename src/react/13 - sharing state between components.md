Sometimes, you want the state of two components to always change together. To do it, remove state from both of them, move it to their closest common parent, and then pass it down to them via props. This is known as lifting state up, and it’s one of the most common things you will do writing React code.

The more defined steps of "lifting their state up":
1. Remove state from the child components.
2. Pass hardcoded data from the common parent.
3. Add state to the common parent and pass it down together with the event handlers.

In other words, to make our state variables in sync, we must give the state variable to the common parent between `2` or more of the components that want to share this variable and pass this down to each of them via props so that they can stay in sync when modifying, an easy way to see this seeing this in action:

```jsx
import { useState } from "react";
import { foods, filterItems } from "./data.js";

export default function FilterableList() {
  const [query, setQuery] = useState("");

  return (
    <>
      <SearchBar onChange={(e) => setQuery(e.target.value)} query={query} />
      <hr />
      <List items={foods} query={query} />
    </>
  );
}

function SearchBar({ onChange, query }) {
  return (
    <label>
      Search: <input value={query} onChange={(e) => onChange(e)} />
    </label>
  );
}

function List({ items, query }) {
  const filteredItems = filterItems(items, query); // filterItems has been provided
  return (
    <table>
      <tbody>
        {filteredItems.map((food) => (
          <tr key={food.id}>
            <td>{food.name}</td>
            <td>{food.description}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}
```
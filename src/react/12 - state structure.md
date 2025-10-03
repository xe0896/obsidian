This will be a short chapter as it is mainly just about organising our state to be as concise as possible and not holding duplicated values.

We can usually spot duplicated state when we notice that two different state variables need to be updated together because they are pointing to the same underlying data. For example, imagine we give the user a set of options that change what a certain piece of text outputs. One state variable could store the array of all the options, and another state variable could store the option that the user has currently chosen.

The problem is that duplication can creep in here. If the selected option already exists inside the array, then we are essentially storing the same piece of information twice: once as part of the array (`items[i]`) and again as the “selected” state. If we then allow the user to edit the text of that chosen option, we would have to update both the array and the separate “selected” state to keep them in sync.

This is why the better approach is to keep only one source of truth. In this case, we could keep just the array and store an identifier like the `id` of the chosen item. Whenever we need the full object, we can look it up from the array using that `id`. This avoids duplication and prevents situations where the two states could drift out of sync.

An example of doing this would be something like this:

```jsx
const [items, setItems] = useState(initialItems);
const [selectedId, setSelectedId] = useState(0);

const selectedItem = items.find((item) => {
  return item.id === selectedId;
});
```

Instead of storing the user's chosen option to store the string of `items[i]` we can just make each option have an `id` which would change depending on what option they chose so we can grab the actual text from the array, meaning we can update the array and see those changes emulate in `selectedItem`.

The main idea here is that when we have two state variables that need to stay in sync, we should be careful about storing objects or arrays directly, since they are compared by reference rather than by value. This means even if two objects look identical, React will still treat them as different if they are separate instances. To avoid this problem, it’s safer to store a primitive identifier like an `id`. IDs are compared by value, so they remain stable even when the objects they point to are recreated.

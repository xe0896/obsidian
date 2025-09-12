The topmost tree nodes are available directly as `document` properties:
- `document.documentElement` = `<html>` 
- `document.body` = `<body>`
- `document.head` = `<head>`
There is a case where `document.body` = `null` due to the script processing before the `<body>` tag was created, more precisely when the script is at the `<head>` as the `<body>` goes below the `<head>`.
### children
It is important to distinguish between two related terms, children and descendents. Children are direct children, they are nested exactly in the given parent, descendents are nested in the given one, including children and so on.

We can view a collection of a parent's direct children by viewing the `childNode` collection, this will contain all the direct children, including text nodes.
```html
<html>
<body>
<div>Begin</div>
  
<ul>
<li>Information</li>
</ul>
  
<div>End</div>
  
<script>
for (let i = 0; i < document.body.childNodes.length; i++) {
alert( document.body.childNodes[i] ); // Text, DIV, Text, UL, ..., SCRIPT
}
</script>
...more stuff...
</body>
</html>
```
The script above will iterate over the `body`'s children, it will also not consider any items at "more stuff" since the script only can view what is going on above it.

There also exist `firstChild` and `lastChild` in the collection, allowing us to directly access them. We can also use `elem.hasChildNodes()` to see if any children exist for a given `elem`.
### DOM collections
`childNodes` can be viewed as an array but they are different, we cannot use array functions on `childNodes`, but we can still iterate it over like an array:
```javascript
for (let node of document.body.childNodes) {
	alert(node);
}
```
However, if we wanted to convert the collection into an array so we can use special array functions like `filter`, we can do this:
```javascript
alert(Array.from(document.body.childNodes).filter);
```
There are some important things to note about `childNodes`, one of which is that this collection is read only and we cannot assign values to it, another one is that it is live, meaning if something was to happen to the collection, it would change live, and lastly we should avoid using `for..in` to loop over the collection as it will output some meaningless properties such as `length`.
### siblings
Siblings are nodes that have the same parent, such as `<body>` and `<head>` are siblings and `<html>` is the parent. 

We can access next and previous siblings by using the property `nextSibling` and `previousSibling` respectively, we can also access the parentNode by using the property `parentNode`:
```html
<html>
<head>...</head><body>...</body>
</html>
```
```javascript
// parent of <body> is <html>
alert( document.body.parentNode === document.documentElement ); // true
// after <head> goes <body>
alert( document.head.nextSibling ); // HTMLBodyElement
// before <body> goes <head>
alert( document.body.previousSibling ); // HTMLHeadElement
```
### element-navigation
Most of the time we only want to navigate to nodes that are not comments or text, just element nodes so we can manipulate them, the element nodes follow this structure:
![[Pasted image 20250901161841.png]]
We can iterate over the `document.body` node and only accept elements by using the `children` node as it will only jump to the next element that is not a text node or a comment:
```html
<html>
<body>
<div>Begin</div>
  
<ul>
<li>Information</li>
</ul>
  
<div>End</div>
  
<script>
for (let elem of document.body.children) {
	alert(elem); // DIV, UL, DIV, SCRIPT
}
</script>
...
</body>
</html>
```

A HTML document will rely on its tags a lot since every HTML tag is an object. Nested tags are children of the enclosing one, even the text inside the tag is an object as well.

All these objects are accessible by JavaScript allowing them us to modify the page via JavaScript, for example if we wanted to modify the `<body>` tag then we can use `document.body` to change its background:
```javascript
document.body.style.background = 'blue';
```
Before going on about manipulating the DOM, we first need to know its structure.
![[Pasted image 20250829130537.png]]
The nodes shown above are commonly:
- `document`, entry point into DOM
- element nodes such as tags 
- text nodes
- comments
### autocorrection
Suppose we make a HTML file with only the contents "Hi", the DOM tree would autocorrect this by adding the necessary tags such as `<html>` and `<body>`, this will also works for other contents such as lists where each listed item has there own parent `li`.

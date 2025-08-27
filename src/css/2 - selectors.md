Selectors is what was covered on [[1 - anatomy]] and there are additional behaviours concerning them. Since they specify the scope of the style, we can also have a wildcard selector `*` which will apply the style to all elements:
```css
* {
	border: 1px solid red;
}
```
### Class
Instead of specifying the exact tag type or within a specific `<div>` tag, we can specify a class a tag is a part of and use that as an identification when styling. To do this, we first specify the class within the element opening tag by using `class = 'className'` and then in our CSS file we can use `.className {}` and change its appearance, note that we need to use `.` to notify that it is a class we are referring to.
HTML:
```html
<p class = 'title'>This is the title</p>
```
CSS:
```css
.title {
	color:red;
}
```
If an element was to be a part of two different classes then we can do this by including a space in between the two class names when we refer to it inside the element tag:
```html
<p class = 'title introduction'>This is the title and introduction</p>
```
### ID
In contrast to `class` which accepts multiple values, and can be used broadly throughout an HTML document, an element’s `id` can only have a single value, and only be used once per page:
```html
<h1 id = "large-title">Large title</h1>
```
When we want to refer to the ID on our CSS stylesheet we do this by using a hashtag rather than the `.` that the class uses:
```css
#large-title {
	font-family: Courier New
}
```
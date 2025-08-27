Creating a navigation bar will require some modification of the `<ul>` tag and its child `<li>` tag, using CSS we can make a list and change certain attribute such as `padding`, `margin` and also removing attribute such as `text-decoration` and `list-style-type`. 

The end result will be a simple navigation bar but an effective one, we first need to define some HTML content that the CSS can be applied to, and we will do this using `<ul>`:
```html
<ul>
	<li><a href = "./projects/">Projects</a></li>
	<li><a href = "./leet/">Leet</a></li>
	<li><a href = "./lang/">Languages</a></li>
</ul>
```
This allows us to manipulate `<li>` and `<a>` tags to emulate a navigation bar using CSS. 

When looking at how this list turns out we can see that the browser interferes with the appearance of the links, hyperlinks will turn blue for some browsers, it may be underlined, hyperlinks change colour when previously clicked on, we can remove all of this using CSS by manipulating the `<li>` and `<ul>` tags which poses a question, what is the difference between `<li>` and `<ul>` in CSS? The difference between is the two is that `<ul>` is like the box appearance that contains `<li>` items meaning if we wanted to change the appearance of the individual items.

Another way the browser is interfering with the appearance is by the default `padding` and `margin` values that are assigned where there are many values that can be used to manipulate an items location.

| Term        | Description                                                                  |
| ----------- | ---------------------------------------------------------------------------- |
| **Content** | The actual thing you're displaying (text, image, etc.)                       |
| **Padding** | The space **inside** the element, between the **content and the border**     |
| **Border**  | The edge or line around the element (if any is set)                          |
| **Margin**  | The space **outside** the element, between the **border and other elements** |
[![Visualizing CSS Margin and Padding For beginners | douiri](https://douiri.org/images/css/css-box-model.jpg)
Given that we are changing the appearance of the "box", we should be changing the `margin` and `padding` of `<ul>` to `0` and then we can change the `padding` of the individual items `<li>` to create some space in-between them and changing the `padding` of an individual item can be done using: `padding: [top & bottom]px [left & right]px` and we will be using two values to make them both symmetric.

We do not want to make only the text click-able, a box that acts like a hyperlink is more ideal and we can do this by using `display: block` to convert the hyperlink to a box and we can change the width of this box by using the `width` property, they will work together automatically:
```css
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
}

li a {
	display: block;
	width: 600px;
	padding: 8px 6px;
	color: white;
	text-decoration: none; /* Removes underlines */
}
```
The code above manipulates the selector `li a` which is referring to the `<a>` tag inside the `<li>` tag as that is what the `<li>` is being made of.

Most navigation bar have some sort of feedback when being hovered over by the cursor, we can easily manipulate this by targeting the `li a:hover` selector and manipulating the colour of it as it will only change colour when it is being hovered:
```css
li a:hover {
	background-color: gray;
	color: lightgray;
}
```
The difference between `background-color` and `color` is that `background-color` would affect the hyperlink box whereas `color` will target the text colour and `color` is often changed in navigation bars when being hovered to a more vibrant colour to indicate that it is being hovered.

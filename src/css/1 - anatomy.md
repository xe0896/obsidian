There are two different ways of applying CSS onto our websites, *ruleset* and *inline style*, which have different types of way of being applied.
### Ruleset
The ruleset is normally used on a separate CSS file as it can target certain tags and ID's and which can be broken down into 5 different terms:
- Selector: targets the element that is wanted to be styled, for example `p` denotes `<p>` tag.
- Declaration block: the code in-between the curly braces after denoting the selector
- Declaration: the group name for a property and value pair that applies a style to the selected element
	- Property: signifies the visual characterisation that will be modified
	- Value: signifies the value of the property
A typical ruleset is in the form:
```css
p {
	color: blue;
}
```
### Inline style
Inline style is normally used in the HTML file as is suggested by "inline", and can target specific tags and can be broken down into 5 different terms:
- Opening tag: the start of the specific tag
- Attribute tag: the attribute of this tag that is to be modified
- Declaration: the group name for a property and value pair that applies a style to the selected element
	- Property: signifies the visual characterisation that will be modified
	- Value: signifies the value of the property
A typical inline style is in the form:
```css
<p style='color: blue';>Hello World!</p>
```
If we wanted to make our HTML file contain CSS code without linking a CSS file, we can do this by using the `<style>` tag in-between the `<head>` opening and closing tag:
```html
<head>
	<title>My title</title>
	<style>
		p {
			color: green;
		}
	</style>
</head>
```
### External stylesheet
Instead of using inline styling we can use an external CSS file which contains our CSS code that will style our website, and to do this we need to first link the CSS file with our HTML file, we can do this using the `<link>` tag and also specifying that this is a style sheet by using `rel` to make the HTML process this linked file as a CSS file to apply to our website:
```html
<head>
	<link href = './style.css' rel = 'stylesheet'> <!-- Note: relative path is being used -->
</head>
```

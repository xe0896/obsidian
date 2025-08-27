A HTML document has many standards that every website should fulfil, one of which is the title bar of a website:
![[Pasted image 20250821172356.png]]
To change the title bar of a website, we need to go inside the `<head>` tag and create a new tag `<title>` and name the website:
```html
<head>
	<title>Jessica's Portfolio Site</title>
</head>
```
### Linking other web pages
We can add a link to another web page using the `<a>` tag in conjunction with the `<href>` tag to outline the link path:
```html
<a href = "https://google.com">This is a link to Google.</a>
```
If we wanted to make the link to open a new tab when pressed on, we need to include `target=_blank` attribute inside the `<a>` tag:
```html
<a href = "https://google.com" target="_blank">This is a link to Google.</a>
```
### Linking to relative page
When we don't want to link to a website online and rather to a link within the website, like next page for example: then we can use `./path/to/file` within the `<a>` tag.
```html
<a href = "./contact.html">Contact</a>
```
We can also not make the link comprise of text, but an image instead by adding an `<img>` tag in between the `<a>` opening and closing tags:
```html
<a href = "https://google.com" target="_blank"> <img src = "images/google.jpg"/></a>
```
### Linking to the same page
When we create ID's by using `<div>` for example, then we can refer to it by using a hashtag within an `<a>` tag to link it from other contents:
```html
<ul>
	<li><a href = "#start">Start</a></li>
	<li><a href = "#middle">Middle</a></li>
	<li><a href = "#end">End</a></li>
</ul>
<div id = "start">
	<p>This is the start</p>
</div>
```
### Comments
Adding comments in HTML has its own kind of way:
```html
<!-- This is a comment that the browser will not display. -->
```

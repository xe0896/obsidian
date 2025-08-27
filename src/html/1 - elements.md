An element in HTML is comprised of opening and closing tags, as well as content in the middle:
```html
<p>Hello World!</p> <!--Paragraph tag-->
```
There are many important tags that allow us to build up a website, one of which is the `<body>` tag which will make everything within this tag will appear on the website, meaning we should include the tags that showcase elements to the user, such as the paragraph tag:
```html
<body>
	<p>Hello World!</p> 
</body>
```
### HTML structure
A HTML website has some tags that are essential to structure our websites, one of which already mentioned is the `<body>` tag which will showcase all the contents within its tag to the website. Another tag is the `<html>` tag which will be used to wraps the whole website into one. Lastly, the `<head>` tag will be used to outline the relevant metadata that browsers will need to know before showcasing some content from the `<body>` tag. 

These tags will become more relevant, namely the `<head>` tag soon. It is also important to note the `<!DOCTYPE html>` which will notify the browser on what type of document this is.
### Headings
A heading is denoted by `<h1>` which is used to make the given content into a header which is a bold and stand out title, it has different types `<hn>` where $n \in \{1,2,3,4,5,6\}$ where the content becomes less important as $n$ increases.
```html
<h1>Big heading</h1>
<h2>Medium heading</h2>
<h3>Small heading</h3>
```
### Divs
The `<div>` tag is used to divide our HTML code into sections allowing us to group our sections together and control certain sections, this is useful if we wanted to apply the same HTML style on a group of elements.
```html
<div>
<p>Part 1</p>
</div>
<div>
<p>Part 2</p>
</div>
```
### Attributes
If we wanted to expand an element's tag, we can do this by adding an attribute which can allow us to provide information to changing styling. An attribute is comprised of two components:
- The *name* of the attribute
- The *value* of the attribute
```html
<div id="intro">  
  <h1>Introduction</h1>  
</div>
```
### Displaying text
We can display text we can use the `<p>` tag which contains a plain block of text or the `<span>` tag. The main difference between these two tags is that the `<p>` tag would line break when we have consecutive `<p>` tags where `<span>` will not line break.
### Styling text
We can style text using HTML tags:
- `<em>` will emphasise text, by making it italic
- `<strong>` will highlight text, by making it bold
### Line breaks
When we want a gap in between two text blocks we can use the `<br>` tag which will make a gap in between this tag and doesn't require a closing tag, we can repeat this tag to create a larger gap: `<br><br><br>..`
### Lists
An unordered list can be created by using the `<ul>` tag which will outline that this is an unordered list and contains multiple tags of `<li>` which are the list elements:
```html
<ul>
	<li>Hello</li>
	<li>World</li>
	<li>!</li>
</ul>
```
An ordered list can be made in the similar way but by replacing `<ul>` with `<ol>`, which will list the elements with numbers in ascending order, as oppose to bullet points.
### Images
Inserting an image to our website requires a `src` which could be an image within our website directory which can be found using the path link, or we can refer to a website that is storing an image within its URL.
```html
<img src = "https://content.codecademy.com/courses/web-101/web101-image_brownbear.jpg"/>
<img src = "path/to/image.jpg"/>
```
### Videos
In addition to images, we can also include videos in a similar way, as long as we have the source link to the video. We can also alter the `width` and `height` of the video by manipulating the attributes within the `<video>` tag. There also is an additional keyword to insert within the `<video>` tag which is the `controls` keyword which allows us to actually play the video and resume, playback, etc:
```html
<video src = "https://content.codecademy.com/courses/freelance-1/unit-1/lesson-2/htmlcss1-vid_brown-bear.mp4" width = "320" height = "240" controls>
	Video not supported
</video>
```

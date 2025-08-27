## Viewing
There hasn't been any server hosting done on the website for now, will do soon.
## Introduction
Websites are something that every programmer should have so they are able to showcase their work, in my case "work" is solving coding problems, learning new programming languages by making tutorial-like notes, creating projects, etc.

My notes are mainly built on Obsidian, meaning it heavily relies on the use of Markdown, which then makes sense for the website to have some Markdown compatibility, allowing me to just move my Obsidian notes to my live website. Given that my notes are just Markdown files, there is no clash between any other language and Markdown which means once the websites frontend is finished, all I need to do is move my `.md` files into an appropriate directory so the website can read them and render it, the way we will render the Markdown is using Jekyll.
### Jekyll
We will be using Jekyll to render the `.md` files, allowing compatibility with HTML, we will also need to be able to customise how the `.md` will look like, which will hopefully look like Obsidian Markdown.

Jekyll works well with GitHub pages which is currently what the first stage of the website will be using, then hopefully we are able to move another platform that is not as janky as GitHub pages. 

Jekyll is a static site generator that takes Markdown, HTML, and other files, processes them with templates and layouts, and outputs a static website. The layouts are in HTML which we can make a one-to-one mapping between a `.md` file and a `.html` file by including a YAML (YAML Ain't Markup Language) front matter on each `.md` file which may look something like this:
```markdown
---
layout: post
title: "My First Post"
---
# Hello World
This is Markdown.
```
The `layout` specifies what layout this `.md` file should follow, in our case it will follow the layout named `post.html` and have the title `"My First Post"`, the location of `post.html` is important and must be in a folder named `_layouts` which all layouts will be contained in. 

An important attribute regarding our Markdown is to be able to customise how it looks, and we can do this with the power of CSS.

### Navigation bar
The navigation bar needed to be unique, and unique in terms of normal websites since this type of navigation bar is common in applications but not in websites and the idea was to replicate the navigation bar that Obsidian has:
![[obsidian_navbarresized?.png]]
There are some properties that this navigation bar has:
- Indication of directory opened, in this case it is using arrows
- Hierarchy within a directory
- Handling long file names by using `...` 
- Adjustable bar using vertical drag
- Scope of a directory using vertical lines
- Indicate what file is opened by highlighting the file
- Bottom bar named "Obsidian" with gear icon and help icon, will be adjusted to make it relevant for the website

We will need to implement this for all pages since we should allow control on what file to move to on any file, we will be also creating this in CSS.

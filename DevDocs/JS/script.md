We can enable JavaScript in an HTML file by using the `<script>` tag, this resides within the `<body>` tag. This tag can have some attributes but they are outdated:

- `type=..` was used to declare the MIME type of the scripting language
- `language=..` is obsolete and declares what language we are using, the default is `JavaScript` so this doesn't make sense to use as browsers now assume this

There are more as well such as `module` and `application/json` but these are rare to see nowadays.
### External scripts
JavaScript code could grow in size so we can instead locate them in a separate file and link them using `<script>` tags:

```html
<script src ="/path/to/script.js"></script>
```

The `src` attribute can also link URLs such as `src = https://code.jquery.com/jquery-3.6.0.min.js`. 

If we wanted to add multiple scripts then we must use multiple script tags in a sequence:

```html
<script src ="/path/to/script0.js"></script>
<script src ="/path/to/script1.js"></script>
<script src ="/path/to/script2.js"></script>
```

We also are not allowed to include actual JavaScript within `script` tags that are linking to an external file:

```html
<script src ="/path/to/script.js">
	alert(1);
</script>
```

`alert(1)` will be skipped in this case, so we would need to create a separate `script` tag.
## Task
Create a page that shows any message (alert) using an external JavaScript file:

```html
<!-- tasks.html -->
<!DOCTYPE html>
<html lang "en">
	<head>
		<title>foo</title>
	</head>
	<body>
		<script src ="jstask.js"></script>
	</body>
</html>
```

```javascript
<!-- jstask.js -->
alert(1);
```

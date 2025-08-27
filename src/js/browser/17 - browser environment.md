A host environment (commonly a browser) provides three essential components:
- BOM (Browser Object Model): APIs related to the browser
- DOM (Document Object Model): APIs related to the web page
- `window` object: global object, allowing access to both BOM and DOM

JavaScript is a separate component that is used to interact and work together with the host environment, one simple way of thinking it is that JavaScript is the skill and host environment is the workspace where that skill can be used, for example: JavaScript is used to handle logic, conditions, events whereas host environment is used to do useful things such as show alerts, read files, etc.

The reason why this distinction is important is because it is a common misconception to believe that functions such as `alert()` or `fetch()` are part of JavaScript, they are not and only provided by the host environment, this allows us to understand what is available, for example: the `window` object is only an object accessible by browsers as it will contain information on the host environment, in which case we will assume it is a browser and not a mobile app, if we was to use a language such as Node.js, we cannot use the object `window` as the host environment is a browser and is not a mobile app. 
### window
As mentioned before, `window` is a global object that we can access via JavaScript and provides us method to control the browser:
```javascript
function sayHello() {
	alert("Hello");
}
window.sayHello();
let height = window.innerHeight;
```
### dom
The Document Object Model represents all page content as objects that can be modified, the `document` object is the main entry point to the page, we can change or create anything on the page using it:
```javascript
document.body.style.background = "black";
setTimeOut(() => document.body.style.background = "", 1000); // Change back background after 1s
```
There are many more methods and attributes that we can use defined in the <a href = "https://dom.spec.whatwg.org/">DOM Living Standard</a> specification, it is also important to note that DOM is not only for browsers.
### bom
The Browser Object Model represents additional objects provided by the browser for working with everything except the document:
- The [navigator](https://developer.mozilla.org/en-US/docs/Web/API/Window/navigator) object provides background information about the browser and the operating system. There are many properties, but the two most widely known are: `navigator.userAgent` – about the current browser, and `navigator.platform` – about the platform (can help to differentiate between Windows/Linux/Mac etc).
- The [location](https://developer.mozilla.org/en-US/docs/Web/API/Window/location) object allows us to read the current URL and can redirect the browser to a new one.
```javascript
alert(location.href); // shows current URL
if (confirm("Go to Wikipedia?")) {
	location.href = "https://wikipedia.org"; // redirect the browser to another URL
}
```
The functions `alert/confirm/prompt` are also a part of the BOM: they are not directly related to the document, but represent pure browser methods for communicating with the user.

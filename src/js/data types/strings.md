Strings can have single or double quotes which basically act the same but we can also use backticks which offer much more flexibility and features that single and double quotes do not offer. These features include a string being able to span multiple lines:
```javascript
let guestList = `Guests:
John
Pete
Mary`;

alert(guestList);
```
The method to getting multi-line outputs using single or double quotes is to use `\n` like we do in Java in between places where we want a new line:
```javascript
let str1 = "Hello\nWorld";
```
There are other, less common special characters like `\n`:

| Character            | Expression                                                                                                                                                                                              |
| -------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `\n`                 | New line                                                                                                                                                                                                |
| `\r`                 | n Windows text files a combination of two characters `\r\n` represents a new break, while on non-Windows OS it’s just `\n`. That’s for historical reasons, most Windows software also understands `\n`. |
| `\'`, `\"`, `` \` `` | Quotes                                                                                                                                                                                                  |
| `\\`                 | Backslash                                                                                                                                                                                               |
| `\t`                 | Tab                                                                                                                                                                                                     |
| `\b`, `\f`, `\v`     | Backspace, Form Feed, Vertical Tab – mentioned for completeness, coming from old times, not used nowadays (you can forget them right now).                                                              |
All the special characters above utilise the backslash, making it have a special name called the escape character, this means if we have to represent a backslash then we have to show a double backslash rather then a single one. 
### String length
The `length` property tied to a string denotes the length of the string:
```javascript
alert(`My\n`.length);
```
### Accessing characters
To get a character at a given position `pos` we can either use `str.at(pos)` or `str[pos]`:
```javascript
let str = "Hello";
alert(str.at(0)); // H
alert(str[0]); // H
```
We are allowed to make `pos` negative which will allow us to index at the end of the given string rather then the start.
### Strings are immutable
Strings cannot be changed in JavaScript, meaning we cannot change a character of a given string, if we want to do something like this then we will have to recreate a new string:
```javascript
let str = "Hello";
str = 'h' + str[1];
alert(str); // hello
```
### Changing the case
We can also convert a given string into lowercase or uppercase by using `.toUpperCase()` or `.toLowerCase()`:
```javascript
let str = "Hello";
alert(str.toUpperCase()): // HELLO
alert(str.toLowerCase()); // hello
```
We can also access a specific character and change its case by indexing it using `.at(pos)` or `[pos]`.
### Searching for a substring
There are multiple ways in searching for a substring within a string, one of which is `str.indexOf(substr, pos)`, it will look for the given substring `substr` in `str` starting at the given position `pos` and return the index of the first occurrence, or `-1` if it cannot find.
```javascript

```
# CONTINUE LATER
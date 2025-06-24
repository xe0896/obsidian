Back in the day, JavaScript was made in a hurry and when adding new features there was a risk of the new features breaking old-code which then meant that bad practices became the norm as errors that would break old-code was just not flagged and allowed it to continue as normal. If we wanted a more stricter syntax then we must use:
```javascript
"use strict";
```
If we locate this at the top of the script then the whole script will have a stricter syntax and will ensure that we do not have any risks what would of been ignored.

We can also localise this by using functions, if we was to only want a strict syntax/scope on a certain region of code, we can use functions to localise this and the rest of the code outside the function will not see this flag, although the general case is to make this global.

It is also important to note that there is no going back after using `"use strict"`, if you are going to use it then it will always persist unless you localise it or remove it outright.
### Assignment
If the flag is off then we can do the following:
```javascript
msg = "Hello";
alert(msg);
```
But if the flag is on:
```javascript
"use strict";
msg = "Hello":
alert(msg);
```
There was no `let` keyword to assign `msg` in both cases and the 1st case allows it but the 2nd case won't.
### Is this useful
Before you start coding it is generally advised to have this flag at the top of the script and once all your code is in classes/modules then we could remove it, also these classes and modules are advanced language structures that would enable the flag automatically so it isn't even considered in those cases.

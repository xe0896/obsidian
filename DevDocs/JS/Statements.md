JavaScript's syntax is not as strict as others, this is mainly seen from how the semi-colons work when ending a statement works:
```javascript
alert(1)
alert(2)
```

There are no semi-colons above but a new-line implies a semi-colon so this works as it would if there was semi-colons at the end of each statement.

There are also some cases where a new-line does not imply a semi-colon:
```javascript
alert(3+
3
+ 2);
```

There are new lines and adding a semi-colon at the end of each new-line would be an error since `3;` is not a valid statement so it is seen as continuing statement, it also can imply that it is a single statement by the `alert(3+` which requires an additional argument which is most likely going to be continued in the next line.


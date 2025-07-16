Given a string `columnTitle` that represents the column title as appears in an Excel sheet, return _its corresponding column number_.

For example:

```
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
```
***
This question requires some knowledge on casting and understanding the base-26 system. We will iterate over the string from left to right meaning our current character may not be the final character and could be in the middle meaning its *power* should be determined by the existence of more characters to the right, for example: If we received an input of `ZBY` then if we was at character `Z` then the *power* this has isn't high by itself, it is only `26` but since it is preceded by extra characters then its *power* is much higher, mainly because its at the 3rd character starting from the left.

With this is mind we also need to calculate a given characters ASCII value which can be done via casting:
```java
public int titleToNumber(String columnTitle) {
	int result = 0;
	for(int i = 0; i < columnTitle.length(); i++) {
		char a = columnTitle.charAt(i);
		int value = a - 'A' + 1;
```
Calculating `value` is done by taking our current character `a` and taking away the character `A` from it in terms of its ASCII value since we are assigning `value` to be an `int`, this would map our given character to follow `A=0, B=1, C=2..` but the question has `A=1,B=2,C=3..` so we must do `+1` to adjust for this.

We can now then contribute this result to `result` by doing: 
```java
public int titleToNumber(String columnTitle) {
	int result = 0;
	for(int i = 0; i < columnTitle.length(); i++) {
		char a = columnTitle.charAt(i);
		int value = a - 'A' + 1;
		result = result * 26 + value;
	}
	return result;
}
```
The way this works is by relying on the existence of the magnitude of the first few characters and if there were more characters then the magnitude of the first few characters would be increased so we times by `26` which can be thought as shifting and we add our current `value` to the `result` which would be shifted in the next iteration if it respects `i < columnTitle.length()`.

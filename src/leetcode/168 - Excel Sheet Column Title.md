Given an integer `columnNumber`, return _its corresponding column title as it appears in an Excel sheet_.

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
This question requires basic knowledge on modulo operators and a certain attribute they have, namely the fact that they are 0-indexed and we have `A=1` meaning if we was to have an output of `0` from our modulo then we should return `A` as `0` is not defined in our sheet.

We will start from the RHS of the output and build our answer up, we will first do `%26` on the `columnNumber` as we need to know the remainder for this current index and then use casting to convert our output to a character where we will append to our string using `StringBuilder`, to go to the next index (towards LHS) we divide by `26` and repeat this process until `columnNumber` is small enough such that we divide `26` on it that it will return `0`, i.e: `columnNumber <= 0`

```java
public String convertToTitle(int columnNumber) {
	StringBuilder str = new StringBuilder();
	while(columnNumber > 0) {
		columnNumber--;
		int rem = columnNumber % 26;
		str.append((char) ('A' + rem));
		columnNumber /= 26;
	}
	return str.reverse().toString();
}
```

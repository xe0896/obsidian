Given two binary strings `a` and `b`, return _their sum as a binary string_.
***
This problem could be straight-forward if we make plenty of if-statements that cover all bases but is just not practical and there is a much more simpler and thought-out solution. The logic is essentially figured out by doing trials of adding binary and finding out a pattern connecting the `sum` of `carry`, `digitA` and `digitB` with our new `carry` and `resultBit`.

Before we start with the above, we should address some potential issues as given two strings, they could have different lengths and we must ensure we do not make any assumptions of indexing and cover all bases, more precisely: we must convert an out of bounds error from one `String` that could be out of bounds with a `0` instead. To do this we can simply use multiplexers.

Furthermore, our iterator here will be a `while` with condition `i >= 0 || j >= 0 || carry != 0`, first two are trivial but the last one needs some clarification: `carry != 0` is used since if we have iterated over all strings but we still have a `carry` bit then we must append this, our logic will also have to cover the case where we have no pointers to our `String`, namely `i` and `j` since they will be out of bounds.

We also need to make an easy way to construct our `String` so we will be using the `StringBuilder` class.

```java
public String addBinary(String a, String b) {
	int carry = 0;
	int i = a.length() - 1;
	int j = b.length() - 1;
	while(i >= 0 || j >= 0 || carry != 0) {
		int digitA = i >= 0 ? a.charAt(i) - '0' : 0;
		int digitB = i >= 0 ? b.charAt(j) - '0' : 0;
	}
}
```

To calculate our `carry` we require the `sum` since if `sum` is equal to `0` or `1` then our new `carry=0` but if `sum` is equal to `2` or `3` then `carry=1`, we can capture this behaviour without if-statements by simply doing `carry = sum/2` as Java will truncate the fractional part and leave the integer which captures this logic perfectly.

For `resultBit` we can simply check to see if `sum` is equal to `0` or `2` and if this is the case then `resultBit` would be 0, else it would be `1`, we can capture this logic by doing `resultBit = sum % 2`

As we are appending via `StringBuilder` on the right-side, we must reverse once we return our `String` as we should be appending from the left but there is no function for that
```java
public String addBinary(String a, String b) {
	int carry = 0;
	int i = a.length() - 1;
	int j = b.length() - 1;
	StringBuilder ans = new StringBuilder();
	while(i >= 0 || j >= 0 || carry != 0) {
		int digitA = i >= 0 ? a.charAt(i) - '0' : 0;
		int digitB = j >= 0 ? b.charAt(j) - '0' : 0;

		int sum = digitA + digitB + carry;
		carry = sum / 2;
		int resultBit = sum % 2;

		i--;
		j--;
		ans.append(resultBit);

	}

	return ans.reverse().toString();
}
```


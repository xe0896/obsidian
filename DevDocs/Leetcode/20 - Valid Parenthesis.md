Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.
***
For this problem, three variables: `brac`, `curl`, `squi` was made to track the closure of brackets and when these all equal to `0` this implies that all brackets have been closed since it will increment when that type of bracket is opened and decrement when it is closed:
```java
int brac = 0;
int curl = 0;
int squi = 0;
for (int i = 0; i < s.length(); i++) {
	switch(s.charAt(i)) {
		case '(':
			brac++;
			break;
		case '[':
			curl++;
			break;
		case '{':
			squi++;
			break;
		case ')':
			brac--;
			break;
		case ']':
			curl--;
			break;
		case '}':
			squi--;
			break;
	}
}
return (brac == 0 && curl == 0 && squi == 0);
}
```

This works well for general cases but for cases like: `([)]` is where it fails as all brackets was closed successfully but the order is incorrect, and an even more general case like: `)(` will also fail since `brac` would decrement to `-1` then increment to `0` which would make the return statement `true` which is not the case. The main idea here is the ordering of brackets and these two cases mentioned are different as the 1st one is related to closing a bracket while another bracket has been opened between the opening and closure and the 2nd one is related to brackets being closed then opened rather then opened and closed. 

The 2nd case is much easier to handle since we can just check if any of the variables become negative since in all cases the variables should never become negative and we can return `false` instantly once we find that this is the case.

```java
if (Math.min(Math.min(brac,squi),curl) < 0) {
	return false;
}
```

The 1st case requires us to...



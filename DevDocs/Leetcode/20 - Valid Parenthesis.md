Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.
***
### Stack implementation
The problem here was designed for us to utilise the stack so we will. The algorithm will work like this:
- If we find an open parenthesis we will push this into the stack
- If we find a closed parenthesis, we will peek at the stack and the value leads to two scenarios:
	- The value is an open parenthesis and of same type so we pop the open parenthesis
	- The value is not satisfying the condition above so we do not do anything
- Once we iterate over the whole given string and the stack is empty we return `true`, else `false`.

We will be using an `ArrayList` to emulate as a stack as is dynamic and is just easier for us to use then a normal array:
```java
import java.util.ArrayList;

public boolean isValid(String s) {
	int head = 0; // Stores index of the head just above the latest value inserted
	ArrayList<String> stack = new ArrayList<>();

```
The first scenario outlined is when we encounter an open parenthesis, it doesn't matter what type of parenthesis this will be, we will just need to push this onto the stack. Since our `ArrayList` cannot store primitive types like `char` and only objects we will be converting our `char`'s into `String` as its an object:
```java
for (int i = 0; i < s.length(); i++) {
	String current = "" + s.charAt(i); // Easy way to convert to String
	if (current.equals("(") || current.equals("[") || current.equals("{")) {
		stack.add(current);
		head++;
	}
}
```
Now before we begin, we should be careful with our assumptions as when we peeking at our stack to see if we have matching parenthesis we will get an out of bounds error whenever the stack is empty. This can be done with an `||` operator with two operands as it will check to see if first operand is `true` which would be if `head > 0`, if this is the case then it will return `false`, if this is not the case then it can carry on with the peek and if the value we see when we peek doesn't match with our parenthesis then we can return `false` (This is just a more thought out if-statement).
```java
} else if (current.equals("(")) {
	head--;
	if (head > 0 || !stack.get(head).equals(")")) {
		return false;
	}
	stack.remove(head);
} else if (current.equals("[")) {
	head--;
	if (head > 0 || !stack.get(head).equals("]")) {
		return false;
	}
	stack.remove(head);
} else if (current.equals("{")) {
	head--;
	if (head > 0 || !stack.get(head).equals("}")) {
		return false;
	}
	stack.remove(head);
}
```
Then we can just use `return stack.isEmpty()` to see if the stack still has values, this is required since if we inserted a bunch of open parenthesis such as `[{(`, then it wouldn't trigger our if-statements regarding non-matching parenthesis and never return `false` or `true`, algorithms states this but its nice to see this in context:
```java
import java.util.ArrayList;
public boolean isValid(String s) {
	int head = 0;
	ArrayList<String> stack = new ArrayList<>();
	for(int i = 0; i < s.length(); i++) {
		String current = "" + s.charAt(i);
		if (current.equals("(") || current.equals("[") || current.equals("{")) {
			stack.add(current);
			head++;
		} else if (current.equals("(")) {
			head--;
			if (head > 0 || !stack.get(head).equals(")")) {
				return false;
			}
			stack.remove(head);
		} else if (current.equals("[")) {
			head--;
			if (head > 0 || !stack.get(head).equals("]")) {
				return false;
			}
			stack.remove(head);
		} else if (current.equals("{")) {
			head--;
			if (head > 0 || !stack.get(head).equals("}")) {
				return false;
			}
			stack.remove(head);
		}
	}
	return stack.isEmpty();
}
```

### Non-stack implementation
The stack answer is pretty trivial so here is an attempt without using a stack, not done yet though:

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

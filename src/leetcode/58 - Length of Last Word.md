Given a string `s` consisting of words and spaces, return _the length of the **last** word in the string._

A **word** is a maximal substring consisting of non-space characters only.
***
This problem required a special function to detect whitespaces since `s.charAt()` won't cut it, we will be using `Character.isWhitespace()` instead to detect white spaces, the logic is basically just iterating over the string backwards since the last word would be around here, and then if index `i` is not a white space then we set a flag to be `true` since we are now at a word and then keep on iterating and incrementing a counter `k` until our index `i` is a white space and then return `k`.

```java
public int lengthOfLastWord(String s) {
	int k = 0;
	boolean enter = false;
	if(s.length() == 1 && !Character.isWhitespace(s.charAt(0))) {return 1;}
	for(int i = 0; i < s.length()-1; i >= 0; i--) {
		boolean c = Character.isWhitespace(s.charAt(i));
		if(enter) {
			if(c) {
				return k;
			} else {
				k++;
			}
		} else if (!c) {
			enter = true;
			k++;
		}
	}
	return k;
}
```
Roman numerals are represented by seven different symbols: `I`, `V`, `X`, `L`, `C`, `D` and `M`.
For example, `2` is written as `II` in Roman numeral, just two ones added together. `12` is written as `XII`, which is simply `X + II`. The number `27` is written as `XXVII`, which is `XX + V + II`.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not `IIII`. Instead, the number four is written as `IV`. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as `IX`. There are six instances where subtraction is used:

- `I` can be placed before `V` (5) and `X` (10) to make 4 and 9. 
- `X` can be placed before `L` (50) and `C` (100) to make 40 and 90. 
- `C` can be placed before `D` (500) and `M` (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.
***
For this problem, it was clear that this was a test for if-statements/switch cases as we must first initially check if our current index `i` is either `I`, `X` or `C` as they have special cases of subtraction and we can adjust our `ans` depending on the value of `i+1`, if we do have the case where subtraction is required we must increment `i` as if we was to find `IV` and started at `I` and found `V` at `i+1`, then we can consider the two numerals `IV` to be `4` by doing `i++` rather then the singular numeral `I` to be `4` and then considering `V` which would make `IV = 9`

Another thing to note is that since we are checking values of `i+1` we are assuming the existence of these values so we must first check to see if it exists before checking the cases of subtraction, to do this we can store this conditional statement to a boolean value so we can optimise and not constantly re-use `s.charAt(i+1)`.

```java
public int romanToInt(String s) {
	int ans = 0;
	for (int i = 0; i < s.length(); i++) {
		boolean flag = i+1 < s.length();

		if (s.charAt(i) == 'I') {
			if (flag) {
				if (s.charAt(i+1) == 'V') {
					ans = ans + 4;
					i++;
					continue;
				} else if (s.charAt(i+1) == 'X') {
					ans = ans + 9;
					i++;
					continue;
				}
			}
			ans = ans + 1;
		}
	
		if (s.charAt(i) == 'X') {
			if (flag) {
				if (s.charAt(i+1) == 'L') {
					ans = ans + 40;
					i++;
					continue;
				} else if (s.charAt(i+1) == 'C') {
					ans = ans + 90;
					i++;
					continue;
				}
			}
			ans = ans + 10;
		}

		if (s.charAt(i) == 'C') {
			if (flag) {
				if (s.charAt(i+1) == 'D') {
					ans = ans + 400;
					i++;
					continue;
				} else if (s.charAt(i+1) == 'M') {
					ans = ans + 900;
					i++;
					continue;
				}
			}
			ans = ans + 100;
		}
		switch(s.charAt(i)) {
			case 'V':
				ans = ans + 5;
				break;
			case 'L':
				ans = ans + 50;
				break;
			case 'D':
				ans = ans + 500;
				break;
			case 'M':
				ans = ans + 1000;
				break;	
		}
	}

	return ans;
}
```



The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
<img alt ="center" src = "Pasted image 20250327220727.png">

And then read line by line: `"PAHNAPLSIIGYIR"`

Write the code that will take a string and make this conversion given a number of rows:

```java
string convert(string s, int numRows);
```
***
This problem requires a diagram to figure out a pattern and how we can map `answer.charAt(i)` $\rightarrow$ `answer.charAt(i+1)`, this was done by looking at small `numRows` and large `numRows` and identifying this mapping:
![[image (1).png]]
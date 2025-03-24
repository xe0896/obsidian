You are given an array of `n` strings `strs`, all of the same length.

The strings can be arranged such that there is one on each line, making a grid.

- For example, `strs = ["abc", "bce", "cae"]` can be arranged as follows:

```
> abc
> bce
> cae
```

You want to **delete** the columns that are **not sorted lexicographically**. In the above example (**0-indexed**), columns 0 (`'a'`, `'b'`, `'c'`) and 2 (`'c'`, `'e'`, `'e'`) are sorted, while column 1 (`'b'`, `'c'`, `'a'`) is not, so you would delete column 1.

Return _the number of columns that you will delete_.

***
This was my first Leetcode problem of this journey of documenting my approach and answers, it took me a few minutes to understand what the question was asking me, but the answer was pretty straightforward. After some drawings on the Remarkable, a 2D-array was being formed here and I had to just index it such that I can gather the relevant information:

$$
\begin{bmatrix}
a & b & c \\
c & a & b \\
b & a & d
\end{bmatrix}
$$

Firstly, intuitively an iterator $i$ would be used to gather the rows, i.e: $a \ b \ c$ which would be the outer loop and then an iterator $j$ would be used to gather the columns given that we have the row, meaning an individual character like $a$. This means that we can iterate over columns characters in a given column using the $j$ iterator:

```java
public int minDeletionSize(String[] strs) {
	int deletions = 0; // questions wants me to get the column deletion count
	for (int i = 0; i < strs.length - 1; i++) {
		int strlength - strs[i].length();
		for (int j = 0; j < strlength; j++) {
			char element = strs[i].charAt(j);
			if (element1 < element) { // compares two chars via ASCII
				deletions++;
				break; // break as this column is deleted
			}
		}
	}
	return deletions;
}
```

However, this wasn't the correct approach as it should be the other way around, i.e: the outer loop is the $j$ and the inner loop is the $i$ as we was working in an $(i,j)$ format earlier and if we wanted to check for columns then $(j,i)$ would be correct. In other words, we was looking at adjacent rows rather then a single column.

After realizing this, it also made sense for the indexing to be changed for the $i$ iterator since if we are comparing the $i$-th row for a given $j$ then we should start at $i = 1$ and then compare that with $i - 1$ until we reach the array limit to:

 - Avoid out of bounds error
 - More neat

Furthermore, our indexing previously was really wrong, for the column count we assumed it was the length of the array when it is the length of an arbitrary element in the array:
```java
int colCount = strs[0].length();
```

After all this into consideration, the following final answer was made:
```java
public int minDeletionSize(String[] strs) {
	int deletions = 0;
	int rowCount = strs.length;
	int colCount = strs[0].length();
	for (int j = 0; j < colCount; j++) {
		for (int i = 1; i < rowCount; i++) {
			if (strs[i].charAt(j) > strs[i-1].charAt(j)) {
				deletions++;
				break;
			}
		}
	}
	return deletions;
}
```

## Lessons learned

- Ensure that the elements we get when indexing are correct and are consistent
- Use the initialization of iterators in for loops to our advantage ($i = 1$) which thus allowed us to compare with $i-1$ rather then $i+1$ to not get out of bounds errors
- Our for loop bounds are correct
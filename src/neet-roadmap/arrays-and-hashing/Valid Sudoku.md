You are given a 9 x 9 Sudoku board board. A Sudoku board is valid if the following rules are followed:

Each row must contain the digits 1-9 without duplicates.
Each column must contain the digits 1-9 without duplicates.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.
Return true if the Sudoku board is valid, otherwise return false

Note: A board does not need to be full or be solvable to be valid.
***
This question was mainly regarding data structures and how we can use certain data structures to represent our checks in an efficient way as well as creating a formula that we can use to grab an index given that we have a `cell`'s `rows` and `cols` index to work with.

The "best" data structure that we can use in JavaScript would be the `Set` data structure, as we are looking for duplicates along each row and each column, and since this is a `9x9` Sudoku board, we will need `9` sets for both rows and columns.

We will also need `9` sets for our `3x3` sub-boxes as we have `9` of them that will need checking, the main problem is how we will index our sub-boxes since given a `cell`'s `rows` and `cols`, how will we determine what sub-box this belongs to since we will need to see if this current `cell` value clashes with our set that we are maintaining for this sub-box.

The main idea here would be to make a formula that given our `rows` and `cols` we can map to the `3x3` sub-box it is in, and since there are `9` we can label our sub-boxes to be `0..9` .

| (i,j) | 0   | 1   | 2   |
| ----- | --- | --- | --- |
| **0** | 0   | 1   | 2   |
| **1** | 3   | 4   | 5   |
| **2** | 6   | 7   | 8   |
The table above shows the main idea here, we have broken down our `3x3` blocks into there own cells `0..9` which can be indexed by `i,j` which we want to calculate `i,j` using our `rows` and `cols` and to do this we can simply divide both `rows` and `cols` by `3` as these sub-boxes are perfectly `3x3` in our `9x9` Sudoku board, we also need to make sure we do integer division if we want the correct `i,j`.

Now that we have our `i,j` that we can index our sub-boxes with, in JavaScript it is ideal that we flatten our `i,j` into a single index, so basically converting our 2D array into a 1D array like we will do with our `rowSet` and `colSet` which would be `18` sets that would maintain the uniqueness of each row and columns in our Sudoku board. 

The standard way to do this would be to do $row // 3 \times 3 + col // 3$ where $//$ denotes integer division (also equivalent to $i \times 3 + j)$, the way this works is that we have a base index which is our `row` that we want to start at and an offset which can be our `col` and we times `row` with `3` since that is the difference between two rows that are on top of each other, the formula could also be understood with: `BaseIndex + Offset`. 

If we was using Python, we could do this automatically by just giving it $row // 3 + col // 3)$ and by using a dictionary it would flatten the indexes for us, but we are using JavaScript here.

Now that we have our logic completed, we just need to code this and the first thing to do is to initialise our `Set` for each row, column and block. To do this we will be using an array of sets which all have lengths `9`:

```js
isValidSudoku(board) {
	const rowSet = Array.from({ length: 9 }, () => new Set());
	const colSet = Array.from({ length: 9 }, () => new Set());
	const blockSet = Array.from({ length: 9 }, () => new Set());
}
```

Since we want to access each `cell`, we will need to iterate over the given `board` array and the constraints state that the length the array and the length of the arrays inside the array is `9`, we can just iterate up to `8` (`0`-indexed), we were also told that that cells that have a value of `.` implies that it is empty so if we was to stumble across this value, we can just do `continue` and not have to check any duplicates since nothing has changed. 

```js
for(let row = 0; row < 9; row++) {
	for(let col = 0; col < 9; col++) {
		let cell = board[row][col];
		if(cell == ".") {
			continue;
		}
	}
}
```

The hard work has already been done, we just need to emulate this in code. However, we should talk about efficiency here since if we was to ever find a duplicate in our sets then we can immediately return `false` and since we want every set to remain unique we can use an `||` operation to check uniqueness for each set using `.has`, and if it is `true` then we can add our `cell` to every set we have.

If we wanted to index our `blockSet`, we will need to convert it to `i,j` and then flatten them out like we said before, we also need to index our array properly since we only care about the row set that this cell is in and the column set that this cell is in, we can do `rowSet[r]` and `colSet[c]` to do this, as well as `blockSet[blockIndex]` for that special index:

```js
const blockIndex = Math.floor(row / 3) * 3 + Math.floor(col / 3);
if(rowSet[r].has(cell) || colSet[c].has(cell) || blockSet[blockIndex].has(cell)) {
	return false;
} else {
	rowSet[r].add(cell);
	colSet[c].add(cell);
	blockSet[blockIndex].add(cell);
}
```

Combining all this leads to the following answer:
```js
isValidSudoku(board) {
    const rowSets = Array.from({length: 9 }, () => new Set());
    const colSets = Array.from({length: 9 }, () => new Set());
    const blockSets = Array.from({length: 9 }, () => new Set());

    for(let r = 0; r < 9; r++) {
        for(let c = 0; c < 9; c++) {
            let cell = board[r][c];
            if(cell == ".") {
                continue;
            }
            const blockIndex = Math.floor(r / 3) * 3 + Math.floor(c / 3);
            if(rowSets[r].has(cell) || colSets[c].has(cell) || blockSets[blockIndex].has(cell)) {
                return false;
            } else {
                rowSets[r].add(cell);
                colSets[c].add(cell);
                blockSets[blockIndex].add(cell);
            }
        }
    }
    return true;
}
```

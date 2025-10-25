/*
 * @lc app=leetcode id=36 lang=javascript
 *
 * [36] Valid Sudoku
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function (board) {
  const rows = Array.from({ length: 9 }, () => new Set());
  const cols = Array.from({ length: 9 }, () => new Set());
  const blocks = Array.from({ length: 9 }, () => new Set());

  for (let row = 0; row < board.length; row++) {
    for (let col = 0; col < board[row].length; col++) {
      const cell = board[row][length];
      if (cell == "") {
        continue;
      }
      const blockIndex = Math.floor((row / 3) * row + col / 3);
      if (
        rows[row].has(cell) ||
        cols[col].has(cell) ||
        blocks[blockIndex].has(cell)
      ) {
        return false;
      } else {
        rows[row].set(cell);
        cols[col].set(cell);
        blocks[blockIndex].set(cell);
      }
    }
  }

  return true;
};
// @lc code=end

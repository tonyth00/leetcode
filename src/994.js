/**
 * @param {number[][]} grid
 * @return {number}
 */
var orangesRotting = function(grid) {
  let freshOranges = 0;
  let minElapsed = 0;
  const rows = grid.length;
  const cols = grid[0].length;
  let checked = [];
  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < cols; j++) {
      if (grid[i][j] == 2) {
        
        checked.push([i, j]);
      } else if (grid[i][j] == 1) {
        freshOranges++;
      }
    }
  }

  let newChecked = [];
  const makeRotten = (grid, i, j) => {
    if (i >= 0 && i < rows && j >= 0 && j < cols && grid[i][j] == 1) {
      grid[i][j] = 2;
      freshOranges--;
      newChecked.push([i, j]);
    }
  };

  while (checked.length > 0 && freshOranges > 0) {
    newChecked = [];
    for (let [i, j] of checked) {
      makeRotten(grid, i + 1, j);
      makeRotten(grid, i - 1, j);
      makeRotten(grid, i, j + 1);
      makeRotten(grid, i, j - 1);
    }
    checked = newChecked;
    minElapsed++;
  }

  return freshOranges > 0 ? -1 : minElapsed;
};

console.log(
  orangesRotting([
    [2, 1, 1],
    [1, 1, 0],
    [0, 1, 1],
  ])
);

/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var spiralOrder = function(m) {
  if (!m || !m.length || !m[0].length) {
    return [];
  }
  const rows = m.length;
  const cols = m[0].length;
  const dirs = [
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0],
  ];
  let dir = 0;

  const result = [];

  const checked = [];
  for (let i = 0; i < rows; i++) {
    checked.push([]);
    for (let j = 0; j < cols; j++) {
      checked[i].push(false);
    }
  }

  let [i, j] = [0, -1];

  while (result.length < rows * cols) {
    const [dI, dJ] = [i + dirs[dir][0], j + dirs[dir][1]];

    if (dJ >= 0 && dJ < cols && dI >= 0 && dI < rows && !checked[dI][dJ]) {
      i = dI;
      j = dJ;
      result.push(m[i][j]);
      checked[i][j] = true;
    } else {
      dir = (dir + 1) % 4;
    }
  }

  return result;
};

console.log(
  spiralOrder([
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9],
  ])
);

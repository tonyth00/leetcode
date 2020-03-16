/**
 * @param {number[][]} matrix
 * @return {number[][]}
 */
var updateMatrix = function(matrix) {
  let queue = [];
  const rows = matrix.length;
  const cols = matrix[0].length;
  for (let i = 0; i < matrix.length; i++) {
    for (let j = 0; j < matrix[0].length; j++) {
      if (matrix[i][j] == 1) {
        queue.push([i, j]);
      }
    }
  }

  const v = (m, i, j) => {
    if (i >= 0 && i < rows && j >= 0 && j < cols) {
      return m[i][j];
    } else {
      return 5000;
    }
  };

  let newQueue = [];

  const update = (m, i, j) => {
    const result = Math.min(v(m, i - 1, j), v(m, i + 1, j), v(m, i, j - 1), v(m, i, j + 1)) + 1;

    // console.log('checking', i, j);
    // console.log('result', result, 'm[][]', m[i][j]);
    if (result != m[i][j]) {
      m[i][j] = result;
      newQueue.push([i, j]);
    }
  };

  while (queue.length) {
    // console.log('queue lenght', queue.length);
    newQueue = [];
    for (let [i, j] of queue) {
      update(matrix, i, j);
    }
    // console.log(matrix);
    // console.log(newQueue.length);
    queue = newQueue;
  }

  return matrix;
};

console.log(updateMatrix([
  [1, 1, 1, 1],
  [1, 1, 1, 1],
  [1, 1, 1, 1],
  [0, 0, 0, 0],
]));

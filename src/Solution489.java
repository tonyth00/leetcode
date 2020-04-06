import java.util.HashSet;
import java.util.Set;
import java.awt.Point;

public class Solution489 {
  public static void main(String[] args) {
    
  }

  static class Solution {
    final static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void cleanRoom(Robot robot) {
      dfs(robot, 0, 0, 0, new HashSet<>());
    }
    
    private void dfs(Robot robot, int dir, int i, int j, Set<Point> visited) {
      robot.clean();
      visited.add(new Point(i, j));

      for (int k = 0; k < 4; k++) {
        int I = i + dirs[dir][0];
        int J = j + dirs[dir][1];
        if (!visited.contains(new Point(I, J)) && robot.move()) {
          dfs(robot, dir, I, J, visited);
        }

        dir = (dir + 1) % 4;
        robot.turnRight();
      }

      // backtrack. return to the cell Robot came from
      robot.turnRight();
      robot.turnRight();
      robot.move();
      // put robot back to its previous orientation
      robot.turnRight();
      robot.turnRight();
    }

    interface Robot {

      void clean();
      boolean move();
      void turnRight();
      void turnLeft();
    }
  }
}
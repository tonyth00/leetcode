import java.util.*;

class Solution207 {
  public static void main(String[] args) {
    System.out.println(new Solution().canFinish(6, new int[][] {{3, 2}, {2, 5}, {0, 5}, {0, 4}, {1, 4}}));
  }

  static class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      int[] inDegrees = new int[numCourses];
      List<Integer>[] adjList = new List[numCourses];
      for (int i = 0; i < numCourses; i++) {
        adjList[i] = new ArrayList<>();
      }
      for (int[] e : prerequisites) {
        adjList[e[1]].add(e[0]);
        inDegrees[e[0]]++;
      }

      Queue<Integer> queue = new LinkedList<>();
      for (int i = 0; i < inDegrees.length; i++) {
        if (inDegrees[i] == 0) queue.add(i);
      }

      int count = 0;
      while (!queue.isEmpty()) {
        int cur = queue.remove();
        for (Integer i : adjList[cur]) {
          inDegrees[i]--;
          if (inDegrees[i] == 0) queue.add(i);
        }

        count++;
      }
      return count == numCourses;
    }
  }
}
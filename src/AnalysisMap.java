
/**
 * @author haungyongkang
 */

public class AnalysisMap {

  /**
   * 题目链接: https://leetcode-cn.com/submissions/detail/57988497/
   */


  public static void main(String[] args) {
    int[][] grid = new int[][]{
        {1, 0, 0},
        {0, 0, 0},
        {0, 0, 0}};
    System.out.println(maxDistance(grid));
  }


  private static int maxDistance(int[][] grid) {
    int maxDistance = -1;

    for (int indexI = 0; indexI < grid.length; indexI++) {
      for (int indexJ = 0; indexJ < grid[indexI].length; indexJ++) {
        if (isSea(grid[indexI][indexJ])) {
          // 计算海洋到陆地最远距离
          int distance = getMaxDistance(grid, indexI, indexJ);
          if (distance > maxDistance) {
            maxDistance = distance;
          }
        }
      }
    }

    return maxDistance;
  }


  private static int getMaxDistance(int[][] grid, int indexI, int indexJ) {
    int maxLength = grid.length + grid[0].length - 2;

    for (int distance = 1; distance <= maxLength; distance++) {
      boolean isSea = isAllSea(grid, indexI, indexJ, distance);
      if (!isSea) {
        return distance;
      }
    }
    return -1;
  }

  private static boolean isAllSea(int[][] grid, int indexI, int indexJ, int maxDistance) {
    boolean isSea = true;

    for (int i = 0; i <= maxDistance && isSea; i++) {
      int j = maxDistance - i;

      int minI = indexI - i;
      int maxI = indexI + i;

      int maxJ = indexJ + j;
      int minJ = indexJ - j;

      if (minI >= 0 && maxJ < grid[0].length) {
        isSea = isSea && isSea(grid[minI][maxJ]);
      }
      if (minI >= 0 && minJ >= 0) {
        isSea = isSea && isSea(grid[minI][minJ]);
      }
      if (maxI < grid.length && maxJ < grid[0].length) {
        isSea = isSea && isSea(grid[maxI][maxJ]);
      }
      if (minJ >= 0 && maxI < grid.length) {
        isSea = isSea && isSea(grid[maxI][minJ]);
      }
    }
    return isSea;
  }

  private static boolean isSea(int gridValue) {
    return gridValue == 0;
  }
}



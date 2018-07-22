import java.util.HashSet;

public class FindFallingBricks {
  public static void main(String[] args) {
    int[][] matrix = new int[][]{
      new int[]{0, 1, 1, 0, 1, 1},
          new int[]{1, 0, 1, 0, 1, 1},
          new int[]{1, 0, 1, 1, 0, 1},
          new int[]{1, 0, 0, 0, 0, 1},
          new int[]{1, 0, 0, 0, 0, 1},
          new int[]{1, 0, 0, 0, 1, 1}
    };
    Pair hit = new Pair(2, 1);
    HashSet<Pair> set = findFallingBricks(matrix, hit);
    for (Pair p : set) {
      System.out.println(String.format("x: %d , y: %d", p.x, p.y));
    }
  }

  private static HashSet<Pair> findFallingBricks(int[][] matrix, Pair hit) {
    HashSet<Pair> fallenPairs = new HashSet<>();
    if (matrix.length == 0 || matrix[0].length == 0) return new HashSet<>();
    matrix[hit.y][hit.x] = 0;
    scavengeGroup(matrix, hit.x + 1, hit.y, fallenPairs);
    scavengeGroup(matrix, hit.x - 1, hit.y, fallenPairs);
    scavengeGroup(matrix, hit.x, hit.y + 1, fallenPairs);
    scavengeGroup(matrix, hit.x, hit.y - 1, fallenPairs);
    matrix[hit.y][hit.x] = 1;
    return fallenPairs;
  }

  private static void scavengeGroup(int[][] matrix, int x, int y, HashSet<Pair> fallenPairs) {
    HashSet<Pair> group = new HashSet<>();
    if (!assembleDeepGroup(group, matrix, x, y)) addToSet(fallenPairs, group);
  }

  private static boolean assembleDeepGroup(HashSet<Pair> group, int[][] matrix, int x, int y) {
    if (y < 0
        || x < 0
        || y >= matrix.length
        || x >= matrix[0].length
        || matrix[y][x] == 0
        || group.contains(new Pair(x, y))) return false;
    if (matrix.length == y + 1) return true;
    group.add(new Pair(x, y));
    return assembleDeepGroup(group, matrix, x - 1, y)
      || assembleDeepGroup(group, matrix, x + 1, y)
      || assembleDeepGroup(group, matrix, x, y - 1)
      || assembleDeepGroup(group, matrix, x, y + 1);
  }

  private static void addToSet(HashSet<Pair> destSet, HashSet<Pair> set) {
    for (Pair p : set) {
      destSet.add(p);
    }
  }

  public static class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      return hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
      return x * 1000 + y;
    }
  }
}


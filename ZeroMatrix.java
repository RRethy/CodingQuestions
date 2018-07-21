public class ZeroMatrix {
  public static void main(String[] args) {
    int[][] matrix = new int[][]{new int[]{1, 2, 0, 4}, new int[]{5, 6, 7, 0}, new int[]{9, 10, 11, 12}, new int[]{13, 14, 15, 16}};
    for (int i = 0; i < 4; i++) {
      System.out.println(String.format("---------------------"));
      System.out.println(String.format("| %02d | %02d | %02d | %02d |", matrix[i][0], matrix[i][1], matrix[i][2], matrix[i][3]));
      System.out.println(String.format("---------------------"));
    }

    System.out.println(String.format("====================="));
    System.out.println(String.format("====================="));

    zeroMatrix(matrix);

    for (int i = 0; i < 4; i++) {
      System.out.println(String.format("---------------------"));
      System.out.println(String.format("| %02d | %02d | %02d | %02d |", matrix[i][0], matrix[i][1], matrix[i][2], matrix[i][3]));
      System.out.println(String.format("---------------------"));
    }
  }

  private static void zeroMatrix(int[][] matrix) {
    if (matrix.length == 0) return;
    boolean[] zrows = new boolean[matrix.length];
    boolean[] zcols = new boolean[matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          zrows[i] = true;
          zcols[j] = true;
        }
      }
    }

    for (int ri = 0; ri < zrows.length; ri++) {
      if (zrows[ri]) {
        for (int i = 0; i < matrix[ri].length; i++) {
          matrix[ri][i] = 0;
        }
      }
    }

    for (int ci = 0; ci < zrows.length; ci++) {
      if (zcols[ci]) {
        for (int i = 0; i < matrix.length; i++) {
          matrix[i][ci] = 0;
        }
      }
    }
  }
}

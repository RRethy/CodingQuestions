public class ZeroMatrix {
  public static void main(String[] args) {
    int[][] matrix = new int[][]{new int[]{1, 2, 0}, new int[]{5, 6, 7}, new int[]{9, 10, 11}, new int[]{13, 14, 15}};
    for (int i = 0; i < 4; i++) {
      System.out.println(String.format("---------------------"));
      System.out.println(String.format("| %02d | %02d | %02d |", matrix[i][0], matrix[i][1], matrix[i][2]));
      System.out.println(String.format("---------------------"));
    }

    System.out.println(String.format("====================="));
    System.out.println(String.format("====================="));

    zeroMatrix2(matrix);

    for (int i = 0; i < 4; i++) {
      System.out.println(String.format("---------------------"));
      System.out.println(String.format("| %02d | %02d | %02d |", matrix[i][0], matrix[i][1], matrix[i][2]));
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

    for (int ci = 0; ci < zcols.length; ci++) {
      if (zcols[ci]) {
        for (int i = 0; i < matrix.length; i++) {
          matrix[i][ci] = 0;
        }
      }
    }
  }

  private static void zeroMatrix2(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) return;

    boolean firstRowHasZero = false;
    boolean firstColHasZero = false;

    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) firstColHasZero = true;
    }

    for (int i = 0; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) firstRowHasZero = true;
    }

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        for (int j = 1; j < matrix[0].length; j++) {
          matrix[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        for (int j = 1; j < matrix.length; j++) {
          matrix[j][i] = 0;
        }
      }
    }

    if (firstColHasZero) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }

    if (firstRowHasZero) {
      for (int i = 0; i < matrix[0].length; i++) {
        matrix[0][i] = 0;
      }
    }
  }
}

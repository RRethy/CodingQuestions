public class RotateMatrix {
  public static void main(String[] args) {
    int[][] matrix = new int[][]{new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}, new int[]{9, 10, 11, 12}, new int[]{13, 14, 15, 16}};
    for (int i = 0; i < 4; i++) {
      System.out.println(String.format("---------------------"));
      System.out.println(String.format("| %02d | %02d | %02d | %02d |", matrix[i][0], matrix[i][1], matrix[i][2], matrix[i][3]));
      System.out.println(String.format("---------------------"));
    }

    System.out.println(String.format("====================="));
    System.out.println(String.format("====================="));

    rotateMatrix(matrix);

    for (int i = 0; i < 4; i++) {
      System.out.println(String.format("---------------------"));
      System.out.println(String.format("| %02d | %02d | %02d | %02d |", matrix[i][0], matrix[i][1], matrix[i][2], matrix[i][3]));
      System.out.println(String.format("---------------------"));
    }
  }

  private static void rotateMatrix(int[][] matrix) {
    if (matrix.length == 0) return;
    assert matrix.length == matrix[0].length;

    int len = matrix.length;
    for (int layer = 0; layer < len / 2; layer++) {
      int end = len - 1 - layer;
      for (int i = layer; i < end; i++) {
        int tmp = matrix[layer][i];
        matrix[layer][i] = matrix[len - i - 1][layer];
        matrix[len - i - 1][layer] = matrix[len - layer - 1][len - i - 1];
        matrix[len - layer - 1][len - i - 1] = matrix[i][len - layer - 1];
        matrix[i][len - layer - 1] = tmp;
      }
    }
  }
}

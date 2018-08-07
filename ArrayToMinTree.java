public class ArrayToMinTree {
  public static void main(String[] args) {

  }

  /**
   * arr must be sorted
   */
  public static BiNode toMinTree(int[] arr, int start, int end) {
    if (start > end) return null;

    int mid = (end - start) / 2 + start;
    BiNode midNode = new BiNode(arr[mid]);
    midNode.right = toMinTree(arr, mid + 1, end);
    midNode.left = toMinTree(arr, start, mid - 1);

    return midNode;
  }


  public class BiNode {
    int val;
    BiNode left;
    BiNode right;

    public BiNode(int val) {
      this.val = val;
    }
  }
}

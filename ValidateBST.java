public class ValidateBST {
  public static void main(String[] args) {

  }

  private static boolean isValidBST(BiNode node) {
    return isNodesInRange(node.left, node.val, null) && isNodesInRange(node.right, null, node.val);
  }

  private static boolean isNodesInRange(BiNode node, Integer max, Integer min) {
    if (node == null) return true;

    if ((max == null || node.val < max)
        && (min == null || node.val > min)) {
      return isNodesInRange(node.left, node.val, min) && isNodesInRange(node.right, max, node.val);
    }

    return false;
  }

  public static class BiNode {
    int val;
    BiNode left;
    BiNode right;

    public BiNode(int val) {
      this.val = val;
    }
  }
}

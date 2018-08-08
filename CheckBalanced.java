public class CheckBalanced {
  public static void main(String[] args) {

  }

  private static boolean isBalanced(BiNode root) {
    return isBalancedCore(root).isBalanced
  }

  private static ChildInfo isBalancedCore(BiNode node) {
    if (node == null) return new ChildInfo(0, true);
    ChildInfo leftInfo = isBalancedCore(node.left);
    ChildInfo rightInfo = isBalancedCore(node.right);
    boolean isBalanced;
    if (!leftInfo.isBalanced
        || !rightInfo.isBalanced
        || Math.abs(rightInfo.count - leftInfo.count) > 1) {
      isBalanced = false;
    } else {
      isBalanced = true;
    }

    return new ChildInfo(leftInfo.count + rightInfo.count + 1, isBalanced);
  }

  public static class ChildInfo {
    int count = 0;
    boolean isBalanced = true;

    public class ChildInfo(int count, boolean isBalanced) {
      this.count = count;
      this.isBalanced = isBalanced;
    }
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

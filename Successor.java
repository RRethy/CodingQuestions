public class Successor {
  public static void main(String[] args) {

  }

  /**
   * has right === left most child of right
   * null right
   *    parents left === parent
   *    parents right === until the parent is the left of its parent
   */
  public static BiNode findNext(BiNode node) {
    if (node == null) return null;
    if (node.right != null) return findLeftMost(node.right);
    if (node.parent == null) return null;
    BiNode cur = node;
    while (cur != null) {
      if (cur.parent.left == cur) return cur;
      cur = cur.parent;
    }
    return null;
  }

  public static BiNode findLeftMost(BiNode node) {
    BiNode cur = node;
    while (cur.left != null) {
      cur = cur.left;
    }
    return cur;
  }

  public static class BiNode {
    int val;
    BiNode left;
    BiNode right;
    BiNode parent;
  }
}

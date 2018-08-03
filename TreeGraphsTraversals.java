public class TreeGraphsTraversals {
  public static void main(String[] args) {
    BiNode root = new BiNode(7);
    root.left = new BiNode(3);
    root.left.left = new BiNode(1);
    root.left.left.left = new BiNode(0);
    root.left.left.right = new BiNode(2);
    root.left.right = new BiNode(5);
    root.left.right.left = new BiNode(4);
    root.left.right.right = new BiNode(6);
    root.right = new BiNode(11);
    root.right.left = new BiNode(9);
    root.right.left.left = new BiNode(8);
    root.right.left.right = new BiNode(10);
    root.right.right = new BiNode(13);
    root.right.right.left = new BiNode(12);
    root.right.right.right = new BiNode(14);

    System.out.println("Preorder: \n");
    preorder(root);
    System.out.println("\nPostorder: \n");
    postorder(root);
    System.out.println("\nInorder: \n");
    inorder(root);
  }

  private static void preorder(BiNode node) {
    if (node != null) {
      System.out.println(String.valueOf(node.val));
      preorder(node.left);
      preorder(node.right);
    }
  }

  private static void postorder(BiNode node) {
    if (node != null) {
      postorder(node.left);
      postorder(node.right);
      System.out.println(String.valueOf(node.val));
    }
  }

  private static void inorder(BiNode node) {
    if (node != null) {
      inorder(node.left);
      System.out.println(String.valueOf(node.val));
      inorder(node.right);
    }
  }

  // public static class TreeNode {
  //   int val;
  //   TreeNode[] children;

  //   public TreeNode(int val) {
  //     this.val = val;
  //   }
  // }

  public static class BiNode {
    int val;
    public BiNode left;
    public BiNode right;

    public BiNode(int val) {
      this.val = val;
    }
  }

  // public static class Graph {
  //   GraphNode[] nodes;
  // }

  // public static class GraphNode {
  //   int val;
  //   GraphNode[] neighbours;

  //   public GraphNode(int val) {
  //     this.val = val;
  //   }
  // }
}

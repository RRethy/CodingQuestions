public class DeleteMiddleNodeLL {
  public static void main(String[] args) {
    Node root = new Node(0);
    root.append(1);
    root.append(2);
    root.append(3);
    root.append(4);
    root.append(5);
    printNodes(root);

    deleteMiddle(root.next.next);

    printNodes(root);
  }

  private static boolean deleteMiddle(Node n) {
    if (n == null || n.next == null) return false;
    n.val = n.next.val;
    n.next = n.next.next;
    return true;
  }

  private static void printNodes(Node n) {
    if (n == null) {
      System.out.println("Done Printing ---------------");
      return;
    }
    System.out.println(String.valueOf(n.val));
    printNodes(n.next);
  }

  public static class Node {
    int val;
    Node next;

    public Node(int val) {
      this.val = val;
    }

    public void append(int val) {
      Node cur = next;
      if (cur == null) {
        next = new Node(val);
        return;
      }
      Node prev = cur;
      cur = next.next;

      while (cur != null) {
        prev = cur;
        cur = cur.next;
      }

      prev.next = new Node(val);
    }
  }
}

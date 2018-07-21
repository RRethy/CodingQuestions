public class LinkedListImpl {

  public static void main(String[] args) {
    Node root = addToEnd(null, 1);
    root = addToEnd(root, 2);
    root = addToEnd(root, 3);
    root = addToEnd(root, 4);
    root = addToEnd(root, 5);

    printNodes(root);

    root = addToEnd(root, 10);
    printNodes(root);
    root = deleteNode(root, 3);
    printNodes(root);
    root = deleteNode(root, 10);
    printNodes(root);

    root = deleteNode(root, 1);
    root = deleteNode(root, 2);
    root = deleteNode(root, 4);
    root = deleteNode(root, 5);

    printNodes(root);
  }

  private static Node addToEnd(Node n, int val) {
    if (n == null) return new Node(val);

    Node cur = n;
    Node next = n.next;

    while (next != null) {
      cur = next;
      next = cur.next;
    }

    cur.next = new Node(val);

    return n;
  }

  /**
   * n acts as a wrapper for the linkedlist
   * Requires n != null
   */
  private static Node deleteNode(Node n, int val) {
    if (n == null) return n;

    Node cur = n;

    if (cur.val == val) return cur.next;

    Node prev = cur;
    cur = cur.next;
    while (cur != null) {
      if (cur.val == val) {
        prev.next = cur.next;
        break;
      }
      prev = cur;
      cur = cur.next;
    }

    return n;
  }

  private static void printNodes(Node n) {
    while (n != null) {
      System.out.println(String.valueOf(n.val));
      n = n.next;
    }
    System.out.println("---------------------------");
  }

  public static class Node {
    int val = 0;
    Node next;

    public Node(int val) {
      this.val = val;
    }
  }
}

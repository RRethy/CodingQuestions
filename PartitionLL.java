public class PartitionLL {
  public static void main(String[] args) {
    Node root = new Node(0);
    root.append(4);
    root.append(5);
    root.append(2);
    root.append(3);
    root.append(1);
    printNodes(root);
    root = partition(root, 3);
    printNodes(root);
  }

  private static Node partition(Node n, int x) {
    if (n == null) return n;

    Node head = n;
    Node tail = n;
    while (n != null) {
      Node next = n.next;
      if (n.val < x) {
        n.next = head;
        head = n;
      } else {
        tail.next = n;
        tail = n;
      }
      n = next;
    }
    tail.next = null;
    return head;
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

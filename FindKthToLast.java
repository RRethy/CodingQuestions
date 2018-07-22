public class FindKthToLast {
  public static void main(String[] args) {
    Node root = new Node(0);
    root.append(1);
    root.append(2);
    root.append(3);
    root.append(4);
    root.append(5);
    root.append(6);
    root.append(7);
    root.append(8);
    root.append(9);
    printNodes(root);

    System.out.println(String.valueOf(findKthToLast(root, 0)));
    System.out.println(String.valueOf(findKthToLast(root, 2)));
  }

  private static int findKthToLast(Node n, int k) {
    if (n == null) return -1;
    Node cur = n;
    Node runner = n.next;
    int leadSize = 0;
    while (runner != null) {
      if (leadSize == k) {
        cur = cur.next;
        runner = runner.next;
      } else {
        runner = runner.next;
        leadSize++;
      }
    }
    if (leadSize == k) {
      return cur.val;
    }
    return -1;
  }

  private static Node removeKthToLastIter(Node n, int k) {
    if (n == null) return n;
    Node prev = null;
    Node cur = n;
    Node runner = n.next;
    int leadSize = 0;
    while (runner != null) {
      if (leadSize == k) {
        prev = cur;
        cur = cur.next;
        runner = runner.next;
      } else {
        runner = runner.next;
        leadSize++;
      }
    }
    if (leadSize == k) {
      if (prev != null) {
        prev.next = cur.next;
      } else {
        return cur.next;
      }
    }
    return n;
  }

  private static Node removeKthRecur(Node n, int k) {
    if (n == null) return n;
    else if (k == 0) return n.next;
    n.next = removeKthRecur(n.next, k - 1);
    return n;
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

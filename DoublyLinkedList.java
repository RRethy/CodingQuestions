public class DoublyLinkedList {

  public static void main(String[] args) {
    Node root = null;
    root = addToEndRecur(root, 1);
    root = addToEndRecur(root, 2);
    root = addToEndRecur(root, 3);
    root = addToEndIter(root, 4);
    root = addToEndIter(root, 5);
    root = addToEndIter(root, 6);
    root = addToStart(root, 0);
    root = deleteNodeRecur(root, 0);
    root = deleteNodeIter(root, 1);
    root = deleteNodeRecur(root, 4);
    root = deleteNodeIter(root, 5);
    root = removeStart(root);
    printLinkedList(root);
    System.out.println(String.valueOf(llContainsValRecur(root, 3)));
    printLinkedList(root);
    System.out.println(String.valueOf(llContainsValIter(root, 3)));
    printLinkedList(root);
  }

  private static Node addToEndRecur(Node n, int val) {
    if (n == null) return new Node(val);

    n.next = addToEndRecur(n.next, val);
    n.next.prev = n;

    return n;
  }

  private static Node addToEndIter(Node n, int val) {
    if (n == null) return new Node(val);

    Node prev = n;
    Node cur = n.next;
    while (cur != null) {
      prev = cur;
      cur = cur.next;
    }

    Node newNode = new Node(val);
    prev.next = newNode;
    newNode.prev = prev;

    return n;
  }

  private static Node addToStart(Node n, int val) {
    Node start = new Node(val);
    start.next = n;
    n.prev = start;
    return start;
  }

  private static Node removeEnd(Node n) {
    if (n == null || n.next == null) return null;
    n.next = removeEnd(n.next);
    return n;
  }

  private static Node deleteNodeRecur(Node n, int val) {
    if (n == null) return n;
    if (n.val == val) {
      if (n.next == null) {
        return null;
      } else {
        n.next.prev = n.prev;
        return n.next;
      }
    }
    n.next = deleteNodeRecur(n.next, val);
    return n;
  }

  private static Node deleteNodeIter(Node n, int val) {
    if (n == null) return n;
    Node cur = n;
    if (cur.val == val) {
      if (cur.next == null) {
        return null;
      } else {
        cur.next.prev = null;
        return cur.next;
      }
    }

    Node prev = cur;
    cur = cur.next;

    while (cur != null) {
      if (cur.val == val) {
        prev.next = cur.next;
        if (prev.next != null) {
          prev.next.prev = prev;
        }
        break;
      }
      prev = cur;
      cur = cur.next;
    }
    return n;
  }

  private static Node removeStart(Node n) {
    if (n == null) return n;
    if (n.next != null) n.next.prev = null;
    return n.next;
  }

  private static boolean llContainsValRecur(Node n, int val) {
    if (n == null) return false;
    else if (n.val == val) return true;
    else return llContainsValRecur(n.next, val);
  }

  private static boolean llContainsValIter(Node n, int val) {
    if (n == null) return false;
    Node cur = n;
    while (cur != null) {
      if (cur.val == val) return true;
      cur = cur.next;
    }
    return false;
  }

  private static void printLinkedList(Node n) {
    Node end = n == null ? n : n.prev;
    while (n != null) {
      System.out.println(String.valueOf(n.val));
      end = n;
      n = n.next;
    }
    System.out.println("--------------------------");
    while (end != null) {
      System.out.println(String.valueOf(end.val));
      end = end.prev;
    }
    System.out.println("==========================");
  }

  public static class Node {
    int val;
    Node prev;
    Node next;

    public Node(int val) {
      this.val = val;
    }
  }
}

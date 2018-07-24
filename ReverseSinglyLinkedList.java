import java.util.Stack;

public class ReverseSinglyLinkedList {
  public static void main(String[] args) {
    Node root = new Node(0);
    root.append(1);
    root.append(2);
    root.append(3);
    root.append(4);
    root.append(5);
    root.append(6);

    root = reverseSinglyLinkedList3(root);
    printNodes(root);
  }

  private static Node reverseSinglyLinkedList1(Node n) {
    Node cur = n;
    Node prev = null;
    Node next = null;
    while (cur != null) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }

  private static Node reverseSinglyLinkedList3(Node n) {
    return reverseSinglyLinkedListCore(null, n);
  }

  private static Node reverseSinglyLinkedListCore(Node prev, Node cur) {
    if (cur == null) return prev;
    Node next = cur.next;
    cur.next = prev;
    return reverseSinglyLinkedListCore(cur, next);
  }

  private static Node reverseSinglyLinkedList2(Node n) {
    if (n == null) return null;

    Stack<Node> stack = new Stack<>();
    while (n != null) {
      stack.push(n);
      n = n.next;
    }

    Node cur = stack.pop();
    n = cur;
    while (!stack.isEmpty()) {
      cur.next = stack.pop();
      cur = cur.next;
    }
    cur.next = null;

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

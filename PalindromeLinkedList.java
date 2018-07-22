import java.util.Stack;

public class PalindromeLinkedList {

  public static void main(String[] args) {
    Node root = new Node(0);
    root.append(1);
    root.append(2);
    root.append(2);
    root.append(1);
    root.append(0);

    System.out.println(String.valueOf(isPalindrome(root)));
  }

  private static boolean isPalindrome(Node n) {
    Stack<Node> stack = new Stack<>();
    Node cur = n;
    while (cur != null) {
      stack.push(cur);
      cur = cur.next;
    }
    boolean diffFound = false;
    cur = n;
    while (cur != null) {
      if (!stack.pop().equals(cur)) {
        diffFound = true;
        break;
      }
      cur = cur.next;
    }
    return !diffFound;
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

    @Override
    public boolean equals(Object o) {
      if (o instanceof Node) {
        return ((Node) o).val == val;
      } else return false;
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

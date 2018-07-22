import java.util.HashSet;

public class FindStartOfLoopLL {
  public static void main(String[] args) {
    Node l = new Node(0);
    Node looper = new Node(67);
    l.next = new Node(1);
    l.next.next = new Node(2);
    l.next.next.next = looper;
    l.next.next.next.next = new Node(3);
    l.next.next.next.next.next = new Node(4);
    l.next.next.next.next.next.next = looper;

    System.out.println(String.valueOf(findStartOfLoop(l).val));
  }

  private static Node findStartOfLoop(Node l) {
    HashSet<Node> set = new HashSet<>();
    Node cur = l;
    while (cur != null) {
      if (set.contains(cur)) return cur;
      else set.add(cur);
      cur = cur.next;
    }
    return null;
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

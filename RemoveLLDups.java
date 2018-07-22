import java.util.HashSet;

public class RemoveLLDups {
  public static void main(String[] args) {
    Node root = new Node(0);
    root.append(1);
    root.append(2);
    root.append(3);
    root.append(4);
    root.append(5);
    printNodes(root);
    root.append(1);
    root.append(2);
    root.append(3);
    root.append(4);
    root.append(5);
    printNodes(root);
    removeDupsNoHashSet(root);
    printNodes(root);
  }

  private static Node removeDups(Node root) {
    if (root == null) return root;

    HashSet<Integer> set = new HashSet<>();
    set.add(root.val);

    Node prev = root;
    Node cur = root.next;
    while (cur != null) {
      if (set.contains(cur.val)) {
        prev.next = cur.next;
      } else {
        set.add(cur.val);
        prev = cur;
      }
      cur = cur.next;
    }

    return root;
  }

  private static Node removeDupsNoHashSet(Node root) {
    Node cur = root;
    while (cur != null) {
      Node runner = cur;
      while (runner.next != null) {
        if (runner.next.val == cur.val) {
          runner.next = runner.next.next;
        } else {
          runner = runner.next;
        }
      }
      cur = cur.next;
    }
    return root;
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

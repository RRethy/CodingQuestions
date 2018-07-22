import java.util.HashSet;

public class IntersectionLL {

  public static void main(String[] args) {
    Node l1 = new Node(0);
    l1.append(1);
    l1.append(2);
    l1.append(3);
    l1.append(4);

    Node l2 = new Node(5);
    l2.append(6);
    l2.append(7);
    l2.append(8);
    l2.append(9);
    l2.append(10);

    System.out.println(String.valueOf(findIntersectionNoSet(l1, l2) == null));
    System.out.println(String.valueOf(findIntersectionSet(l1, l2) == null));
  }

  private static Node findIntersectionNoSet(Node l1, Node l2) {
    if (l1 == null || l2 == null) return null;

    Result res1 = findLengthAndTail(l1);
    Result res2 = findLengthAndTail(l2);

    if (res1.tail != res2.tail || res1.tail == null) return null;

    int len1 = res1.len;
    int len2 = res2.len;

    Node cur1 = l1;
    Node cur2 = l2;

    while (len1 != len2) {
      if (len1 > len2) {
        len1--;
        cur1 = cur1.next;
      } else {
        len2--;
        cur2 = cur2.next;
      }
    }

    while (cur1 != cur2) {
      cur1 = cur1.next;
      cur2 = cur2.next;
    }

    return cur1;
  }

  private static Result findLengthAndTail(Node l) {
    int len = 0;
    Node prev = null;
    Node cur = l;
    while (cur != null) {
      len++;
      prev = cur;
      cur = cur.next;
    }
    Result res = new Result();
    res.len = len;
    res.tail = prev;
    return res;
  }

  public static class Result {
    int len;
    Node tail;
  }

  private static Node findIntersectionSet(Node l1, Node l2) {
    HashSet<Node> nodesSeen = new HashSet<>();
    Node cur = l1;
    Node intersection = null;
    while (cur != null) {
      nodesSeen.add(cur);
      cur = cur.next;
    }
    cur = l2;
    while (cur != null) {
      if (nodesSeen.contains(cur)) return cur;
      else cur = cur.next;
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

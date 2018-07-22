public class AddLL {
  public static void main(String[] args) {
    Node l1 = new Node(6);
    l1.append(1);
    l1.append(7);

    Node l2 = new Node(2);
    l2.append(9);
    l2.append(5);
    l2.append(9);

    Node sumNode = addLinkedListsWrapper(l1, l2);
    printNodes(sumNode);

    sumNode = addLL2Wrapper(l1, l2);
    printNodes(sumNode);
  }

  /**
   * This is for ll in reverse order
   */
  private static Node addLL2Wrapper(Node l1, Node l2) {
    return addLL2Core(l1, l2, 0);
  }

  private static Node addLL2Core(Node l1, Node l2, int carry) {
    if (l1 == null && l2 == null && carry == 0) return null;
    int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
    Node newNode = new Node(val % 10);
    newNode.next = addLL2Core(l1 == null ? null : l1.next,
        l2 == null ? null : l2.next,
        val / 10);
    return newNode;
  }

  /**
   * This is for ll in non reverse order
   */
  private static Node addLinkedListsWrapper(Node l1, Node l2) {
    Node n = new Node(-1);
    int carry = addLinkedLists(n, l1, l2);
    if (carry > 0) {
      n.val = carry;
      return n;
    } else return n.next;
  }

  private static int addLinkedLists(Node newN, Node l1, Node l2) {
    if (l1 == null && l2 == null) {
      return 0;
    } else if (l1 == null) {
      newN.next = l2;
      return 0;
    } else if (l2 == null) {
      newN.next = l1;
      return 0;
    } else {
      Node newSum = new Node(-1);
      int sum = l1.val + l2.val + addLinkedLists(newSum, l1.next, l2.next);
      newSum.val = sum % 10;
      int carry = sum / 10;
      newN.next = newSum;
      return carry;
    }
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

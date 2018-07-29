public class StackMinOOne {

  public static void main(String[] args) {
    StackMin stack = new StackMin();
    stack.push(5);
    stack.push(2);
    stack.push(4);
    stack.push(3);
    stack.push(2);
    stack.push(2);
    stack.push(4);
    stack.printStack();
    System.out.println(String.format("Popped: %d", stack.pop()));
    System.out.println(String.format("Popped: %d", stack.pop()));
    System.out.println(String.format("Popped: %d", stack.pop()));
    System.out.println(String.format("Popped: %d", stack.pop()));
    System.out.println(String.format("Popped: %d", stack.pop()));
    stack.printStack();
    System.out.println(String.format("Min: %d", stack.min()));
  }

  public static class StackMin {
    Node head;
    int len = 0;

    public void printStack() {
      Node cur = head;
      while (cur != null) {
        System.out.println(String.format("Node val: %d, min: %d", cur.val, cur.min));
        cur = cur.next;
      }
      System.out.println("Printed Stack!");
    }

    public void push(int val) {
      int newmin;
      if (head == null) {
        newmin = val;
      } else if (head.min > val) {
        newmin = val;
      } else {
        newmin = head.min;
      }

      Node newNode = new Node(val, newmin);
      newNode.next = head;
      head = newNode;
      len++;
    }

    public int pop() {
      if (head == null) {
        return -1;
      }

      Node popped = head;
      head = head.next;
      len--;
      return popped.val;
    }

    public int min() {
      if (len == 0) {
        return -1;
      }
      return head.min;
    }

    public boolean isEmpty() {
      return len == 0;
    }
  }

  public static class Node {
    int val;
    Node next;
    int min;

    public Node(int val, int min) {
      this.val = val;
      this.min = min;
    }
  }
}

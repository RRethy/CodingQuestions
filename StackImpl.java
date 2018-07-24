import java.lang.Exception;

public class StackImpl {
  public static void main(String[] args) {
    MyStack stack = new MyStack();
    stack.push(0);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    try {
      System.out.println(String.valueOf(stack.pop()));
      System.out.println(String.valueOf(stack.pop()));
      System.out.println(String.valueOf(stack.pop()));
      System.out.println(String.valueOf(stack.pop()));
      System.out.println(String.valueOf(stack.pop()));
      System.out.println(String.valueOf(stack.isEmpty()));
      System.out.println(String.valueOf(stack.pop()));
    } catch (Exception e) {
      System.out.println("CRASH");
    }
  }

  public static class MyStack {
    Node node;
    int size;

    public void push(int val) {
      this.size++;
      Node newTop = new Node(val);
      newTop.next = this.node;
      this.node = newTop;
    }

    public int pop() throws Exception {
      if (size == 0) throw new Exception();
      size--;
      Node popped = this.node;
      this.node = this.node.next;
      return popped.val;
    }

    public boolean isEmpty() {
      return size == 0;
    }
  }

  public static class Node {
    int val;
    Node next;
    public Node(int val) {
      this.val = val;
    }
  }
}

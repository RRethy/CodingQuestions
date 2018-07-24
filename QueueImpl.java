public class QueueImpl {
  public static void main(String[] args) {
    Queue queue = new Queue();
    queue.add(0);
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    System.out.println(String.valueOf(queue.pop()));
    System.out.println(String.valueOf(queue.pop()));
    System.out.println(String.valueOf(queue.pop()));
    System.out.println(String.valueOf(queue.pop()));
    System.out.println(String.valueOf(queue.pop()));
    System.out.println(String.valueOf(queue.isEmpty()));
    System.out.println(String.valueOf(queue.pop()));
  }

  public static class Queue {
    private int size;
    private Node tail;
    private Node head;

    private void add(int val) {
      Node newNode = new Node(val);
      size++;
      if (head == null) {
        assert tail == null;
        head = newNode;
        tail = newNode;
      } else {
        tail.next = newNode;
        tail = newNode;
      }
    }

    private int pop() {
      assert size > 0;
      assert head != null;
      assert tail != null;

      size--;

      Node popped = head;
      if (popped.next == null) {
        tail = null;
        head = null;
      } else {
        head = head.next;
      }

      return popped.val;
    }

    private boolean isEmpty() {
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

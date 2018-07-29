import java.util.Stack;

public class QueueBackedByStacks {
  public static void main(String[] args) {
    MyQueue q = new MyQueue();
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    q.add(5);
    q.add(6);
    q.add(7);
    q.add(8);
    q.remove();
    q.remove();
    q.remove();
    q.remove();
    q.remove();
    q.remove();
    q.remove();
    q.remove();
    System.out.println(String.format("Queue is empty: %b", q.len() == 0));
  }

  public static class MyQueue {
    Stack<Integer> newest = new Stack<>();
    Stack<Integer> oldest = new Stack<>();

    public void add(int val) {
      newest.push(val);
    }

    public int remove() {
      shift();
      return oldest.pop();
    }

    public int peek() {
      shift();
      return oldest.peek();
    }

    private void shift() {
      if (oldest.isEmpty()) {
        while (!newest.isEmpty()) {
          oldest.push(newest.pop());
        }
      }
    }

    public int len() {
      return newest.size() + oldest.size();
    }
  }
}

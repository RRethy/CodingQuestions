import java.util.Stack;

public class SortStack {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(2);
    stack.push(4);
    stack.push(10);
    stack.push(3);
    stack.push(7);
    stack.push(1);
    stack.push(6);
    stack.push(5);
    stack.push(8);
    stack.push(9);

    sortStack(stack);

    while (!stack.empty()) {
      System.out.println(String.format("%d", stack.pop()));
    }
  }

  /**
   * Uses a makeshift insertion sort
   */
  private static void sortStack(Stack<Integer> stack) {
    Stack<Integer> helperStack = new Stack<>();
    while (!stack.empty()) {
      int poppedVal = stack.pop();
      while (!helperStack.empty() && poppedVal < helperStack.peek()) {
        stack.push(helperStack.pop());
      }
      helperStack.push(poppedVal);
    }
    while (!helperStack.empty()) {
      stack.push(helperStack.pop());
    }
  }
}

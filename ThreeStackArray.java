public class ThreeStackArray {

  public static void main(String[] args) {
    TripleStack stack = new TripleStack(10);
    stack.pushOntoFirstStack(9);
    stack.pushOntoSecondStack(9);
    stack.pushOntoThirdStack(9);
    stack.printBackingArray();
    stack.pushOntoFirstStack(8);
    stack.pushOntoSecondStack(8);
    stack.pushOntoThirdStack(8);
    stack.printBackingArray();
    stack.pushOntoFirstStack(7);
    stack.pushOntoSecondStack(7);
    stack.pushOntoThirdStack(7);
    stack.printBackingArray();
    System.out.println(String.format("Popping from first stack: %d", stack.popFirstStack()));
    System.out.println(String.format("Popping from second stack: %d", stack.popSecondStack()));
    System.out.println(String.format("Popping from third stack: %d", stack.popThirdStack()));
    stack.printBackingArray();
    System.out.println(String.format("Checking if empty first stack: %b", stack.isEmptyFirstStack()));
    System.out.println(String.format("Checking if empty second stack: %b", stack.isEmptySecondStack()));
    System.out.println(String.format("Checking if empty third stack: %b", stack.isEmptyThirdStack()));
    stack.printBackingArray();
  }

  public static class TripleStack {
    int[] stacks;
    int stack1Index;
    int stack2Index;
    int stack3Index;

    public TripleStack(int singleStackSize) {
      this.stacks = new int[singleStackSize * 3];
      this.stack1Index = singleStackSize;
      this.stack2Index = singleStackSize * 2;
      this.stack3Index = singleStackSize * 3;
    }

    public void pushOntoFirstStack(int val) {
      stack1Index--;
      if (stack1Index < 0) {
        System.out.println("Push onto first stack failed for IOOB");
        return;
      }

      this.stacks[stack1Index] = val;
    }

    public void pushOntoSecondStack(int val) {
      stack2Index--;
      if (stack2Index < stacks.length / 3) {
        System.out.println("Push onto second stack failed for IOOB");
        return;
      }

      this.stacks[stack2Index] = val;
    }

    public void pushOntoThirdStack(int val) {
      stack3Index--;
      if (stack3Index < stacks.length / 3 * 2) {
        System.out.println("Push onto third stack failed for IOOB");
        return;
      }

      this.stacks[stack3Index] = val;
    }

    public int popFirstStack() {
      if (stack1Index >= stacks.length / 3) {
        System.out.println("Unable to pop from first stack");
        return -1;
      }

      int val = stacks[stack1Index];
      stacks[stack1Index] = 0;
      stack1Index++;
      return val;
    }

    public int popSecondStack() {
      if (stack2Index >= stacks.length / 3 * 2) {
        System.out.println("Unable to pop from second stack");
        return -1;
      }

      int val = stacks[stack2Index];
      stacks[stack2Index] = 0;
      stack2Index++;
      return val;
    }

    public int popThirdStack() {
      if (stack3Index >= stacks.length) {
        System.out.println("Unable to pop from third stack");
        return -1;
      }

      int val = stacks[stack3Index];
      stacks[stack3Index] = 0;
      stack3Index++;
      return val;
    }

    public boolean isEmptyFirstStack() {
      return stack1Index >= stacks.length / 3;
    }

    public boolean isEmptySecondStack() {
      return stack2Index >= stacks.length / 3 * 2;
    }

    public boolean isEmptyThirdStack() {
      return stack3Index >= stacks.length;
    }

    public void printBackingArray() {
      System.out.println(String.format("Array len: %d", stacks.length));
      System.out.print("[");
      for (int i = 0; i < stacks.length; i++) {
        if (i != 0 && i % 10 == 0) {
          System.out.print("], [");
        }
        System.out.print(String.valueOf(this.stacks[i]));
        if (i + 1 != stacks.length && i + 1 != stacks.length / 3 * 2 && i + 1 != stacks.length / 3) {
          System.out.print(", ");
        }
      }
      System.out.println("]");
    }
  }
}
